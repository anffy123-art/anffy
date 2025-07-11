package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大数据
 *
 * @author H
 */
public interface BigDataService {

    /**
     * 查询大数据-党员动态
     *
     * @param nd
     * @param ndOrderBy
     * @return
     */
    List<DsjDydt> getDsjDydtList(Integer nd, Integer ndOrderBy);

    /**
     * 保存大数据-党员动态
     *
     * @param dsjDydtList
     * @return
     */
    int saveDsjDydt(List<DsjDydt> dsjDydtList);

    /**
     * 查询大数据-评先评优
     *
     * @param nd
     * @return
     */
    List<DsjPxpy> getDsjPxpyList(Integer nd);

    /**
     * 保存大数据-评先评优
     *
     * @param dsjPxpyList
     * @return
     */
    int saveDsjPxpy(List<DsjPxpy> dsjPxpyList);

    /**
     * 查询大数据-处置情况
     *
     * @param nd
     * @return
     */
    List<DsjCzqk> getDsjCzqkList(Integer nd);

    /**
     * 保存大数据-处置情况
     *
     * @param dsjCzqkList
     * @return
     */
    int saveDsjCzqk(List<DsjCzqk> dsjCzqkList);

    /**
     * 查询大数据-党内品牌
     *
     * @return
     */
    List<DsjDnpp> getDsjDnppList();

    /**
     * 保存大数据-党内品牌
     *
     * @param dsjDnppList
     * @return
     */
    int saveDsjDnpp(List<DsjDnpp> dsjDnppList);

    /**
     * 查询大数据-创岗建区
     *
     * @return
     */
    List<DsjCgjq> getDsjCgjqList();

    /**
     * 保存大数据-创岗建区
     *
     * @param dsjCgjqList
     * @return
     */
    int saveDsjCgjq(List<DsjCgjq> dsjCgjqList);

    /**
     * 查询大数据-发展党员情况
     *
     * @return
     */
    List<DsjFzdyqk> getDsjFzdyqkList();

    /**
     * 保存大数据-发展党员情况
     *
     * @param dsjFzdyqkList
     * @return
     */
    int saveDsjFzdyqk(List<DsjFzdyqk> dsjFzdyqkList);

    /**
     * 查询大数据-年度考评结果
     *
     * @param nd
     * @return
     */
    List<DsjNdkpjg> getDsjNdkpjgList(Integer nd);

    /**
     * 保存大数据-年度考评结果
     *
     * @param dsjNdkpjgList
     * @return
     */
    int saveDsjNdkpjg(List<DsjNdkpjg> dsjNdkpjgList);


    /**
     * 查询党组织分布情况
     *
     * @return
     */
    List<HashMap<String, Object>> getDzzfbqkList();

    /**
     * 统计党组织信息
     *
     * @param province
     * @return
     */
    HashMap<String, Object> getDzzxxCount(String province);

    /**
     * 统计党委信息
     *
     * @param province
     * @return
     */
    HashMap<String, Object> getDwxxCount(String province);

    /**
     * 统计党员信息
     *
     * @param province
     * @return
     */
    List<HashMap<String, Object>> getDyCount(String province);

    /**
     * 统计党员性别
     *
     * @param dzzdm
     * @param dwgzzlb
     * @param isOnduty
     * @return
     */
    List<HashMap<String, Object>> getDyxbCount(String dzzdm, Integer dwgzzlb, Integer isOnduty);

    /**
     * 统计党员年龄
     *
     * @param dzzdm
     * @param dwgzzlb
     * @param isOnduty
     * @return
     */
    List<HashMap<String, Object>> getDynlCount(String dzzdm, Integer dwgzzlb, Integer isOnduty);

    /**
     * 统计党员党龄
     *
     * @param dzzdm
     * @param dwgzzlb
     * @param isOnduty
     * @return
     */
    List<HashMap<String, Object>> getDydlCount(String dzzdm, Integer dwgzzlb, Integer isOnduty);

