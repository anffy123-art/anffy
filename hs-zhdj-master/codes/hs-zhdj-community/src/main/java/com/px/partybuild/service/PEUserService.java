package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.model.*;

import java.util.HashMap;
import java.util.List;

/**
 * 发展党员
 *
 * @author H
 */
public interface PEUserService {

    /**
     * 发展党员信息
     * @param page
     * @param rows
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
    PageInfo<HashMap<String, Object>> getJoinUserList(int page, int rows, String partyCode, String name, Integer isLateDay, String flowId, List<String> pflowid, Integer zzfbType,Integer beginSort, Integer endSort,List<Integer> ryztList);

    PageInfo<HashMap<String, Object>> getJoinUserListForApp(int page, int rows, String partyCode, String name, Integer isLateDay, String flowId, List<String> pflowid, Integer zzfbType,Integer beginSort, Integer endSort,List<Integer> ryztList,String szdzbdm);


    /**
     * 发展党员信息
     * @param id
     * @return
     */
    PeJoinuser getJoinuserById(String id);

    /**
     * 发展党员信息
     * @param rybm
     * @return
     */
    PeJoinuser getJoinuserByRybm(String rybm);

    /**
     * 发展党员信息
     * @param id
     * @return
     */
    HashMap<String, Object> getJoinuserInfoById(String id);

    /**
     * 保存发展党员信息
     * @param model
     * @return
     */
    int saveJoinuser(PeJoinuser model);

    /**
     * 删除发展党员信息
     * @param id
     * @return
     */
    int deleteJoinUserById(String id);

    /**
     * 发展党员步骤信息
     * @param joinUserId
     * @return
     */
    List<HashMap<String, Object>> getUserFlowList(String joinUserId);

    /**
     * 发展党员统计
     * @param page
     * @param rows
     * @param dzzdm
     * @param zzfbType
     * @param ssdzzmc
     * @return
     */
    PageInfo<HashMap<String, Object>> getJoinUserTotalList(int page, int rows, String dzzdm, Integer zzfbType,String ssdzzmc,Integer isOnduty);

    /**
     * 1 、党员申请书信息
     * @param joinUserId
     * @return
     */
    PeJoinapplyWithBLOBs getJoinuserApplyByUserId(String joinUserId);

    /**
     * 保存党员申请书信息
     * @param model
     * @param resumeList
     * @param relationListList
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveJoinuserApply(PeJoinapplyWithBLOBs model, List<PeJoinapplyResume> resumeList, List<PeJoinapplyRelation> relationListList, String flowId, String userId, String userName);

    /**
     *个人简历
     * @param page
     * @param rows
     * @param applyId
     * @return
     */
    PageInfo<HashMap<String, Object>> getPeJoinapplyResumeList(int page, int rows, String applyId);

    /**
     * 社会关系
     * @param page
     * @param rows
     * @param applyId
     * @return
     */
    PageInfo<HashMap<String, Object>> getPeJoinapplyRelationList(int page, int rows, String applyId);

    /**
     * 删除申请书信息
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delPeJoinUserApply(String joinUserId, String flowId);


    /**
     * 2、派人谈话信息
     * @param joinUserId
     * @return
     */
    PeTalkWithBLOBs getTalkByUserId(String joinUserId);

    /**
     * 保存派人谈话信息
     * @param model
     * @param userList
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveTalk(PeTalkWithBLOBs model, List<PeTalkUser> userList, String flowId, String userId, String userName);

    /**
     * 谈话人信息
     * @param page
     * @param rows
     * @param talkId
     * @return
     */
    PageInfo<HashMap<String, Object>> getTalkUserList(int page, int rows, String talkId);

    /**
     * 删除谈话信息
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delTalkUser(String joinUserId, String flowId);

    /**
     * 3、推荐和确定入党积极分子
     * @param joinUserId
     * @return
     */
    PeRecommendWithBLOBs getRecommendByUserId(String joinUserId);

    /**
     * 保存推荐和确定入党积极分子
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveRecommend(PeRecommendWithBLOBs model, String flowId, String userId, String userName);

    /**
     * 删除推荐和确定入党积极分子
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delRecommend(String joinUserId, String flowId);

    /**
     * 4.上级党委备案情况
     * @param joinUserId
     * @return
     */
    PePutrecord getPutrecordByUserId(String joinUserId);

    /**
     * 保存上级党委备案情况
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int savePutrecord(PePutrecord model, String flowId, String userId, String userName);

    /**
     * 删除上级党委备案情况
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delPutrecord(String joinUserId, String flowId);

    /**
     * 5.指定培养人
     * @param joinUserId
     * @return
     */
    PeTrainuser getTrainuserByUserId(String joinUserId);

    /**
     * 5.指定培养人
     * @param model
     * @param userList
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveTrainuser(PeTrainuser model, List<PeTrainuserDetail> userList, String flowId, String userId, String userName);

    /**
     * 5.指定培养人
     * @param page
     * @param rows
     * @param trainUserId
     * @return
     */
    PageInfo<HashMap<String, Object>> getTrainuserDetailList(int page, int rows, String trainUserId);

