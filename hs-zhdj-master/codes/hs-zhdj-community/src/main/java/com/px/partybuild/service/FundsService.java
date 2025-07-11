package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.DjFundsuseWithBLOBs;

import java.util.HashMap;
import java.util.List;

/**
 * 党组织经费
 *
 * @author H
 */
public interface FundsService {


    /**
     * 获取党组织经费使用情况
     * @param page
     * @param rows
     * @param partyCode
     * @param beginTime
     * @param endTime
     * @param expendScope
     * @param expendType
     * @return
     */
    PageInfo<HashMap<String, Object>> getFundsUseList(int page, int rows, String dzzmc,String partyCode, String beginTime, String endTime, Integer expendScope, Integer expendType);

    /**
     * 查询党组织经费
     * @param id
     * @return
     */
    DjFundsuseWithBLOBs getFundsuseById(String id);

    /**
     * 保存
     * @param model
     * @param userId
     * @param userName
     * @return
     */
    int saveFundsuse(DjFundsuseWithBLOBs model, String userId, String userName);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteFundsuseById(String id);

    /**
     * @param page
     * @param rows
     * @param partyCode
     * @param year
     * @return
     */
    PageInfo<HashMap<String, Object>> getFundsUsageSummary(int page, int rows, String partyCode,String dzzmc, Integer year,boolean isApp);

    /**
     * @param dzzdm
     * @return
     */
    HashMap<String, Object> getFundsUsageSummaryByDzzdm(Integer year,String dzzdm);
    /**
     * @param page
     * @param rows
     * @param partyCode
     * @param year
     * @return
     */
    PageInfo<HashMap<String, Object>> getFundsUsageDetails(int page, int rows, String partyCode, Integer year);

    /**
     * @param partyCode
     * @param expendscope
     * @param year
     * @return
     */
    List<HashMap<String, Object>> getPartyFundsUsage(String partyCode, Integer expendscope,Integer year);
}