    /**
     * 统计政工职务党员
     *
     * @param dzzdm
     * @param dwgzzlb
     * @return
     */
    List<HashMap<String, Object>> getZgzwCount(String dzzdm, Integer dwgzzlb);

    /**
     * 人员状态
     *
     * @param partyGroup
     * @param isOnduty
     * @return
     */
    List<Map<String, Object>> countryzt(String partyGroup, Integer isOnduty);


    /**
     * 统计党员学历
     *
     * @param dzzdm
     * @param dwgzzlb
     * @param isOnduty
     * @return
     */
    List<Map<String, Object>> getUserEducationList(String dzzdm, Integer dwgzzlb, Integer isOnduty);

    /**
     * 统计三会一课
     *
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> getShykCount(String dzzdm);

    /**
     * 统计党组织分类信息
     *
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> getDzzxxList(String dzzdm);

    /**
     * 党员信息
     *
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> getDyxxList(String dzzdm);

    /**
     * 统计党建
     *
     * @param page
     * @param rows
     * @param zzfbType
     * @param beginTime
     * @param endTime
     * @return
     */
    PageInfo<HashMap<String, Object>> getAllDataTotal(int page, int rows, Integer zzfbType, String beginTime, String endTime);

    /**
     * 发展党员情况
     *
     * @param nd
     * @return
     */
    List<DsjDyfzqk> getdsjdyfzqklist(Integer nd);

    /**
     * 保存
     *
     * @param dsjNdkpjgList
     * @return
     */
    int savedsjdyfzqk(List<DsjDyfzqk> dsjNdkpjgList);

    /**
     * get
     *
     * @param ndList
     * @return
     */
    List<HashMap<String, Object>> getdyfzqktotallist(List<Integer> ndList);

    /**
     * 党组织统计
     *
     * @param dzzdm
     * @param ssdzzdm
     * @return
     */
    List<HashMap<String, Object>> getPartyCountList(String dzzdm, String ssdzzdm);

    /**
     * 领导人员5+3
     *
     * @param userCode
     * @param year
     * @return
     */
    List<HashMap<String, Object>> getUserLeaderTotalList(String userCode, String year);


    /**
     * 党员
     *
     * @param dzzdm
     * @return
     */
    HashMap<String, Object> getPartyUserTotalList(String dzzdm);

    /**
     * 创岗建区
     *
     * @param dzzdm
     * @param ssdzzdm
     * @param year
     * @return
     */
    HashMap<String, Object> getcgjqtotal(String dzzdm, String ssdzzdm, Integer year);

    /**
     * 创岗建区
     *
     * @param dzzdm
     * @param ssdzzdm
     * @param year
     * @return
     */
    List<HashMap<String, Object>> getcgjqtotallist(String dzzdm, String ssdzzdm, Integer year);

    /**
     * 发展党员
     *
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> getPartyUserExpendTotalList(String dzzdm);

    /**
     * 中心组学习
     *
     * @param dzzdm
     * @param ssdzzdm
     * @param year
     * @return
     */
    List<HashMap<String, Object>> getzxzxxtotal(String dzzdm, String ssdzzdm, Integer year);

    //考评信息统计
    List<HashMap<String, Object>> getDjkpxxTotalList(Integer year);

    //品牌信息统计
    List<HashMap<String, Object>> getBrandTotalList();

    //纪律处分信息
    List<HashMap<String, Object>> getJlcfxxTotalList();

    List<HashMap<String, Object>> getPartyUserStatusTotalList();

    List<HashMap<String, Object>> getZzpxqkList();

    List<HashMap<String, Object>> getDnpxxxTotalList();

    List<HashMap<String, Object>> getPartyBrandTotalList();

    List<HashMap<String, Object>> getSzpyTotalList();

    List<HashMap<String, Object>> getDnghbfTotalList();

    List<HashMap<String, Object>> getZtdrTotalList(Integer year);

}
