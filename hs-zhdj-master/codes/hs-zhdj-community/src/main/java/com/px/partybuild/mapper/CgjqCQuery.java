package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 创岗建区
 *
 * @author H
 */
public interface CgjqCQuery {

    //岗区配置、评分模板配置功能

    /**
     * 查询岗区配置
     *
     * @param cgjqType
     * @param partyCode
     * @param userId
     * @param name
     * @param headUserName
     * @param zzfbType
     * @return
     */
    List<HashMap<String, Object>> selectSettingPostareaList(@Param("cgjqType") Integer cgjqType, @Param("partyCode") String partyCode, @Param("userId") String userId, @Param("name") String name, @Param("headUserName") String headUserName, @Param("zzfbType") Integer zzfbType);

    /**
     * 查询岗区配置成员
     *
     * @param seetingPostareaId
     * @param dutyUserType
     * @return
     */
    List<HashMap<String, Object>> selectSettingPostareaUserList(@Param("seetingPostareaId") String seetingPostareaId, @Param("dutyUserType") Integer dutyUserType);

    /**
     * 查询考核模板
     *
     * @param partyCode
     * @param cgjqType
     * @param zzfbType
     * @return
     */
    List<HashMap<String, Object>> selectSettingScoreProjectList(@Param("partyCode") String partyCode, @Param("cgjqType") Integer cgjqType, @Param("zzfbType") Integer zzfbType);

    /**
     * 删除岗区
     *
     * @param seetingPostareaId
     * @return
     */
    int deleteSettingPostarea(@Param("seetingPostareaId") String seetingPostareaId);

    /**
     * 删除岗区人员
     *
     * @param seetingPostareaId
     * @return
     */
    int deleteSettingPostareaUser(@Param("seetingPostareaId") String seetingPostareaId);


    //岗区评分

    /**
     * 查询岗区评分记录
     *
     * @param cgjqType
     * @param year
     * @param quarter
     * @param partyCode
     * @param userId
     * @param name
     * @param headUserName
     * @param zzfbType
     * @param gqtype
     * @return
     */
    List<HashMap<String, Object>> selectPostareaScoreList(@Param("cgjqType") Integer cgjqType, @Param("year") Integer year, @Param("quarter") Integer quarter, @Param("partyCode") String partyCode, @Param("userId") String userId, @Param("name") String name, @Param("headUserName") String headUserName, @Param("zzfbType") Integer zzfbType,
                                                          @Param("gqtype") Integer gqtype, @Param("postAreaId") String postAreaId);

    /**
     * 岗区评分记录-岗区成员
     *
     * @param postAreaScoreId
     * @param dutyUserType
     * @return
     */
    List<HashMap<String, Object>> selectPostareaScoreUserList(@Param("postAreaScoreId") String postAreaScoreId, @Param("dutyUserType") Integer dutyUserType);

    /**
     * 岗区评分记录-评分项
     *
     * @param postAreaScoreId
     * @return
     */
    List<HashMap<String, Object>> selectPostareaScoreProjectList(@Param("postAreaScoreId") String postAreaScoreId);

    /**
     * 删除岗区评分记录
     *
     * @param postAreaScoreId
     * @return
     */
    int deletePostareaScore(@Param("postAreaScoreId") String postAreaScoreId);

    /**
     * 删除
     *
     * @param postAreaScoreId
     * @return
     */
    int deletePostareaScoreUser(@Param("postAreaScoreId") String postAreaScoreId);

    /**
     * 删除评分项
     *
     * @param postAreaScoreId
     * @return
     */
    int deletePostareaScoreProject(@Param("postAreaScoreId") String postAreaScoreId);

    /**
     * 查询评分排名
     *
     * @param partyCode
     * @param cgjqType
     * @param year
     * @param quarter
     * @param zzfbType
     * @return
     */
    List<HashMap<String, Object>> selectPostareaScoreOrderList(@Param("partyCode") String partyCode, @Param("cgjqType") Integer cgjqType, @Param("year") Integer year, @Param("quarter") Integer quarter, @Param("zzfbType") Integer zzfbType);


    /**
     * 岗区选择（评分）
     *
     * @param year
     * @param quarter
     * @param cgjqType
     * @param partyCode
     * @param userId
     * @param name
     * @param headUserName
     * @return
     */
    List<HashMap<String, Object>> selectSettingPostareaOfScoreList(@Param("year") Integer year, @Param("quarter") Integer quarter, @Param("cgjqType") Integer cgjqType, @Param("partyCode") String partyCode, @Param("userId") String userId, @Param("name") String name, @Param("headUserName") String headUserName);

    /**
     * @Description //TODO 查询个人所属岗区排名
     * @date 2024-08
     * @Param [userId, cgjqType, year, quarter]
     **/
    List<HashMap<String, Object>> selectUserPostareaOrderList(@Param("userId") String userId, @Param("cgjqType") Integer cgjqType, @Param("year") Integer year, @Param("quarter") Integer quarter);

    List<HashMap<String, Object>> selectPostareaTotalList(@Param("cgjqType") Integer cgjqType, @Param("dzzdm") String dzzdm, @Param("name") String name, @Param("userName") String userName, @Param("gqtype") Integer gqtype);

}
