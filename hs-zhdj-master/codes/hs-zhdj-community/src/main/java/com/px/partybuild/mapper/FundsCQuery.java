package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 党组织经费
 *
 * @author H
 */
public interface FundsCQuery {

    /**
     * 获取党组织经费使用情况
     * @param partyCode
     * @param beginTime
     * @param endTime
     * @param expendScope
     * @param expendType
     * @return
     */
    List<HashMap<String, Object>> selectFundsUseList(@Param("dzzmc") String dzzmc,@Param("partyCode") String partyCode, @Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("expendScope") Integer expendScope, @Param("expendType") Integer expendType);

    /**
     * x
     * @param partyCode
     * @param year
     * @return
     */
    List<HashMap<String, Object>> selectFundsUsageSummary(@Param("partyCode") String partyCode,@Param("dzzmc") String dzzmc, @Param("year") Integer year,@Param("DZZDM") String DZZDM,@Param("isApp") boolean isApp);

    /**
     * x
     * @param partyCode
     * @param year
     * @return
     */
    List<HashMap<String, Object>> selectFundsUsageDetails(@Param("partyCode") String partyCode, @Param("year") Integer year);

    /**
     * x
     * @param partyCode
     * @param expendscope
     * @param year
     * @return
     */
    List<HashMap<String, Object>> selectPartyFundsUsage(@Param("partyCode") String partyCode, @Param("expendscope") Integer expendscope, @Param("year") Integer year);
}
