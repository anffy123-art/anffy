package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.AppConfig;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.JfysService;
import com.px.partybuild.service.UserService;
import com.px.partybuild.util.MapUtils;
import com.px.partybuild.vo.YsJfysmxVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("jFYSService")
public class JfysServiceServiceImpl implements JfysService {

    @Autowired
    private YsHdbzMapper hdbzMapper;

    @Autowired
    private YsJfysMapper ysJfysMapper;

    @Autowired
    private YsJfysmxMapper ysJfysmxMapper;

    @Autowired
    private ZzZzqkxxMapper zzZzqkxxMapper;

    @Autowired
    private PartyCQuery partyCquery;

    @Autowired
    private PartyUserCQuery partyUserCquery;

    @Autowired
    private UserService userService;

    @Autowired
    private MapUtils mapUtils;

    @Autowired
    protected AppConfig appConfig;

    @Autowired
    private YsJfysCQuery ysJfysCquery;

    @Override
    public PageInfo<Map<String, Object>> selectHdbzList(Integer nd, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        YsHdbzExample exp = new YsHdbzExample();
        YsHdbzExample.Criteria criteria = exp.or();
        if (nd != null) {
            criteria.andNdEqualTo(nd);
        }
        List<YsHdbz> list = hdbzMapper.selectByExample(exp);
        /*
        for (YsHdbz it : list) {
            it.setCjrname(userService.getUserInfobyId(it.getCjr()).getName());
        }*/
        PageInfo<Map<String, Object>> pList = new PageInfo(list);
        return pList;
    }

    @Override
    public List<YsJfysmxVo> selectYsjybmxList(Integer nd) {

        YsJfysExample exp = new YsJfysExample();
        YsJfysExample.Criteria criteria = exp.or();
        if (nd != null) {
            criteria.andNdEqualTo(nd);
        }
        List<YsJfys> list = ysJfysMapper.selectByExample(exp);
        List<YsJfysmxVo> mlist = new ArrayList<>();
        //如果已经生成过
        if (list.size() > 0) {
            mlist = ysJfysCquery.selectYsjybmxList(list.get(0).getJfysid());
            /*YsJfysmxExample mxexp = new YsJfysmxExample();
            YsJfysmxExample.Criteria mxcriteria = mxexp.or();
            mxcriteria.andJfysidEqualTo(list.get(0).getJfysid());
            List<YsJfysmx> mxlist = ysJfysmxMapper.selectByExample(mxexp);

            for (YsJfysmx it : mxlist) {
                Map<String, Object> mit = mapUtils.objectToMap(it);
                ZzZzqkxxExample example = new ZzZzqkxxExample();
                ZzZzqkxxExample.Criteria partycriteria = example.or();

                partycriteria.andDzzdmEqualTo(mit.get("dzzdm").toString());
                mit.put("DZZMC", zzZzqkxxMapper.selectByExample(example).get(0).getDzzmc());
                mlist.add(mit);
            }*/
        } else {
            return createJfysbmx(nd);
        }
        return mlist;
    }

    private List<YsJfysmxVo> createJfysbmx(Integer nd) {
        YsHdbz exp = new YsHdbz();
        exp.setNd(nd);
        YsHdbz hdbz = selectByExample(exp).get(0);
        List<Map<String, Object>> list = ysJfysCquery.selectPartyAndUserTotal(appConfig.gddwdm);
        List<YsJfysmxVo> voList= new ArrayList<>();
        for (Map<String, Object> it : list) {
            //党支部经费小计
            int v1hdbz = Integer.parseInt(it.get("v1sl").toString()) * hdbz.getV1(),
                    v2hdbz = Integer.parseInt(it.get("v2sl").toString()) * hdbz.getV2(),
                    v3hdbz = Integer.parseInt(it.get("v3sl").toString()) * hdbz.getV3(),
                    v4hdbz = Integer.parseInt(it.get("v4sl").toString()) * hdbz.getV4();

            it.put("dzbjfxj", v1hdbz + v2hdbz + v3hdbz + v4hdbz);
            it.put("v1hdbz", v1hdbz);
            it.put("v2hdbz", v2hdbz);
            it.put("v3hdbz", v3hdbz);
            it.put("v4hdbz", v4hdbz);

            //核定标准之和
            it.put("hdbz", Integer.parseInt(it.get("zgdyrs").toString()) * hdbz.getHdbz());
            //系统预算总额
            it.put("xtysze", v1hdbz + v2hdbz + v3hdbz + v4hdbz + Integer.parseInt(it.get("zgdyrs").toString()) * hdbz.getHdbz());
            //实际预算总额（默认为系统预算总额）
            it.put("sjysze", v1hdbz + v2hdbz + v3hdbz + v4hdbz + Integer.parseInt(it.get("zgdyrs").toString()) * hdbz.getHdbz());
            voList.add(mapUtils.mapToObject(it,YsJfysmxVo.class));
        }
        return voList;
    }

