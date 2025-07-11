package com.px.partybuild.service.impl;

import com.px.partybuild.mapper.MhCQuery;
import com.px.partybuild.mapper.MhLinkMapper;
import com.px.partybuild.mapper.MhMhflMapper;
import com.px.partybuild.mapper.MhSylmMapper;
import com.px.partybuild.model.*;
import com.px.partybuild.service.DictionaryService;
import com.px.partybuild.service.MhService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.MapUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("MhService")
public class MhServiceImpl implements MhService {

    @Autowired
    private MhMhflMapper mhMhflMapper;

    @Autowired
    private MhSylmMapper mhSylmMapper;

    @Autowired
    private MhCQuery mhCQuery;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private MhLinkMapper mhLinkMapper;
    @Autowired
    private com.px.partybuild.util.StringUtils stringUtils;
    @Autowired
    private DateUtils dateUtils;

    @Override
    public List<Map<String, Object>> SelectFlOneMcList(String flmc) {

        List<CfDictionary> dic_sfxsType = dictionaryService.getDictionaryListByDicTypeKey("ztType");

        List<Map<String, Object>> mList = mhCQuery.SelectFlOneMcList(flmc);

        mList.forEach(it -> {
            Integer isfxs = it.get("sfxs") != null ? Integer.parseInt(it.get("sfxs").toString()) : Integer.parseInt("1");
            it.put("sfxsName", dictionaryService.getDicByKey(isfxs, dic_sfxsType).getDicvalue());
            if (it.get("sjfl") != null) {
                MhMhfl sjFlItem = mhMhflMapper.selectByPrimaryKey(it.get("sjfl").toString());
                if (sjFlItem != null) {
                    it.put("sjflName", sjFlItem.getFlmc());
                }
            } else {
                it.put("sjflName", "根目录");
            }

        });


        return mList;
    }

    @Override
    public List<Map<String, Object>> SelectFlChildList(String sjfl) {

        List<CfDictionary> dic_sfxsType = dictionaryService.getDictionaryListByDicTypeKey("ztType");

        MhMhflExample exp = new MhMhflExample();
        MhMhflExample.Criteria criteria = exp.or();
        criteria.andSjflEqualTo(sjfl);
        List<MhMhfl> list = mhMhflMapper.selectByExample(exp);

        List<Map<String, Object>> mlist = new ArrayList<>();

        for (MhMhfl it : list) {
            Map<String, Object> mit = mapUtils.objectToMap(it);
            mit.put("sfxsName", dictionaryService.getDicByKey(it.getSfxs().intValue(), dic_sfxsType));
            mlist.add(mit);
        }

        return mlist;
    }


    @Override
    public int SaveMHFL(MhMhfl model) {
        int result = 0;
        if (StringUtils.isBlank(model.getMhflbs())) {
            model.setMhflbs(UUID.randomUUID().toString());
            model.setCjsj(new Date());
            int jb = StringUtils.isBlank(model.getSjfl()) ? 1 : 2;
            model.setJb(jb);
            result = mhMhflMapper.insert(model);
        } else {
            result = mhMhflMapper.updateByPrimaryKey(model);
        }
        return result;
    }

    @Override
    public String RemoveMHFL(String id) {
        String msg = "";
        MhMhfl model = mhMhflMapper.selectByPrimaryKey(id);
        MhMhflExample exp = new MhMhflExample();
        exp.or();
        exp.getOredCriteria().get(0).andSjflEqualTo(id);

        List<MhMhfl> children = mhMhflMapper.selectByExample(exp);
        if (children.size() == 0) {
            int row = mhMhflMapper.deleteByPrimaryKey(id);
        } else {
            msg = "先清除子分栏才能删除！";
        }

        return msg;
    }


