package com.px.partybuild.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * 发展党员
 *
 * @author H
 */
public interface PEUserCQuery {

    /**
     * 发展党员信息
     * @param id
     * @param partyCode
     * @param name
     * @param isLateDay
     * @param flowId
     * @param pflowid
     * @param zzfbType
     * @param beginSort
     * @param endSort
     * @param ryzt
     * @return
     */
    List<HashMap<String, Object>> selectJoinUserList(@Param("id") String id, @Param("partyCode") String partyCode, @Param("name") String name, @Param("isLateDay") Integer isLateDay, @Param("flowId") String flowId, @Param("pflowid") List<String> pflowid, @Param("zzfbType") Integer zzfbType,
                                                     @Param("beginSort") Integer beginSort, @Param("endSort") Integer endSort,@Param("ryztList") List<Integer> ryztList);

    List<HashMap<String, Object>> selectJoinUserListForApp(@Param("id") String id, @Param("partyCode") String partyCode, @Param("name") String name, @Param("isLateDay") Integer isLateDay, @Param("flowId") String flowId, @Param("pflowid") List<String> pflowid, @Param("zzfbType") Integer zzfbType,
                                                     @Param("beginSort") Integer beginSort, @Param("endSort") Integer endSort,@Param("ryztList") List<Integer> ryztList,
                                                           @Param("szdzbdm") String szdzbdm);


    /**
     * 发展党员步骤
     * @return
     */
    List<HashMap<String, Object>> selectJoinFlowList();

    /**
     * 发展党员步骤
     * @param joinUserId
     * @return
     */
    List<HashMap<String, Object>> selectUserFlowList(@Param("joinUserId") String joinUserId);

    /**
     * 删除个人简历
     * @param applyId
     * @return
     */
    int deletePeJoinapplyResume(@Param("applyId") String applyId);

    /**
     * 删除社会关系
     * @param applyId
     * @return
     */
    int deletePeJoinapplyRelation(@Param("applyId") String applyId);

    /**
     * 查询个人简历
     * @param applyId
     * @return
     */
    List<HashMap<String, Object>> selectPeJoinapplyResumeList(@Param("applyId") String applyId);

    /**
     * 查询社会关系
     * @param applyId
     * @return
     */
    List<HashMap<String, Object>> selectPeJoinapplyRelationList(@Param("applyId") String applyId);

    /**
     * 删除谈话人
     * @param talkId
     * @return
     */
    int deleteTaskUser(@Param("talkId") String talkId);

    /**
     * 查询谈话人
     * @param talkId
     * @return
     */
    List<HashMap<String, Object>> selectTalkUserList(@Param("talkId") String talkId);

    /**
     * 删除培养人
     * @param trainUserId
     * @return
     */
    int deleteTrainuserDetail(@Param("trainUserId") String trainUserId);

    /**
     * 查询培养人
     * @param trainUserId
     * @return
     */
    List<HashMap<String, Object>> selectTrainuserDetailList(@Param("trainUserId") String trainUserId);


    /**
     * 删除删除培养教育考察
     * @param trainInspectId
     * @return
     */
    int deleteTraininspectRecord(@Param("trainInspectId") String trainInspectId);

    /**
     * 查询删除培养教育考察
     * @param trainInspectId
     * @return
     */
    List<HashMap<String, Object>> selectTraininspectRecordList(@Param("trainInspectId") String trainInspectId);

    /**
     * 继续教育
     * @param kcid
     * @return
     */
    List<HashMap<String, Object>> selectJxjykcqkList(@Param("kcid") String kcid);

    /**
     * 删除入党介绍人
     * @param confirmSponsorId
     * @return
     */
    int deleteConfirmsponsorUser(@Param("confirmSponsorId") String confirmSponsorId);

    /**
     * 查询入党介绍人
     * @param confirmSponsorId
     * @return
     */
    List<HashMap<String, Object>> selectConfirmsponsorUserList(@Param("confirmSponsorId") String confirmSponsorId);

    /**
     * x
     * @param sjprthId
     * @return
     */
    List<HashMap<String, Object>> selectSjprthmxList(@Param("sjprthId") String sjprthId);


    /**
     * 更新人员编码
     * @return
     */
    int updateJoinuserCode();


    /**
     * 需更正人员编码的申请历史数据
     * @param partyCode
     * @param name
     * @return
     */
    List<HashMap<String,Object>> selectJoinuserForUpdateList(@Param("partyCode") String partyCode, @Param("name") String name,@Param("startDate")String startDate, @Param("endDate")String endDate);


}
