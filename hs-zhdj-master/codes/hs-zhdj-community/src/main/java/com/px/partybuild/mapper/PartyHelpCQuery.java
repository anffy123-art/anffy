package com.px.partybuild.mapper;

import com.px.partybuild.vo.PartyHelpVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PartyHelpCQuery {

    List<PartyHelpVo> selectHelpList(@Param("partyHelpID") String partyHelpID, @Param("partyCode") String partyCode, @Param("userName") String userName, @Param("userCode") String userCode, @Param("year") Integer year, @Param("recordStatus") Integer recordStatus,
                                     @Param("concatUserNameList") List<String> concatUserNameList);

    Integer approve(@Param("idList") List<String> idList, @Param("approveUserID") String approveUserID, @Param("approveResult") Integer approveResult);

}