    @Override
    public PageInfo<Map<String, Object>> SelectSylmList(String lmbt, int zt, int pageIndex, int pageSize) {

        List<CfDictionary> dic_ztType = dictionaryService.getDictionaryListByDicTypeKey("ztType");
        List<CfDictionary> dic_lmlxType = dictionaryService.getDictionaryListByDicTypeKey("lmlxType");

        MhSylmExample exp = new MhSylmExample();

        MhSylmExample.Criteria criteria1 = exp.or();

        if (StringUtils.isNoneBlank(lmbt)) {
            criteria1.andLmbtLike("%" + lmbt + "%");
        }

        if (zt > 0) {
            criteria1.andZtEqualTo(zt);
        }

        PageHelper.startPage(pageIndex, pageSize);
        List<MhSylm> list = mhSylmMapper.selectByExample(exp);

        PageInfo<MhSylm> oList = new PageInfo(list);

        List<Map<String, Object>> mList = new ArrayList<>();

        for (MhSylm it : oList.getList()) {

            Map<String, Object> mit = mapUtils.objectToMap(it);
            mit.put("ztName", dictionaryService.getDicByKey(it.getZt().intValue(), dic_ztType).getDicvalue());
            if (it.getLmlx() != null) {
                mit.put("lmlxName", dictionaryService.getDicByKey(it.getLmlx().intValue(), dic_lmlxType).getDicvalue());
            }

            mList.add(mit);
        }

        PageInfo<Map<String, Object>> pList = new PageInfo(mList);
        //pList.setPageSize(oList.getPageSize());
        //pList.setPages(oList.getPages());
        //pList.setPageNum(oList.getPageNum());
        pList.setTotal(oList.getTotal());

        return pList;
    }

    @Override
    public int SaveSylm(MhSylm model) {
        int result = 0;
        if (model.getCjsj() == null) {
            model.setCjsj(new Date());
            result = mhSylmMapper.insert(model);
        } else {
            result = mhSylmMapper.updateByPrimaryKey(model);
        }
        return result;
    }

    @Override
    public int RemoveSylm(String id) {
        return mhSylmMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<MhMhfl> SelectMhfLParent(String flmc, int pageIndex, int pageSize) {

        List<CfDictionary> dic_mhflJbType = dictionaryService.getDictionaryListByDicTypeKey("mhflJbType");

        MhMhflExample exp = new MhMhflExample();
        MhMhflExample.Criteria criteria = exp.or();
        if (StringUtils.isNoneBlank(flmc)) {
            criteria.andFlmcLike("%" + flmc + '%');
        }

        PageHelper.startPage(pageIndex, pageSize);
        List<MhMhfl> mlist = mhMhflMapper.selectByExample(exp);

        for (MhMhfl it : mlist) {
            it.setBz(dictionaryService.getDicByKey(it.getJb().intValue(), dic_mhflJbType).getDicvalue());
        }

        MhMhfl root = new MhMhfl();
        root.setMhflbs("");
        root.setFlmc("根目录");
        root.setJb(1);
        root.setBz(dictionaryService.getDicByKey(root.getJb(), dic_mhflJbType).getDicvalue());
        mlist.add(0, root);

        PageInfo<MhMhfl> pList = new PageInfo(mlist);

        return pList;
    }


    @Override
    public PageInfo<HashMap<String, Object>> getLinkList(int pageIndex, int pageSize, String title) {
        PageHelper.startPage(pageIndex, pageSize);
        List<HashMap<String, Object>> list = mhCQuery.selectLinkList(title);
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

    @Override
    public MhLink getLinkById(String id) {
        return mhLinkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int saveLink(MhLink data, String userId) {
        int result = 0;
        MhLink dbModel = getLinkById(data.getLinkid());
        if (dbModel == null || (dbModel != null && stringUtils.IsNullOrEmpty(dbModel.getLinkid()))) {
            data.setCreatetime(new Date());
            data.setCreateuserid(userId);

            result = mhLinkMapper.insert(data);
        } else {
            data.setModifytime(new Date());
            data.setModifyuserid(userId);

            result = mhLinkMapper.updateByPrimaryKey(data);
        }

        return result;
    }

    @Override
    public int deleteLink(String id) {
        return mhLinkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<HashMap<String, Object>> getSubjectList(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<HashMap<String, Object>> list = mhCQuery.selectSubjectList();
        PageInfo<HashMap<String, Object>> result = new PageInfo(list);
        return result;
    }

}
