package com.px.partybuild.service;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.vo.PartyHelpImportVo;
import com.px.partybuild.vo.PartyHelpVo;

import java.util.List;

public interface PartyHelpService {

    PageInfo<PartyHelpVo> getList(int page, int rows, String partyCode, String userName, String userCode, Integer year, Integer recordStatus);

    PartyHelpVo get(String partyHelpID);

    Integer save(PartyHelpVo data, String userId, String userName) throws Exception;

    Integer delete(List<String> ids);

    Integer approve(List<String> ids, String approveUserID, Integer approveResult);

    List<PartyHelpImportVo> importData(List<PartyHelpImportVo> dataList, String userID, String userName) throws Exception;

}
