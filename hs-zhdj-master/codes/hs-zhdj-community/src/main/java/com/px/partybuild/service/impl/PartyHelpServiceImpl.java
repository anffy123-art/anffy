package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.PartyHelpCQuery;
import com.px.partybuild.mapper.PartyUserCQuery;
import com.px.partybuild.mapper.UsPartyhelpMapper;
import com.px.partybuild.model.UsPartyhelp;
import com.px.partybuild.model.UsPartyhelpExample;
import com.px.partybuild.service.PartyHelpService;
import com.px.partybuild.service.PartyUserService;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.PartyHelpImportVo;
import com.px.partybuild.vo.PartyHelpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("PartyHelpService")
public class PartyHelpServiceImpl implements PartyHelpService {

    @Autowired
    private PartyHelpCQuery partyHelpCQuery;

    @Autowired
    private UsPartyhelpMapper usPartyhelpMapper;

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private PartyUserCQuery partyUserCquery;

    @Autowired
    private PartyUserService partyUserService;

    @Override
    public PageInfo<PartyHelpVo> getList(int page, int rows, String partyCode, String userName, String userCode, Integer year, Integer recordStatus) {
        PageHelper.startPage(page, rows);

        List<PartyHelpVo> list = partyHelpCQuery.selectHelpList(null, partyCode, userName, userCode, year, recordStatus, null);

        return new PageInfo<>(list);

    }

    @Override
    public PartyHelpVo get(String partyHelpID) {
        if (stringUtils.IsNullOrEmpty(partyHelpID))
            return null;

        return partyHelpCQuery.selectHelpList(partyHelpID, null, null, null, null, null, null).stream().findFirst().orElse(null);
    }

    @Override
    public Integer save(PartyHelpVo data, String userId, String userName) throws Exception {
        Integer result = 0;

        PartyHelpVo validData = getByUserId(data.getUserCode(), data.getYear());
        if (validData != null && !validData.getPartyHelpID().equals(data.getPartyHelpID()))
            throw new Exception("该党员当前年份已录入帮扶信息");

        PartyHelpVo dbData = get(data.getPartyHelpID());

        if (dbData == null) {
            data.setCreateTime(new Date());
            data.setCreateUserId(userId);
            data.setCreateUserName(userName);
            data.setRecordStatus(1);

            result = usPartyhelpMapper.insert(data);
        } else {
            data.setUpdateTime(new Date());
            data.setUpdateUserId(userId);
            data.setUpdateUserName(userName);

            result = usPartyhelpMapper.updateByPrimaryKeyWithBLOBs(data);
        }

        return result;
    }

    @Override
    public Integer delete(List<String> ids) {
        UsPartyhelpExample exp = new UsPartyhelpExample();
        exp.or().andPartyHelpIDIn(ids);

        return usPartyhelpMapper.deleteByExample(exp);
    }

    @Override
    public Integer approve(List<String> ids, String approveUserID, Integer approveResult) {
        return partyHelpCQuery.approve(ids, approveUserID, approveResult);
    }

    private PartyHelpVo getByUserId(String userCode, Integer year) {
        if (stringUtils.IsNullOrEmpty(userCode) || year == null)
            return null;

        return partyHelpCQuery.selectHelpList(null, null, null, userCode, year, null, null).stream().findFirst().orElse(null);
    }

    @Override
    public List<PartyHelpImportVo> importData(List<PartyHelpImportVo> dataList, String userID, String userName) throws Exception {
        if (dataList.size() == 0)
            throw new Exception("请添加导入数据");

        List<PartyHelpImportVo> errorList = new ArrayList<>();
        List<UsPartyhelp> resultList = new ArrayList<>();

        List<String> userPartyNames = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getUserName()) && !stringUtils.IsNullOrEmpty(it.getPartyName())).map(it -> it.getUserName().trim().concat(it.getPartyName().trim())).collect(Collectors.toList());
        List<HashMap<String, Object>> users = partyUserCquery.selectUserListByName(userPartyNames);
        List<String> userPartyYearNames = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getUserName()) && !stringUtils.IsNullOrEmpty(it.getPartyName()) && !stringUtils.IsNullOrEmpty(it.year)).map(it -> it.getUserName().trim().concat(it.getPartyName().trim()).concat(it.getYear().trim())).collect(Collectors.toList());
        List<PartyHelpVo> dbHelpList = partyHelpCQuery.selectHelpList(null, null, null, null, null, null, userPartyYearNames);

        for (int i = 0; i < dataList.size(); i++) {
            PartyHelpImportVo item = dataList.get(i);

            HashMap<String, Object> userInfo = users.stream().filter(it -> !stringUtils.IsNullOrEmpty(item.getUserName()) && !stringUtils.IsNullOrEmpty(item.getPartyName()) &&
                    it.get("XM").toString().equals(item.getUserName().trim()) && it.get("DZZMC").toString().equals(item.getPartyName().trim())).findFirst().orElse(null);

            PartyHelpVo dbItem = dbHelpList.stream().filter(it -> !stringUtils.IsNullOrEmpty(item.getUserName()) && !stringUtils.IsNullOrEmpty(item.getPartyName()) && !stringUtils.IsNullOrEmpty(item.getYear()) &&
                    it.userName.equals(item.getUserName().trim()) && it.partyName.equals(item.getPartyName().trim()) && it.getYear().toString().equals(item.getYear().trim())).findFirst().orElse(null);

            String errorInfo = "";
            Integer year = null;

            if (stringUtils.IsNullOrEmpty(item.getUserName()))
                errorInfo += "请填写党员姓名!";
            if (stringUtils.IsNullOrEmpty(item.getPartyName()))
                errorInfo += "请填写所在党组织!";
            if (stringUtils.IsNullOrEmpty(item.getYear()))
                errorInfo += "请填写年份!";
            if (stringUtils.IsNullOrEmpty(item.getHelpReason()))
                errorInfo += "请填写帮扶原因!";


            if (!stringUtils.IsNullOrEmpty(item.getYear())) {
                try {
                    year = Integer.parseInt(item.getYear());
                } catch (Exception ex) {
                    errorInfo += "年份格式错误!";
                }
            }

            if (userInfo == null)
                errorInfo += "党员信息匹配失败!请核对姓名和所在党组织是否正确!";

            if (dbItem != null)
                errorInfo += "该党员当前年份已录入帮扶信息!";

            if (stringUtils.IsNullOrEmpty(errorInfo)) {
                UsPartyhelp usPartyhelp = new UsPartyhelp();
                usPartyhelp.setUserCode(userInfo.get("RYBM").toString());
                usPartyhelp.setHelpReason(item.helpReason);
                usPartyhelp.setYear(year);
                usPartyhelp.setCreateTime(new Date());
                usPartyhelp.setCreateUserId(userID);
                usPartyhelp.setCreateUserName(userName);
                usPartyhelp.setRecordStatus(1);
                usPartyhelp.setPartyHelpID(UUID.randomUUID().toString());

                resultList.add(usPartyhelp);
            } else {
                item.setErrorInfo("第" + (i + 1) + "行，" + errorInfo);
                errorList.add(item);
            }

        }
        ;

        if (errorList.size() <= 0) {
            resultList.forEach(item -> {
                usPartyhelpMapper.insert(item);
            });
        }

        return errorList;
    }


}
