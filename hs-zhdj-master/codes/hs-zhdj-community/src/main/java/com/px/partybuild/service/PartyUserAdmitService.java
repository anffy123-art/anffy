package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.vo.ApplyProgressVo;
import com.px.partybuild.vo.PartyUserAdmitVo;
import com.px.partybuild.vo.UserInfoVo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface PartyUserAdmitService {
    PageInfo<PartyUserAdmitVo> getPartyUserAdmitList(int pageIndex, int pageSize, String partyCode, String userCode, String userName, Integer userStatus, Date applyStartDate, Date applyEndDate, Date activeStartDate, Date activeEndDate, Date passStartDate, Date passEndDate,
                                                     Date inPatyStartDate, Date inPatyEndDate, Integer isArchive,Integer applyApproveStatus,String gradeName,String className,Integer sexId,Integer isStudent,Integer educationalId,String userNo);
    PartyUserAdmitVo getPartyUserByCode(String userCode);
    int save(PartyUserAdmitVo data) throws Exception;
    int delete(String userCode);
    List<UserInfoVo> importApplyUser(List<UserInfoVo> dataList, Integer userStatus) throws Exception;
    List<UserInfoVo> updateUserProgress(List<UserInfoVo> dataList, Integer userStatus) throws Exception;
    int archive(List<String> userCodeList,Date exportDate,String exportPartyName,Date archiveDate) throws Exception;
    int unArchive(List<String> userCodeList) throws Exception;
    int audit(List<String> userCodeList,Integer applyApproveStatus) throws Exception;
    List<ApplyProgressVo> getApplyProgressList(String userCode);
}
