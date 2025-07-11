package com.px.partybuild.mapper;

import com.px.partybuild.vo.PartyduesAlreadyPayDetailVo;
import com.px.partybuild.vo.PartyduesDidnotPayDetailVo;
import com.px.partybuild.vo.PartyduesTotalDetailVo;
import com.px.partybuild.vo.PartyduesTotalVo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 党建统计
 *
 * @author H
 */
public interface PartyTotalCQuery {

    /**
     * 党组织数
     *
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectPartytotalList(@Param("dzzdmList") List<String> dzzdmList);

    /**
     * 创岗建区
     *
     * @param year
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectCgjqtotalList(@Param("year") Integer year, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 党内品牌
     *
     * @param year
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectDnpptotalList(@Param("year") Integer year, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 活动室
     *
     * @param year
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectActivityroomtotalList(@Param("year") Integer year, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 宣传阵地
     *
     * @param year
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectPubpositiontotalList(@Param("year") Integer year, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 互联网工作群
     *
     * @param year
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectWxgrouptotalList(@Param("year") Integer year, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 年度应换届党组织数
     *
     * @param year
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectGroupReplacetotalList(@Param("year") Integer year, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 年度已换届党组织数
     *
     * @param year
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectGroupAlreadyReplacetotalList(@Param("year") Integer year, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 在岗党员数
     *
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectZgUsertotalList(@Param("dzzdmList") List<String> dzzdmList, @Param("isOnduty") Integer isOnduty);

    /**
     * 党支部书记专职兼职情况
     *
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectDZBSJtotalList(@Param("dzzdmList") List<String> dzzdmList);

    /**
     * 困难党员
     *
     * @param dzzdmList
     * @param year
     * @return
     */
    List<HashMap<String, Object>> selectGHBFtotalList(@Param("dzzdmList") List<String> dzzdmList, @Param("year") Integer year);


    /**
     * 中心组学习情况
     *
     * @param year
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectZxzxxFaTotalList(@Param("year") Integer year, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 中心组学习出勤率
     *
     * @param year
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectZxzxxCqlList(@Param("year") Integer year, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 中心组学习出勤率明细
     *
     * @param year
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectZxzxxCqlDetailList(@Param("year") Integer year, @Param("dzzdm") String dzzdm);

    /**
     * 中心组学习成员出勤情况
     *
     * @param year
     * @param dzzdm
     * @return
     */
    List<HashMap<String, Object>> selectZxzxxUserStudyList(@Param("year") Integer year, @Param("dzzdm") String dzzdm);


    List<HashMap<String, Object>> selectPartyDuesUserCount(@Param("yearMonth") Integer yearMonth, @Param("dzzdmList") List<String> dzzdmList);

    /**
     * 每月党费缴纳情况（停用）
     *
     * @param year
     * @param month
     * @param dzzdm
     * @param dzzdmList
     * @return
     */
    //List<HashMap<String, Object>> selectPartyduesTotalList(@Param("year") Integer year, @Param("month") Integer month, @Param("dzzdm") String dzzdm, @Param("dzzdmList") List<String> dzzdmList,@Param("yearMonth") Integer yearMonth);

    /**
     * 每月党费缴纳情况(new)
     *
     * @param gddwdm
     * @param year
     * @param month
     * @param partyCode
     * @param yearMonth
     * @return
     */
    List<PartyduesTotalVo> selectPartyduesTotalListV2(@Param("gddwdm") String gddwdm, @Param("parentPartyCode") String parentPartyCode, @Param("partyCode") String partyCode, @Param("year") Integer year, @Param("month") Integer month, @Param("yearMonth") Integer yearMonth);

    /**
     * 已缴党费成员（数据导出功能，按照缴费高到低排序，一行两个党员）
     *
     * @param dzzdm
     * @param year
     * @param month
     * @return
     */
    List<HashMap<String, Object>> selectPartyduesUserList(@Param("dzzdm") String dzzdm, @Param("year") Integer year, @Param("month") Integer month);