    @Override
    public PageInfo<Map<String, Object>> selectYsjybList(Integer nd, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        YsJfysExample exp = new YsJfysExample();
        YsJfysExample.Criteria criteria = exp.or();
        if (nd != null) {
            criteria.andNdEqualTo(nd);
        }
        List<YsJfys> list = ysJfysMapper.selectByExample(exp);
        /*
        for (YsJfys it : list) {
            it.setCjrName(userService.getUserInfobyId(it.getCjr()).getName());
        }*/
        PageInfo<Map<String, Object>> pList = new PageInfo(list);
        return pList;
    }

    @Override
    public int saveHdbz(YsHdbz model) {
        int result = 0;
        if (StringUtils.isBlank(model.getHdbzid())) {
            model.setHdbzid(UUID.randomUUID().toString());
            model.setCjsj(new Date());
            result = hdbzMapper.insert(model);
        } else {
            result = hdbzMapper.updateByPrimaryKey(model);
        }
        return result;
    }

    @Override
    public int removeHdbz(String id) {
        return hdbzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<YsHdbz> selectByExample(YsHdbz model) {
        YsHdbzExample exp = new YsHdbzExample();
        YsHdbzExample.Criteria criteria = exp.or();

        if (model.getHdbzid() != null) {
            criteria.andNdEqualTo(model.getNd()).andHdbzidNotEqualTo(model.getHdbzid());
        } else {
            criteria.andNdEqualTo(model.getNd());
        }
        List<YsHdbz> list = hdbzMapper.selectByExample(exp);
        return list;
    }

    @Override
    public RequsetData<String> saveYsjybmx(Map<String, Object> reqMap) {
        RequsetData<String> res = new RequsetData<String>();
        int result = 0;
        YsJfys model = mapUtils.mapToObject((Map<String, Object>) reqMap.get("item"), YsJfys.class);
        List<Map<String, Object>> jfysbmxlist = (List<Map<String, Object>>) reqMap.get("detailslist");

        model = saveJfysb(model);

        //删除原先记录
        YsJfysmxExample exp = new YsJfysmxExample();
        YsJfysmxExample.Criteria criteria = exp.or();
        criteria.andJfysidEqualTo(model.getJfysid());
        ysJfysmxMapper.deleteByExample(exp);

        for (Map<String, Object> it : jfysbmxlist) {
            YsJfysmx jfysbmx = mapUtils.mapToObject(it, YsJfysmx.class);
            jfysbmx.setYsmxid(UUID.randomUUID().toString());
            jfysbmx.setJfysid(model.getJfysid());
            result = ysJfysmxMapper.insert(jfysbmx);
        }
        if (result > 0) {
            res.setSuccess(true);
            res.setMsg("生成成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("生成失败");
        }
        return res;
    }

    public YsJfys saveJfysb(YsJfys model) {
        int result = 0;
        YsJfysExample exp = new YsJfysExample();
        YsJfysExample.Criteria criteria = exp.or();
        criteria.andNdEqualTo(model.getNd());
        List<YsJfys> list = ysJfysMapper.selectByExample(exp);
        if (list.size() == 0) {
            model.setJfysid(UUID.randomUUID().toString());
            model.setCjsj(new Date());
            result = ysJfysMapper.insert(model);
        } else {
            model = list.get(0);
        }
        return model;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class )
    public int deleteJfysb(String jfysbid) {
        YsJfysmxExample exp = new YsJfysmxExample();
        YsJfysmxExample.Criteria criteria = exp.or();
        criteria.andJfysidEqualTo(jfysbid);
        ysJfysmxMapper.deleteByExample(exp);
        ysJfysMapper.deleteByPrimaryKey(jfysbid);
        return 1;
    }
}
