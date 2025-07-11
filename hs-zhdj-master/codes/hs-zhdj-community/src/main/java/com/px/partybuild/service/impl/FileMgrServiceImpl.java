package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.mapper.CfFileCQuery;
import com.px.partybuild.mapper.CfFileMapper;
import com.px.partybuild.mapper.DsjFilemrgMapper;
import com.px.partybuild.mapper.DsjFiletypeMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.FileMgrService;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.DsjTreeFiletype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 * @author H
 * @date 2024-08
 */
@Service("fileMgrService")
public class FileMgrServiceImpl implements FileMgrService {

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private DsjFilemrgMapper dsjFilemrgMapper;

    @Autowired
    private DsjFiletypeMapper dsjFiletypeMapper;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private CfFileMapper cfFileMapper;

    @Autowired
    private CfFileCQuery cfFileCQuery;

    @Override
    public PageInfo<DsjFilemrg> getFilesByType(String fileTypeId, String fileName, int pageIndex, int pageSize) {



        DsjFilemrgExample exp = new DsjFilemrgExample();
        DsjFilemrgExample.Criteria criteria = exp.createCriteria();

        if (!stringUtils.IsNullOrEmpty(fileName)){
            criteria.andFilenameLike("%" + fileName + "%");
        }
        if(!stringUtils.IsNullOrEmpty(fileTypeId)) {
            List<String> typeIds = findFileTypeAndChildren(fileTypeId);
            criteria.andFiletypeidIn(typeIds);
        }

        exp.setOrderByClause("cast((filecode) as SIGNED INTEGER ) asc");

        PageHelper.startPage(pageIndex, pageSize);
        List<DsjFilemrg> flist = dsjFilemrgMapper.selectByExample(exp);


        PageInfo<DsjFilemrg> pList = new PageInfo(flist);


        return pList;
    }

    @Override
    public PageInfo<DsjFilemrg> getFilesByKey(String fileName, int pageIndex, int pageSize) {

        DsjFilemrgExample exp = new DsjFilemrgExample();
        DsjFilemrgExample.Criteria criteria = exp.createCriteria();

        criteria.andFilenameLike("%"+fileName+"%");

        PageHelper.startPage(pageIndex, pageSize);
        //fileName

        List<DsjFilemrg> flist = dsjFilemrgMapper.selectByExample(exp);
        PageInfo<DsjFilemrg> pList = new PageInfo(flist);

        return pList;
    }

    protected List<String> findFileTypeAndChildren(String fileTypeId){

        List<String> fileTypeids=new ArrayList<>();

        DsjFiletype filetype =dsjFiletypeMapper.selectByPrimaryKey(fileTypeId);

        if(filetype!=null){
            fileTypeids.add(filetype.getFiletypeid());
            getFileTypeChildren(filetype.getFiletypeid(),fileTypeids);
        }

        return fileTypeids;
    }

    protected void getFileTypeChildren(String parentfileTypeId,List<String> ids){
        DsjFiletypeExample exp=new DsjFiletypeExample();
        exp.or().andParenttypeidEqualTo(parentfileTypeId);
        List<DsjFiletype> typeChildren=dsjFiletypeMapper.selectByExample(exp);

        typeChildren.forEach(it->{
            ids.add(it.getFiletypeid());
            this.getFileTypeChildren(it.getFiletypeid(),ids);
        });

    }

    @Override
    public List<DsjFiletype> getFileTypeRoot() {

        DsjFiletypeExample exp = new DsjFiletypeExample();
        exp.or().andParenttypeidIsNull();
        exp.setOrderByClause("treelevel asc");
        List<DsjFiletype> filesRoot = dsjFiletypeMapper.selectByExample(exp);

        return filesRoot;
    }

    @Override
    public List<DsjFiletype> getFileTypeByParent(String parentId) {
        DsjFiletypeExample exp = new DsjFiletypeExample();
        exp.or().andParenttypeidEqualTo(parentId);
        exp.setOrderByClause("treelevel asc");
        List<DsjFiletype> filetypes = dsjFiletypeMapper.selectByExample(exp);
        return filetypes;
    }