    /**
     * 已缴党费成员（数据导出功能，按照缴费高到低排序，一行一个党员）
     *
     * @param dzzdm
     * @param year
     * @param month
     * @return
     */
    /*List<HashMap<String, Object>> selectPartyduesUserList2(@Param("dzzdm") String dzzdm, @Param("year") Integer year, @Param("month") Integer month);*/

    /**
     * 未缴党费成员
     *
     * @param dzzdm
     * @param year
     * @param month
     * @return
     */
    /*List<HashMap<String, Object>> selectNotPartyduesUserList(@Param("dzzdm") String dzzdm, @Param("year") Integer year, @Param("month") Integer month, @Param("yearMonth") Integer yearMonth);*/

    /**
     * 已缴党费成员
     *
     * @param partyCode
     * @param year
     * @param month
     * @param yearMonth
     * @return
     */
    List<PartyduesAlreadyPayDetailVo> selectAlreadyPayUserList(@Param("partyCode") String partyCode, @Param("year") Integer year, @Param("month") Integer month, @Param("yearMonth") Integer yearMonth);

    /**
     * 未缴党费成员
     *
     * @param partyCode
     * @param year
     * @param month
     * @param yearMonth
     * @return
     */
    List<PartyduesDidnotPayDetailVo> selectDidnotPayUserList(@Param("partyCode") String partyCode, @Param("year") Integer year, @Param("month") Integer month, @Param("yearMonth") Integer yearMonth);


    /**
     * 统计党组织每月缴纳党费
     *
     * @param year
     * @param dzzdm
     * @param dzzdmList
     * @return
     */
    //List<HashMap<String, Object>> selectPartyduesMonthTotalList(@Param("year") Integer year, @Param("dzzdm") String dzzdm, @Param("dzzdmList") List<String> dzzdmList);

    List<PartyduesTotalDetailVo> selectPartyduesMonthTotalListV2(@Param("gddwdm") String gddwdm, @Param("year") Integer year, @Param("partyCode") String partyCode);

    /**
     * 统计党组织季度缴纳党费
     *
     * @param year
     * @param dzzdm
     * @param dzzdmList
     * @return
     */
    List<HashMap<String, Object>> selectPartyduesQuarterTotalList(@Param("year") Integer year, @Param("dzzdm") String dzzdm, @Param("dzzdmList") List<String> dzzdmList);

    List<HashMap<String, Object>> selectZtdrTotalList(@Param("year") Integer year, @Param("month") Integer month, @Param("dzzdm") String dzzdm);


    List<HashMap<String, Object>> selectLeaderUserTotalList(@Param("dzzdm") String dzzdm, @Param("yearMonth") String yearMonth, @Param("xm") String xm);

    List<HashMap<String, Object>> selectSystemUseTotalList(@Param("dzzdm") String dzzdm, @Param("fundYear") String fundYear, @Param("duesYearMonth") String duesYearMonth, @Param("meetingYearMonth") String meetingYearMonth
            , @Param("partydayYearMonth") String partydayYearMonth, @Param("positionYearMonth") String positionYearMonth);


    List<HashMap<String, Object>> selectPartyLifeTotalList(@Param("year") Integer year, @Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc);

    List<HashMap<String, Object>> selectPartyLifeMonthTotalList(@Param("year") Integer year, @Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc);

    List<HashMap<String, Object>> selectPartyActivityTotalList(@Param("year") Integer year, @Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc);

    List<HashMap<String, Object>> selectPartyActivityMonthTotalList(@Param("year") Integer year, @Param("dzzdm") String dzzdm, @Param("dzzmc") String dzzmc);

    List<HashMap<String, Object>> selectZxzxxWarnList(@Param("year") Integer year, @Param("quarter") Integer quarter, @Param("month") Integer month, @Param("dzzdm") String dzzdm);

}
