package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.vo.PartyduesAlreadyPayDetailVo;
import com.px.partybuild.vo.PartyduesDidnotPayDetailVo;
import com.px.partybuild.vo.PartyduesTotalByYearVo;
import com.px.partybuild.vo.PartyduesTotalVo;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * 党建统计
 *
 * @author H
 */
public interface PartyTotalService {

    /**
     * 党建局情
     *
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param year
     * @return
     */
    PageInfo<HashMap<String, Object>> getPartyTotalList(int pageNum, int pageSize, String dzzdm, Integer year);

    /**
     * 党组织统计信息
     *
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param year
     * @return
     */
    PageInfo<HashMap<String, Object>> getPartyDetailList(int pageNum, int pageSize, String dzzdm, Integer year,String dzzmc);

    /**
     * 党员统计信息
     *
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param year
     * @return
     */
    PageInfo<HashMap<String, Object>> getUserTotalList(int pageNum, int pageSize, String dzzdm, Integer year,String dzzmc);


    /**
     * 中心组学习方案统计
     *
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param year
     * @param ssdzzdm
     * @return
     */
    PageInfo<HashMap<String, Object>> getZxzxxFaTotalList(int pageNum, int pageSize, String dzzdm, Integer year, String ssdzzdm);

    /**
     * 中心组学习出勤率
     *
     * @param dzzdm
     * @param year
     * @return
     */
    List<HashMap<String, Object>> getZxzxxCqlDetailList(String dzzdm, Integer year);

    /**
     * 中心组学习人员学习信息
     *
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param year
     * @return
     */
    PageInfo<HashMap<String, Object>> getZxzxxUserStudyList(int pageNum, int pageSize, String dzzdm, Integer year);


    /**
     * 每月党费缴纳情况(停用)
     *
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param year
     * @param month
     * @param ssdzzdm
     * @return
     */
    /*PageInfo<HashMap<String, Object>> getPartyduesTotalList(int pageNum, int pageSize, String dzzdm, Integer year, Integer month, String ssdzzdm);*/

    /**
     * 每月党费缴纳情况（new）
     * @param pageNum
     * @param pageSize
     * @param dzzdm
     * @param year
     * @param month
     * @return
     */
    PageInfo<PartyduesTotalVo> getPartyduesTotalListV2(int pageNum, int pageSize, String parentPartyCode, String partyCode, Integer year, Integer month);


    /**
     * 已缴党费成员（数据导出功能，按照缴费高到低排序，一行两个党员）
     *
     * @param dzzdm
     * @param year
     * @param month
     * @return
     */
    List<HashMap<String, Object>> getPartyduesUserList(String dzzdm, Integer year, Integer month);

    /**
     * 已缴党费成员（数据导出功能，按照缴费高到低排序，一行一个党员）
     *
     * @param dzzdm
     * @param year
     * @param month
     * @return
     */
    //List<HashMap<String, Object>> getPartyduesUserList2(String dzzdm, Integer year, Integer month);

    /**
     * 未缴党费成员
     *
     * @param dzzdm
     * @param year
     * @param month
     * @return
     */
    //List<HashMap<String, Object>> getNotPartyduesUserList(String dzzdm, Integer year, Integer month);

    List<PartyduesAlreadyPayDetailVo> getAlreadyPayUserList(String partyCode, Integer year, Integer month);

    List<PartyduesDidnotPayDetailVo> getDidnotPayUserList(String partyCode, Integer year, Integer month);



    /**
     * 统计党组织每月缴纳党费
     *
     * @param pageNum
     * @param pageSize
     * @param year
     * @param dzzdm
     * @return
     */
    List<PartyduesTotalByYearVo> getPartyduesMonthTotalList(int pageNum, int pageSize, Integer year, String dzzdm);

    void exportPartyduesMonthTotal(HttpServletRequest request, HttpServletResponse response, Integer year, String dzzdm) throws IOException;

    /**
     * 统计党组织季度缴纳党费
     *
     * @param pageNum
     * @param pageSize
     * @param year
     * @param dzzdm
     * @param ssdzzdm
     * @return
     */
    PageInfo<HashMap<String, Object>> getPartyduesQuarterTotalList(int pageNum, int pageSize, Integer year, String dzzdm,String ssdzzdm);


    PageInfo<HashMap<String, Object>> getZtdrTotalList(int pageNum, int pageSize, Integer year, Integer month,String dzzdm);


    PageInfo<HashMap<String, Object>> getLeaderUserTotalList(int pageNum, int pageSize, String dzzdm, String yearMonth,String xm);

    PageInfo<HashMap<String, Object>> getSystemUseTotalList(int pageNum, int pageSize, String dzzdm, String fundYear, String duesYearMonth, String meetingYearMonth, String partydayYearMonth, String positionYearMonth);


    PageInfo<HashMap<String, Object>> getPartyLifeTotalList(int pageNum, int pageSize, Integer year, String dzzdm, String dzzmc);

    PageInfo<HashMap<String, Object>> getPartyLifeMonthTotalList(int pageNum, int pageSize, Integer year, String dzzdm, String dzzmc);

    PageInfo<HashMap<String, Object>> getPartyActivityTotalList(int pageNum, int pageSize, Integer year, String dzzdm, String dzzmc);

    PageInfo<HashMap<String, Object>> getPartyActivityMonthTotalList(int pageNum, int pageSize, Integer year, String dzzdm, String dzzmc);

    PageInfo<HashMap<String, Object>> getZxzxxWarnList(int pageNum, int pageSize, Integer year, Integer quarter, Integer month, String dzzdm);
}