    @Override
    public List<DsjTreeFiletype> getFileTreeByParent(String parentId, List<String> typeIds, List<String> passTypeIds) {

        return cfFileCQuery.selectTreeFiles(parentId, null, typeIds, passTypeIds);
    }
    @Override
    public PageInfo<Map<String, Object>> selectFiletypeList(String typename,String parentId ,int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<DsjTreeFiletype> list = cfFileCQuery.selectTreeFiles(parentId, typename, null, null);
        PageInfo<Map<String, Object>> pList = new PageInfo(list);
        return pList;
    }
    @Override
    public DsjFiletype getFiletype(String typeid) {

        DsjFiletype filetype= dsjFiletypeMapper.selectByPrimaryKey(typeid);
        return  filetype;
    }
    @Override
    public int deleteFiletype(String id) {
        DsjFiletypeExample exp = new DsjFiletypeExample();
        DsjFiletypeExample.Criteria criteria = exp.or();
        criteria.andParenttypeidEqualTo(id);
        dsjFiletypeMapper.deleteByExample(exp);
        return dsjFiletypeMapper.deleteByPrimaryKey(id);
    }
    @Override
    public RequsetData<String>  saveFiletype(DsjFiletype model) {
        RequsetData<String> res = new RequsetData<String>();
        int result = 0;
        DsjFiletype item = dsjFiletypeMapper.selectByPrimaryKey(model.getFiletypeid());
        if (item==null) {
            model.setFiletypeid(UUID.randomUUID().toString());
            result = dsjFiletypeMapper.insert(model);
        } else {
            item.setFiletypename(model.getFiletypename());
            item.setParenttypeid(model.getParenttypeid());
            item.setTreelevel(model.getTreelevel());
            result =dsjFiletypeMapper.updateByPrimaryKeySelective(item);
        }
        if (result > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败");
        }
        return res;
    }
    @Override
    public DsjFilemrg getFileInfo(String fileId) {

        return dsjFilemrgMapper.selectByPrimaryKey(fileId);
    }
    @Override
    public int deleteFile(String id) {
        return dsjFilemrgMapper.deleteByPrimaryKey(id);
    }
    @Override
    public RequsetData<String> saveFile(DsjFilemrg model) {
        RequsetData<String> res = new RequsetData<String>();
        int result = 0;
        DsjFilemrg item = dsjFilemrgMapper.selectByPrimaryKey(model.getFileid());
        if (item==null) {
            result = dsjFilemrgMapper.insert(model);
        } else {
            item.setFilename(model.getFilename());
            item.setFilecode(model.getFilecode());
            item.setFiletypeid(model.getFiletypeid());
            item.setFilecode2(model.getFilecode2());
            result= dsjFilemrgMapper.updateByPrimaryKeySelective(item);
        }
        if (result > 0) {
            res.setSuccess(true);
            res.setMsg("保存成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("保存失败");
        }
        return res;
    }

    @Override
    public PageInfo<Map<String, Object>> FindFilesApp(String fileName, String fileTypeId, int pageIndex, int pageSize) {


        List<String> typeIds=new ArrayList<>();

        if(!stringUtils.IsNullOrEmpty(fileTypeId)) {
            typeIds = findFileTypeAndChildren(fileTypeId);

        }

        PageHelper.startPage(pageIndex, pageSize);
        PageHelper.orderBy("TREELEVEL asc,cast(filecode2 as unsigned int) asc");
        List<Map<String,Object>> list=cfFileCQuery.FindDSJ_File(fileName,typeIds);

        PageInfo<Map<String, Object>> pList = new PageInfo(list);

        return pList;
    }

    @Override
    public PageInfo<Map<String, Object>> getFileList(String fileRefID, Integer fileTypeId, int pageIndex, int pageSize) {

        //List<CfDictionary> dic_ztType=dictionaryService.getDictionaryListByDicTypeKey("FileMgrType");

        PageHelper.startPage(pageIndex, pageSize);
        //PageHelper.orderBy("to_number(filecode2) asc");

        CfFileExample exp = new CfFileExample();
        CfFileExample.Criteria cri = exp.or();
        exp.setOrderByClause("CREATETIME");
        if (fileTypeId != null) {
            cri.andFiletypeEqualTo(fileTypeId);
        }
        cri.andFilerefidEqualTo(fileRefID);

        cri.andOperatestateNotEqualTo("D");

        List<CfFile> flist = cfFileMapper.selectByExample(exp);
        List<Map<String, Object>> mList = new ArrayList<>();

        for (CfFile it : flist) {
            Map<String, Object> mit = mapUtils.objectToMap(it);
            mList.add(mit);
        }

        PageInfo<Map<String, Object>> pList = new PageInfo(mList);
        return pList;
    }

    @Override
    public List<Map<String, Object>> selectAllFile() {
        //return this.dsjFilemrgMapper.selectAllFile();
        return null;
    }
}
