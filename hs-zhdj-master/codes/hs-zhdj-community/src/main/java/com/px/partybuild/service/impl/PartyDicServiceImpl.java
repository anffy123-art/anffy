package com.px.partybuild.service.impl;

import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.PartyDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 字典
 *
 * @author H
 */
@Service("partyDicService")
public class PartyDicServiceImpl implements PartyDicService {

    @Autowired
    private ZzzdZzlbdmnewMapper zzzdZzlbdmMapper;
    @Autowired
    private ZzzdJczzflnewMapper zzzdJczzflMapper;
    @Autowired
    private ZzzdXjfsdmMapper zzzdXjfsdmMapper;
    @Autowired
    private ZzzdZwmcMapper zzzdZwmcMapper;
    @Autowired
    private ZzzdRzfsMapper zzzdRzfsMapper;
    @Autowired
    private ZdDzzwjbmMapper zdDzzwjbmMapper;
    @Autowired
    private ZzzdRyztMapper zzzdRyztMapper;
    @Autowired
    private ZzzdGzgwMapper zzzdGzgwMapper;
    @Autowired
    private PartyDictionaryCQuery partyDictionaryCquery;

    /**
     * 获取组织类别
     **/
    @Override
    public List<ZzzdZzlbdmnew> getZzlbdmList() {
        ZzzdZzlbdmnewExample exp = new ZzzdZzlbdmnewExample();
        exp.setOrderByClause("XH ASC");
        return zzzdZzlbdmMapper.selectByExample(exp);
    }

    /**
     * 获取基层组织分类
     **/
    @Override
    public List<ZzzdJczzflnew> getJczzflList() {
        ZzzdJczzflnewExample exp = new ZzzdJczzflnewExample();
        exp.setOrderByClause("XH ASC");
        return zzzdJczzflMapper.selectByExample(exp);
    }

    /**
     * 选举方式
     **/
    @Override
    public List<ZzzdXjfsdm> getXjfslList() {
        ZzzdXjfsdmExample exp = new ZzzdXjfsdmExample();
        exp.setOrderByClause("XH ASC");
        return zzzdXjfsdmMapper.selectByExample(exp);
    }

    /**
     * 党内职务
     **/
    @Override
    public List<ZzzdZwmc> getZwmcList() {
        ZzzdZwmcExample exp = new ZzzdZwmcExample();
        exp.setOrderByClause("XH ASC");
        return zzzdZwmcMapper.selectByExample(exp);
    }

    /**
     * 任职方式
     **/
    @Override
    public List<ZzzdRzfs> getRzfsList() {
        ZzzdRzfsExample exp = new ZzzdRzfsExample();
        exp.setOrderByClause("XH ASC");
        return zzzdRzfsMapper.selectByExample(exp);
    }

    /**
     * 职务级别
     **/
    @Override
    public List<ZdDzzwjbm> getdzzwjbmList() {
        ZdDzzwjbmExample exp = new ZdDzzwjbmExample();
        exp.setOrderByClause("XH ASC");
        return zdDzzwjbmMapper.selectByExample(exp);
    }

    /**
     * 人员状态
     **/
    @Override
    public List<ZzzdRyzt> getRyztList() {
        ZzzdRyztExample exp = new ZzzdRyztExample();
        exp.setOrderByClause("XH ASC");
        return zzzdRyztMapper.selectByExample(exp);
    }

    /**
     * 工作岗位
     **/
    @Override
    public List<ZzzdGzgw> getGzgwList() {
        ZzzdGzgwExample exp = new ZzzdGzgwExample();
        exp.setOrderByClause("XH ASC");
        return zzzdGzgwMapper.selectByExample(exp);
    }

    /**
     * @Description //TODO 出国出境原因
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getCglbList() {
        return partyDictionaryCquery.selectCglbList();
    }

    /**
     * @Description //TODO 出国出境类别
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getCgcjlbList() {
        return partyDictionaryCquery.selectCgcjlbList();
    }

    /**
     * @Description //TODO 培训情况
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getPxqkList() {
        return partyDictionaryCquery.selectPxqkList();
    }

    /**
     * @Description //TODO 一线情况
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getYxqkList() {
        return partyDictionaryCquery.selectYxqkList();
    }

    /**
     * @Description //TODO 最近培训结果
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getZjpxjgList() {
        return partyDictionaryCquery.selectZjpxjgList();
    }

    /**
     * @Description //TODO 专职或兼职情况
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getZzjzqkList() {
        return partyDictionaryCquery.selectZzjzqkList();
    }

    /**
     * @Description //TODO 职务级别2
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getdzzwjbm2List() {
        return partyDictionaryCquery.selectDzzwjbm2List();
    }


    /**
     * @Description //TODO 学历
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getEducationList() {
        return partyDictionaryCquery.selectEducationList();
    }


    /**
     * @Description //TODO 民族
     * @date 2024-08
     * @Param []
     **/
    @Override
    public List<HashMap<String, Object>> getNationList() {
        return partyDictionaryCquery.selectNationList();
    }



    @Override
    public List<HashMap<String, Object>> getUserDicList() {
        return partyDictionaryCquery.selectUserDicList();
    }


}