    /**
     * 5.指定培养人
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delTrainuser(String joinUserId, String flowId);

    /**
     * 6.培养教育考察
     * @param joinUserId
     * @return
     */
    PeTraininspect getTraininspectByUserId(String joinUserId);

    /**
     * 6.培养教育考察
     * @param model
     * @param recordList
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveTraininspect(PeTraininspect model, List<PeTraininspectRecordWithBLOBs> recordList, String flowId, String userId, String userName);

    /**
     * 6.培养教育考察
     * @param page
     * @param rows
     * @param trainInspectId
     * @return
     */
    PageInfo<HashMap<String, Object>> getTraininspectRecordList(int page, int rows, String trainInspectId);

    /**
     * 6.培养教育考察
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delTraininspect(String joinUserId, String flowId);

    /**
     * 7.确定发展对象
     * @param joinUserId
     * @return
     */
    PeConfirmuserWithBLOBs getConfirmuserByUserId(String joinUserId);

    /**
     * 7.确定发展对象
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveConfirmuser(PeConfirmuserWithBLOBs model, String flowId, String userId, String userName);

    /**
     * 7.确定发展对象
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delConfirmuser(String joinUserId, String flowId);


    /**
     * 8.上级党委报备
     * @param joinUserId
     * @return
     */
    PeAgainputrecord getAgainputrecordByUserId(String joinUserId);

    /**
     * 8.上级党委报备
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveAgainputrecord(PeAgainputrecord model, String flowId, String userId, String userName);

    /**
     * 8.上级党委报备
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delAgainputrecord(String joinUserId, String flowId);

    /**
     * 9.确定入党介绍人
     * @param joinUserId
     * @return
     */
    PeConfirmsponsor getConfirmsponsorByUserId(String joinUserId);

    /**
     * 9.确定入党介绍人
     * @param model
     * @param userList
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveConfirmsponsor(PeConfirmsponsor model, List<PeConfirmsponsorUser> userList, String flowId, String userId, String userName);

    /**
     * 9.确定入党介绍人
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delConfirmsponsor(String joinUserId, String flowId);

    /**
     * 9.确定入党介绍人
     * @param page
     * @param rows
     * @param confirmSponsorIdd
     * @param joinUserId
     * @return
     */
    PageInfo<HashMap<String, Object>> getConfirmsponsorUserList(int page, int rows, String confirmSponsorIdd, String joinUserId);

    /**
     * 10.进行政治审查
     * @param joinUserId
     * @return
     */
    PePoliticalreview getPoliticalreviewByUserId(String joinUserId);

    /**
     * 10.进行政治审查
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int savePoliticalreview(PePoliticalreview model, String flowId, String userId, String userName);

    /**
     * 10.进行政治审查
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delPoliticalreview(String joinUserId, String flowId);

    /**
     * 11.开展短期集中培训
     * @param joinUserId
     * @return
     */
    PeTraining getTrainingByUserId(String joinUserId);

    /**
     * 11.开展短期集中培训
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveTraining(PeTraining model, String flowId, String userId, String userName);

    /**
     * 11.开展短期集中培训
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delTraining(String joinUserId, String flowId);

    /**
     * 12.支委会审查
     * @param joinUserId
     * @return
     */
    PeBranchreview getBranchreviewByUserId(String joinUserId);

    /**
     * 12.支委会审查
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveBranchreview(PeBranchreview model, String flowId, String userId, String userName);

    /**
     * 12.支委会审查
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delBranchreview(String joinUserId, String flowId);

    /**
     * 上级党委预审
     * @param joinUserId
     * @return
     */
    PePartyreview getPartyreviewByUserId(String joinUserId);

    /**
     * 12.支委会审查
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int savePartyreview(PePartyreview model, String flowId, String userId, String userName);

    /**
     * 12.支委会审查
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delPartyreview(String joinUserId, String flowId);

    /**
     * 14.填写入党志愿书
     * @param joinUserId
     * @return
     */
    PeJoinbook getJoinbookByUserId(String joinUserId);

    /**
     * 14.填写入党志愿书
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveJoinbook(PeJoinbook model, String flowId, String userId, String userName);

    /**
     * 14.填写入党志愿书
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delJoinbook(String joinUserId, String flowId);

    /**
     * 15.支部大会讨论
     * @param joinUserId
     * @return
     */
    PeBranchtalkWithBLOBs getBranchtalkByUserId(String joinUserId);

    /**
     * 15.支部大会讨论
     * @param model
     * @param flowId
     * @param userId
     * @param userName
     * @return
     */
    int saveBranchtalk(PeBranchtalkWithBLOBs model, String flowId, String userId, String userName);

    /**
     * 15.支部大会讨论
     * @param joinUserId
     * @param flowId
     * @return
     */
    int delBranchtalk(String joinUserId, String flowId);


    /**
     * 更新人员编码
     * @return
     */
    int updateJoinuserCode();

    /**
     * 获取未更新人员编码数据
     * @param page
     * @param rows
     * @param partyCode
     * @param name
     * @return
     */
    PageInfo<HashMap<String, Object>> getJoinuserForUpdateList(int page, int rows, String partyCode, String name,String startDate, String endDate);

}
