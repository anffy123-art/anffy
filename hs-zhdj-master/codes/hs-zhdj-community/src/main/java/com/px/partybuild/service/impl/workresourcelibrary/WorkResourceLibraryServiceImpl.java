package com.px.partybuild.service.impl.workresourcelibrary;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.mapper.CfFileMapper;
import com.px.partybuild.mapper.DjWorkresourcelibraryCQuery;
import com.px.partybuild.mapper.DjWorkresourcelibraryMapper;
import com.px.partybuild.mapper.DjWorkresourcelibrarytypeMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.workresourcelibrary.WorkResourceLibraryService;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.DjWorkresourcelibraryVo;
import com.px.partybuild.vo.DsjTreeFiletype;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author H
 * @date 2024-08
 */
@Service("WorkResourceLibraryService")
public class WorkResourceLibraryServiceImpl implements WorkResourceLibraryService {

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private DjWorkresourcelibraryMapper djWorkresourcelibraryMapper;

    @Autowired
    private DjWorkresourcelibrarytypeMapper djWorkresourcelibrarytypeMapper;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private CfFileMapper cfFileMapper;

    @Autowired
    private DjWorkresourcelibraryCQuery djWorkresourcelibraryCQuery;

    @Override
    public PageInfo<DjWorkresourcelibraryVo> getFilesByType(String fileTypeId, String fileName, int pageIndex, int pageSize) {

        List<String> fileTypeIds = findFileTypeAndChildren(fileTypeId);

        PageHelper.startPage(pageIndex, pageSize);
        List<DjWorkresourcelibraryVo> flist = djWorkresourcelibraryCQuery.getFilesByKey(fileName, fileTypeIds);

        PageInfo<DjWorkresourcelibraryVo> pList = new PageInfo(flist);
        return pList;
    }

    @Override
    public PageInfo<DjWorkresourcelibraryVo> getFilesByKey(String fileName, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);

        List<DjWorkresourcelibraryVo> flist = djWorkresourcelibraryCQuery.getFilesByKey(fileName, null);
        PageInfo<DjWorkresourcelibraryVo> pList = new PageInfo(flist);

        return pList;
    }

    protected List<String> findFileTypeAndChildren(String fileTypeId) {

        List<String> fileTypeids = new ArrayList<>();

        DjWorkresourcelibrarytype filetype = djWorkresourcelibrarytypeMapper.selectByPrimaryKey(fileTypeId);

        if (filetype != null) {
            fileTypeids.add(filetype.getFiletypeid());
            getFileTypeChildren(filetype.getFiletypeid(), fileTypeids);
        }

        return fileTypeids;
    }

    protected void getFileTypeChildren(String parentfileTypeId, List<String> ids) {
        DjWorkresourcelibrarytypeExample exp = new DjWorkresourcelibrarytypeExample();
        exp.or().andParenttypeidEqualTo(parentfileTypeId);
        List<DjWorkresourcelibrarytype> typeChildren = djWorkresourcelibrarytypeMapper.selectByExample(exp);

        typeChildren.forEach(it -> {
            ids.add(it.getFiletypeid());
            this.getFileTypeChildren(it.getFiletypeid(), ids);
        });

    }

    @Override
    public List<DsjTreeFiletype> getFileTreeByParent(String parentId, List<String> typeIds, List<String> passTypeIds) {

        return djWorkresourcelibraryCQuery.selectTreeFiles(parentId, null, typeIds, passTypeIds);
    }

    @Override
    public PageInfo<Map<String, Object>> selectFiletypeList(String typename, String parentId, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<DsjTreeFiletype> list = djWorkresourcelibraryCQuery.selectTreeFiles(parentId, typename, null, null);
        PageInfo<Map<String, Object>> pList = new PageInfo(list);
        return pList;
    }

    @Override
    public DjWorkresourcelibrarytype getFiletype(String typeid) {

        DjWorkresourcelibrarytype filetype = djWorkresourcelibrarytypeMapper.selectByPrimaryKey(typeid);
        return filetype;
    }

    @Override
    public int deleteFiletype(String id) {
        DjWorkresourcelibrarytypeExample exp = new DjWorkresourcelibrarytypeExample();
        DjWorkresourcelibrarytypeExample.Criteria criteria = exp.or();
        criteria.andParenttypeidEqualTo(id);
        djWorkresourcelibrarytypeMapper.deleteByExample(exp);
        return djWorkresourcelibrarytypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public RequsetData<String> saveFiletype(DjWorkresourcelibrarytype model) {
        RequsetData<String> res = new RequsetData<String>();
        int result = 0;
        DjWorkresourcelibrarytype item = djWorkresourcelibrarytypeMapper.selectByPrimaryKey(model.getFiletypeid());
        if (item == null) {
            model.setFiletypeid(UUID.randomUUID().toString());
            result = djWorkresourcelibrarytypeMapper.insert(model);
        } else {
            item.setFiletypename(model.getFiletypename());
            item.setParenttypeid(model.getParenttypeid());
            item.setTreelevel(model.getTreelevel());
            result = djWorkresourcelibrarytypeMapper.updateByPrimaryKeySelective(item);
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
    public DjWorkresourcelibrary getFileInfo(String fileId) {

        return djWorkresourcelibraryMapper.selectByPrimaryKey(fileId);
    }

    @Override
    public int deleteFile(String id) {
        return djWorkresourcelibraryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public RequsetData<String> saveFile(DjWorkresourcelibrary model, String userId) {
        RequsetData<String> res = new RequsetData<String>();
        int result = 0;
        DjWorkresourcelibrary item = djWorkresourcelibraryMapper.selectByPrimaryKey(model.getFileid());
        if (item == null) {
            model.setCreatedatetime(new Date());
            model.setCreateuserid(userId);
            model.setUpdatedatetime(new Date());
            model.setUpdateuserid(userId);
            result = djWorkresourcelibraryMapper.insert(model);
        } else {
            item.setFilename(model.getFilename());
            item.setFilecode(model.getFilecode());
            item.setFiletypeid(model.getFiletypeid());
            item.setFilecode2(model.getFilecode2());
            item.setSsfl(model.getSsfl());
            model.setUpdatedatetime(new Date());
            model.setUpdateuserid(userId);
            result = djWorkresourcelibraryMapper.updateByPrimaryKeySelective(item);
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
        //return this.djWorkresourcelibraryMapper.selectAllFile();
        return null;
    }
}
