package com.px.partybuild.mapper;

import com.px.partybuild.vo.PartyUserAdmitVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public interface PartyUserAdmitCQuery {
    List<PartyUserAdmitVo> selectPartyUserAdmitList(@Param("partyCode") String partyCode, @Param("userCode") String userCode, @Param("userName") String userName, @Param("userStatus") Integer userStatus, @Param("applyStartDate") Date applyStartDate, @Param("applyEndDate") Date applyEndDate,
                                                    @Param("activeStartDate") Date activeStartDate, @Param("activeEndDate") Date activeEndDate, @Param("passStartDate") Date passStartDate, @Param("passEndDate") Date passEndDate,
                                                    @Param("inPatyStartDate") Date inPatyStartDate, @Param("inPatyEndDate") Date inPatyEndDate, @Param("isArchive") Integer isArchive,@Param("applyApproveStatus") Integer applyApproveStatus
    , @Param("gradeName")String gradeName, @Param("className")String className, @Param("sexId")Integer sexId, @Param("isStudent")Integer isStudent, @Param("educationalId")Integer educationalId,@Param("userNo")String userNo);
}
