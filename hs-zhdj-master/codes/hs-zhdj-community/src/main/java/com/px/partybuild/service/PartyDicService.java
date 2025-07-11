package com.px.partybuild.service;

import com.px.partybuild.model.*;

import java.util.HashMap;
import java.util.List;

/**
 * 字典
 *
 * @author H
 */
public interface PartyDicService {

    /**
     * 获取组织类别
     * @return
     */
    List<ZzzdZzlbdmnew> getZzlbdmList();

    /**
     * 获取基层组织分类
     * @return
     */
    List<ZzzdJczzflnew> getJczzflList();

    /**
     * 选举方式
     * @return
     */
    List<ZzzdXjfsdm> getXjfslList();

    /**
     * 党内职务
     * @return
     */
    List<ZzzdZwmc> getZwmcList();

    /**
     * 任职方式
     * @return
     */
    List<ZzzdRzfs> getRzfsList();

    /**
     * 职务级别
     * @return
     */
    List<ZdDzzwjbm> getdzzwjbmList();

    /**
     * 人员状态
     * @return
     */
    List<ZzzdRyzt> getRyztList();


    /**
     * 工作岗位
     * @return
     */
    List<ZzzdGzgw> getGzgwList();

    /**
     * 出国出境原因
     * @return
     */
    List<HashMap<String, Object>> getCglbList();

    /**
     * 出国出境类别
     * @return
     */
    List<HashMap<String, Object>> getCgcjlbList();

    /**
     * 培训情况
     * @return
     */
    List<HashMap<String, Object>> getPxqkList();

    /**
     * 一线情况
     * @return
     */
    List<HashMap<String, Object>> getYxqkList();

    /**
     * 最近培训结果
     * @return
     */
    List<HashMap<String, Object>> getZjpxjgList();

    /**
     * 专职或兼职情况
     * @return
     */
    List<HashMap<String, Object>> getZzjzqkList();


    /**
     * 职务级别2
     * @return
     */
    List<HashMap<String, Object>> getdzzwjbm2List();

    /**
     * 学历
     * @return
     */
    List<HashMap<String, Object>> getEducationList();


    /**
     * 民族
     * @return
     */
    List<HashMap<String, Object>> getNationList();


    /**
     * 查询人员条件字典
     * @return
     */
    List<HashMap<String, Object>> getUserDicList();

}
