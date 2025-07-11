package com.px.partybuild.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.px.partybuild.mapper.*;
import com.px.partybuild.model.*;
import com.px.partybuild.service.PartyDicService;
import com.px.partybuild.service.PartyUserAdmitService;
import com.px.partybuild.util.DateUtils;
import com.px.partybuild.util.StringUtils;
import com.px.partybuild.vo.ApplyProgressVo;
import com.px.partybuild.vo.PartyUserAdmitVo;
import com.px.partybuild.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service("PartyUserAdmitService")
public class PartyUserAdmitServiceImpl implements PartyUserAdmitService {
    @Autowired
    private PartyUserAdmitCQuery partyUserAdmitCQuery;
    @Autowired
    private GgZgjbxxMapper ggZgjbxxMapper;
    @Autowired
    private ZzRyjbxxMapper zzRyjbxxMapper;
    @Autowired
    private RsRyjbxxfbMapper rsRyjbxxfbMapper;
    @Autowired
    private ZzDjxxMapper zzDjxxMapper;
    @Autowired
    private DateUtils dateUtils;
    @Autowired
    private PartyDicService partyDicService;
    @Autowired
    private ZzZzqkxxMapper zzZzqkxxMapper;
    @Autowired
    private StringUtils stringUtils;
    @Autowired
    private CfUsersMapper cfUsersMapper;
    @Autowired
    private CfUserrolesMapper cfUserrolesMapper;
    private String defaultPwd = "D6FB6D8741F9AF9E7BC1C39E79D73944";//zxc@qq
    private String applyRoleId = "516261b4-37b5-42a8-a74b-ef261b852b8b"; //入党申请人角色

    @Override
    public PageInfo<PartyUserAdmitVo> getPartyUserAdmitList(int pageIndex, int pageSize, String partyCode, String userCode, String userName, Integer userStatus, Date applyStartDate, Date applyEndDate, Date activeStartDate, Date activeEndDate, Date passStartDate, Date passEndDate,
                                                            Date inPatyStartDate, Date inPatyEndDate, Integer isArchive, Integer applyApproveStatus, String gradeName, String className, Integer sexId, Integer isStudent, Integer educationalId, String userNo) {
        PageHelper.startPage(pageIndex, pageSize);
        List<PartyUserAdmitVo> list = this.partyUserAdmitCQuery.selectPartyUserAdmitList(partyCode, userCode, userName, userStatus, applyStartDate, applyEndDate, activeStartDate, activeEndDate, passStartDate, passEndDate, inPatyStartDate, inPatyEndDate, isArchive, applyApproveStatus, gradeName, className, sexId, isStudent, educationalId, userNo);
        PageInfo<PartyUserAdmitVo> result = new PageInfo(list);
        return result;
    }

    public PartyUserAdmitVo getPartyUserByCode(String userCode) {
        List<PartyUserAdmitVo> list = this.partyUserAdmitCQuery.selectPartyUserAdmitList(null, userCode, null, null, null, null, null, null, null, null, null, null, null, null
                , null, null, null, null, null, null);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int save(PartyUserAdmitVo data) throws Exception {
        if (dateUtils.calculateAgeCorrect(data.getBirthDate()) < 18)
            throw new Exception("申请人必须满18岁");
        GgZgjbxx dbGgZgjbxx = getGgZgjbxxByCode(data.getUserCode());
        ZzRyjbxx dbZzRyjbxx = getZzRyjbxxByCode(data.getUserCode());
        RsRyjbxxfb dbRsRyjbxxfb = getRsRyjbxxfbByCode(data.getUserCode());
        ZzDjxx dbZzDjxx = getZzDjxxByCode(data.getUserCode());
        if (dbZzRyjbxx != null && !dbZzRyjbxx.getRyjbxxbs().equals(data.getUserId()))
            throw new Exception("学号/工号已存在");

        if (dbGgZgjbxx == null) {
            dbGgZgjbxx = new GgZgjbxx();
            dbGgZgjbxx.setRybm(data.getUserCode());
            ggZgjbxxMapper.insert(dbGgZgjbxx);
        }
        dbGgZgjbxx.setXm(data.getUserName());
        dbGgZgjbxx.setJg(data.getNativePlace());
        dbGgZgjbxx.setXb(data.getSexId());
        dbGgZgjbxx.setMz(data.getNationalId());
        dbGgZgjbxx.setCsrq(data.getBirthDate());
        dbGgZgjbxx.setQrzxl(data.getEducationalId());
        dbGgZgjbxx.setSfzh(data.getIdCard());

        if (dbZzRyjbxx == null) {
            dbZzRyjbxx = new ZzRyjbxx();
            dbZzRyjbxx.setRyjbxxbs(UUID.randomUUID().toString());
            dbZzRyjbxx.setRybm(data.getUserCode());
            zzRyjbxxMapper.insert(dbZzRyjbxx);
        }
        dbZzRyjbxx.setRyzt(data.getUserStatus());
        dbZzRyjbxx.setSzdzbdm(data.getPartyCode());
        zzRyjbxxMapper.updateByExample(dbZzRyjbxx, getZzRyjbxxExample(data.getUserCode()));

        if (dbZzDjxx == null) {
            dbZzDjxx = new ZzDjxx();
            dbZzDjxx.setDjxxbs(UUID.randomUUID().toString());
            dbZzDjxx.setRybm(data.getUserCode());
            zzDjxxMapper.insert(dbZzDjxx);
        }
        if (data.getInPartyDate() != null)
            dbZzDjxx.setJrzgzzrq(dateUtils.dateToStrFormat(data.getInPartyDate(), "yyyyMMdd"));
        if (data.getBecomeFullDate() != null)
            dbZzDjxx.setZzrq(dateUtils.dateToStrFormat(data.getBecomeFullDate(), "yyyyMMdd"));
        zzDjxxMapper.updateByExample(dbZzDjxx, getZzDjxxExample(data.getUserCode()));

        if (dbRsRyjbxxfb == null) {
            dbRsRyjbxxfb = new RsRyjbxxfb();
            dbRsRyjbxxfb.setRybm(data.getUserCode());
            rsRyjbxxfbMapper.insert(dbRsRyjbxxfb);
        }

        if (data.getActiveDate() != null && dbRsRyjbxxfb.getApplydate() != null && dateUtils.getMonthDiff(dbRsRyjbxxfb.getApplydate(), data.getActiveDate()) < 6)
            throw new Exception("申请入党6个月后才能成为积极分子");

        if (data.getPassDate() != null && dbRsRyjbxxfb.getActivedate() != null && dateUtils.getMonthDiff(dbRsRyjbxxfb.getActivedate(), data.getPassDate()) < 12)
            throw new Exception("确认积极分子一年后才能成为发展对象!");

        dbRsRyjbxxfb.setApplydate(data.getApplyDate());
        dbRsRyjbxxfb.setActivedate(data.getActiveDate());
        dbRsRyjbxxfb.setPassdate(data.getPassDate());
        dbRsRyjbxxfb.setGradename(data.getGradeName());
        dbRsRyjbxxfb.setClassname(data.getClassName());
        dbRsRyjbxxfb.setEnrollmentdate(data.getEnrollmentDate());
        dbRsRyjbxxfb.setGraduatedate(data.getGraduateDate());
        dbRsRyjbxxfb.setTrainuser1(data.getTrainUser1());
        dbRsRyjbxxfb.setTrainuser2(data.getTrainUser2());
        dbRsRyjbxxfb.setMobile(data.getContactMobile());
        dbRsRyjbxxfb.setIsstudent(data.getIsStudent());
        dbRsRyjbxxfb.setApplyapprovestatus(data.getApplyApproveStatus());
        dbRsRyjbxxfb.setPassword(data.getPassword());
        dbRsRyjbxxfb.setApplyfilereid(data.getApplyFileReId());
        rsRyjbxxfbMapper.updateByPrimaryKey(dbRsRyjbxxfb);

        if (dbRsRyjbxxfb.getApplyapprovestatus().equals(2)) {
            List<String> userCodes = new ArrayList<>();
            userCodes.add(dbRsRyjbxxfb.getRybm());
            this.audit(userCodes, 2);
        }

        if (data.getUserStatus().equals("2")) {
            //删除入党申请人角色
            CfUserrolesKey cfUserrolesKey = new CfUserrolesKey();
            cfUserrolesKey.setUserid(dbRsRyjbxxfb.getRybm());
            cfUserrolesKey.setRoleid(this.applyRoleId);
            cfUserrolesMapper.deleteByPrimaryKey(cfUserrolesKey);
        }

        return ggZgjbxxMapper.updateByExample(dbGgZgjbxx, getGgZgjbxxExample(data.getUserCode()));
    }

    public int delete(String userCode) {
        zzDjxxMapper.deleteByExample(getZzDjxxExample(userCode));
        zzRyjbxxMapper.deleteByExample(getZzRyjbxxExample(userCode));
        rsRyjbxxfbMapper.deleteByPrimaryKey(userCode);

        return ggZgjbxxMapper.deleteByExample(getGgZgjbxxExample(userCode));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<UserInfoVo> importApplyUser(List<UserInfoVo> dataList, Integer userStatus) throws Exception {
        if (dataList.size() <= 0) {
            throw new Exception("请添加导入数据");
        }
        List<UserInfoVo> errorList = new ArrayList<>();
        List<GgZgjbxx> ggZgjbxxList = new ArrayList<>();
        List<ZzRyjbxx> zzRyjbxxList = new ArrayList<>();
        List<ZzDjxx> zzDjxxList = new ArrayList<>();
        List<RsRyjbxxfb> rsRyjbxxfbList = new ArrayList<>();

        List<String> userCodes = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getUserCode())).map(it -> it.getUserCode().trim()).collect(Collectors.toList());
        List<String> partyNames = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getPartyName())).map(it -> it.getPartyName().trim()).collect(Collectors.toList());
        List<HashMap<String, Object>> educationList = partyDicService.getEducationList();
        List<HashMap<String, Object>> nationList = partyDicService.getNationList();
        List<ZzzdRyzt> ryztList = partyDicService.getRyztList();
        List<ZzZzqkxx> zzZzqkxxList = getZzZzqkxxByNameList(partyNames);
        List<GgZgjbxx> dbGgZgjbxxList = getGgZgjbxxList(userCodes);
        List<ZzRyjbxx> dbZzRyjbxxList = getZzRyjbxxList(userCodes);
        List<ZzDjxx> dbZzDjxxList = getZzDjxxList(userCodes);
        List<RsRyjbxxfb> dbRsRyjbxxfbList = getRsRyjbxxfbList(userCodes);

        if (userCodes.stream().distinct().count() != userCodes.size()) {
            throw new Exception("导入数据存在相同学号/工号，请修改后重新导入！");
        }

        for (int i = 0; i < dataList.size(); i++) {
            UserInfoVo item = dataList.get(i);

            GgZgjbxx ggZgjbxx = dbGgZgjbxxList.stream().filter(it -> !stringUtils.IsNullOrEmpty(item.getUserCode()) && it.getRybm().equals(item.getUserCode().trim())).findFirst().orElse(new GgZgjbxx());
            ZzRyjbxx zzRyjbxx = dbZzRyjbxxList.stream().filter(it -> !stringUtils.IsNullOrEmpty(item.getUserCode()) && it.getRybm().equals(item.getUserCode().trim())).findFirst().orElse(new ZzRyjbxx());
            ZzDjxx zzDjxx = dbZzDjxxList.stream().filter(it -> !stringUtils.IsNullOrEmpty(item.getUserCode()) && it.getRybm().equals(item.getUserCode().trim())).findFirst().orElse(new ZzDjxx());
            RsRyjbxxfb rsRyjbxxfb = dbRsRyjbxxfbList.stream().filter(it -> !stringUtils.IsNullOrEmpty(item.getUserCode()) && it.getRybm().equals(item.getUserCode().trim())).findFirst().orElse(new RsRyjbxxfb());
            ZzZzqkxx party = zzZzqkxxList.stream().filter(it -> !stringUtils.IsNullOrEmpty(item.getPartyName()) && it.getDzzmc().equals(item.getPartyName().trim())).findFirst().orElse(null);

            String errorInfo = "";
            Date birthDate = dateUtils.strToDateExt(item.getBirthDate());
            Date applyDate = dateUtils.strToDateExt(item.getApplyDate());
            Date enrollmentDate = dateUtils.strToDateExt(item.getEnrollmentDate());
            Date graduateDate = dateUtils.strToDateExt(item.getGraduateDate());

            if (stringUtils.IsNullOrEmpty(item.getIsStudent()))
                errorInfo += "请填写是否学生身份!";
            if (!stringUtils.IsNullOrEmpty(item.getIsStudent()) && (stringUtils.IsNullOrEmpty(item.getUserName())
                    || stringUtils.IsNullOrEmpty(item.getUserCode()) || stringUtils.IsNullOrEmpty(item.getPartyName()) || stringUtils.IsNullOrEmpty(item.getBirthDate()) || stringUtils.IsNullOrEmpty(item.getApplyDate())
                    || stringUtils.IsNullOrEmpty(item.getSex()) || stringUtils.IsNullOrEmpty(item.getNational()) || stringUtils.IsNullOrEmpty(item.getNativePlace()) || stringUtils.IsNullOrEmpty(item.getIdCard())
                    || stringUtils.IsNullOrEmpty(item.getEnrollmentDate())
                    || stringUtils.IsNullOrEmpty(item.getGraduateDate()) || stringUtils.IsNullOrEmpty(item.getEducation()) || stringUtils.IsNullOrEmpty(item.getContactMobile())
                    && item.getIsStudent().equals("是") && (stringUtils.IsNullOrEmpty(item.getClassName()) || stringUtils.IsNullOrEmpty(item.getGradeName()))
            ))
                errorInfo += "信息不全无法导入!";

            /*if (stringUtils.IsNullOrEmpty(item.getUserName()))
                errorInfo += "请填写姓名!";
            if (stringUtils.IsNullOrEmpty(item.getUserCode()))
                errorInfo += "请填写学号/工号!";
            if (stringUtils.IsNullOrEmpty(item.getPartyName()))
                errorInfo += "请填写所属党支部名称!";
            if (stringUtils.IsNullOrEmpty(item.getBirthDate()))
                errorInfo += "请填写出生日期!";
            if (stringUtils.IsNullOrEmpty(item.getApplyDate()))
                errorInfo += "请填写申请入党时间!";*/
            if (party == null)
                errorInfo += "所属党支部名称匹配失败!";
            if (!stringUtils.IsNullOrEmpty(item.getBirthDate()) && birthDate == null)
                errorInfo += "出生日期格式错误!";
            if (dateUtils.calculateAgeCorrect(birthDate) < 18)
                errorInfo += "申请人必须满18岁!";
            if (!stringUtils.IsNullOrEmpty(item.getApplyDate()) && applyDate == null)
                errorInfo += "申请入党时间格式错误!";
            if (!stringUtils.IsNullOrEmpty(item.getEnrollmentDate()) && enrollmentDate == null)
                errorInfo += "最高学历入学日期格式错误!";
            if (!stringUtils.IsNullOrEmpty(item.getGraduateDate()) && graduateDate == null)
                errorInfo += "最高学历毕业日期格式错误!";
            if (rsRyjbxxfb != null && rsRyjbxxfb.getIsarchive() != null && rsRyjbxxfb.getIsarchive().equals(1))
                errorInfo += "该人员信息已归档!";
            if (ryztList.size() > 0 && !stringUtils.IsNullOrEmpty(item.getPoliticalStatus())) {
                List<ZzzdRyzt> ryzt = ryztList.stream().filter(it -> it.getHzmc().equals(item.getPoliticalStatus().trim())).collect(Collectors.toList());
                if (ryzt.size() > 0) {
                    zzRyjbxx.setRyzt(ryzt.get(0).getBm());
                }
            }
            if (educationList.size() > 0 && !stringUtils.IsNullOrEmpty(item.getEducation())) {
                List<HashMap<String, Object>> education = educationList.stream().filter(it -> it.get("HZMC").toString().equals(item.getEducation().trim())).collect(Collectors.toList());
                if (education.size() > 0) {
                    ggZgjbxx.setQrzxl(education.get(0).get("BM").toString());
                } else {
                    errorInfo += "最高学历匹配失败!";
                }
            }
            if (nationList.size() > 0 && !stringUtils.IsNullOrEmpty(item.getNational())) {
                List<HashMap<String, Object>> nation = nationList.stream().filter(it -> it.get("HZMC").toString().equals(item.getNational().trim())).collect(Collectors.toList());
                if (nation.size() > 0) {
                    ggZgjbxx.setMz(nation.get(0).get("BM").toString());
                } else {
                    errorInfo += "民族匹配失败!";
                }
            }

            if (stringUtils.IsNullOrEmpty(errorInfo)) {
                ggZgjbxx.setRybm(item.getUserCode());
                ggZgjbxx.setXm(item.getUserName().replaceAll("\\s+", ""));
                ggZgjbxx.setJg(item.getNativePlace());
                ggZgjbxx.setXb(item.getSex().equals("男") ? "1" : "2");
                ggZgjbxx.setCsrq(birthDate);
                ggZgjbxx.setSfzh(item.getIdCard());

                if (stringUtils.IsNullOrEmpty(zzRyjbxx.getRyjbxxbs()))
                    zzRyjbxx.setRyjbxxbs(UUID.randomUUID().toString());
                zzRyjbxx.setRybm(item.getUserCode());
                zzRyjbxx.setSzdzbdm(party.getDzzdm());
                if (stringUtils.IsNullOrEmpty(zzRyjbxx.getRyzt()))
                    zzRyjbxx.setRyzt("1");

                if (stringUtils.IsNullOrEmpty(zzDjxx.getDjxxbs()))
                    zzDjxx.setDjxxbs(UUID.randomUUID().toString());
                zzDjxx.setRybm(item.getUserCode());

                rsRyjbxxfb.setRybm(item.getUserCode());
                rsRyjbxxfb.setGradename(item.getGradeName());
                rsRyjbxxfb.setClassname(item.getClassName());
                rsRyjbxxfb.setEnrollmentdate(enrollmentDate);
                rsRyjbxxfb.setGraduatedate(graduateDate);
                rsRyjbxxfb.setMobile(item.getContactMobile());
                rsRyjbxxfb.setTechnologyposition(item.getTechnologyPosition());
                rsRyjbxxfb.setApplydate(applyDate);
                rsRyjbxxfb.setMobile(item.getContactMobile());
                rsRyjbxxfb.setIsstudent(item.getIsStudent().equals("是") ? true : false);
                rsRyjbxxfb.setApplyapprovestatus(2);

                ggZgjbxxList.add(ggZgjbxx);
                zzRyjbxxList.add(zzRyjbxx);
                zzDjxxList.add(zzDjxx);
                rsRyjbxxfbList.add(rsRyjbxxfb);
            } else {
                item.setErrorInfo("第" + (i + 1) + "行，" + errorInfo);
                errorList.add(item);
            }
        }

        if (errorList.size() <= 0) {
            ggZgjbxxList.forEach(item -> {
                if (dbGgZgjbxxList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    ggZgjbxxMapper.insert(item);
                } else {
                    GgZgjbxxExample exp = new GgZgjbxxExample();
                    GgZgjbxxExample.Criteria cri = exp.or().andRybmEqualTo(item.getRybm());
                    ggZgjbxxMapper.updateByExample(item, exp);
                }
            });
            zzRyjbxxList.forEach(item -> {
                if (dbZzRyjbxxList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    zzRyjbxxMapper.insert(item);
                } else {
                    ZzRyjbxxExample exp = new ZzRyjbxxExample();
                    ZzRyjbxxExample.Criteria cri = exp.or().andRybmEqualTo(item.getRybm());
                    zzRyjbxxMapper.updateByExample(item, exp);
                }
            });
            zzDjxxList.forEach(item -> {
                if (dbZzDjxxList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    zzDjxxMapper.insert(item);
                } else {
                    ZzDjxxExample exp = new ZzDjxxExample();
                    ZzDjxxExample.Criteria cri = exp.or().andRybmEqualTo(item.getRybm());
                    zzDjxxMapper.updateByExample(item, exp);
                }
            });
            rsRyjbxxfbList.forEach(item -> {
                if (dbRsRyjbxxfbList.stream().filter(it -> it.getRybm().equals(item.getRybm())).count() == 0) {
                    rsRyjbxxfbMapper.insert(item);
                } else {
                    rsRyjbxxfbMapper.updateByPrimaryKey(item);
                }
            });

            this.audit(userCodes, 2);
        }

        return errorList;
    }

    private List<GgZgjbxx> getGgZgjbxxList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        GgZgjbxxExample exp = new GgZgjbxxExample();
        GgZgjbxxExample.Criteria cri = exp.or().andRybmIn(ids);
        return ggZgjbxxMapper.selectByExample(exp);
    }

    private List<ZzRyjbxx> getZzRyjbxxList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        ZzRyjbxxExample exp = new ZzRyjbxxExample();
        ZzRyjbxxExample.Criteria cri = exp.or().andRybmIn(ids);
        return zzRyjbxxMapper.selectByExample(exp);
    }

    private List<ZzDjxx> getZzDjxxList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        ZzDjxxExample exp = new ZzDjxxExample();
        ZzDjxxExample.Criteria cri = exp.or().andRybmIn(ids);
        return zzDjxxMapper.selectByExample(exp);
    }

    private List<ZzZzqkxx> getZzZzqkxxByNameList(List<String> names) {
        if (names.size() == 0)
            return new ArrayList<>();
        ZzZzqkxxExample exp = new ZzZzqkxxExample();
        ZzZzqkxxExample.Criteria cri = exp.or().andDzzmcIn(names);
        return zzZzqkxxMapper.selectByExample(exp);
    }

    private List<RsRyjbxxfb> getRsRyjbxxfbList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        RsRyjbxxfbExample exp = new RsRyjbxxfbExample();
        RsRyjbxxfbExample.Criteria cri = exp.or().andRybmIn(ids);
        return rsRyjbxxfbMapper.selectByExample(exp);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<UserInfoVo> updateUserProgress(List<UserInfoVo> dataList, Integer userStatus) throws Exception {
        if (dataList.size() <= 0) {
            throw new Exception("请添加导入数据");
        }
        List<UserInfoVo> errorList = new ArrayList<>();
        List<RsRyjbxxfb> resultList1 = new ArrayList<>();
        List<ZzRyjbxx> resultList2 = new ArrayList<>();
        List<ZzDjxx> resultList3 = new ArrayList<>();

        List<String> userCodes = dataList.stream().filter(it -> !stringUtils.IsNullOrEmpty(it.getUserCode())).map(it -> it.getUserCode().trim()).collect(Collectors.toList());
        List<GgZgjbxx> ggZgjbxxList = new ArrayList<>();
        List<RsRyjbxxfb> rsRyjbxxfbList = new ArrayList<>();
        List<ZzRyjbxx> zzRyjbxxList = new ArrayList<>();
        List<ZzDjxx> zzDjxxList = new ArrayList<>();
        List<CfUsers> dbCfUsersList = getCfUsersList(userCodes);
        if (userCodes.size() > 0) {
            GgZgjbxxExample exp0 = new GgZgjbxxExample();
            GgZgjbxxExample.Criteria cri0 = exp0.or().andRybmIn(userCodes);
            ggZgjbxxList = ggZgjbxxMapper.selectByExample(exp0);

            RsRyjbxxfbExample exp1 = new RsRyjbxxfbExample();
            RsRyjbxxfbExample.Criteria cri1 = exp1.or().andRybmIn(userCodes);
            rsRyjbxxfbList = rsRyjbxxfbMapper.selectByExample(exp1);

            ZzRyjbxxExample exp2 = new ZzRyjbxxExample();
            ZzRyjbxxExample.Criteria cri2 = exp2.or().andRybmIn(userCodes);
            zzRyjbxxList = zzRyjbxxMapper.selectByExample(exp2);

            ZzDjxxExample exp3 = new ZzDjxxExample();
            ZzDjxxExample.Criteria cri3 = exp3.or().andRybmIn(userCodes);
            zzDjxxList = zzDjxxMapper.selectByExample(exp3);
        }

        for (int i = 0; i < dataList.size(); i++) {
            UserInfoVo item = dataList.get(i);
            String errorInfo = "";

            if (stringUtils.IsNullOrEmpty(item.getUserCode())) {
                errorInfo += "请填写学号/工号!";
            }
            if (stringUtils.IsNullOrEmpty(errorInfo)) {
                List<GgZgjbxx> ggUserList = ggZgjbxxList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).collect(Collectors.toList());
                List<RsRyjbxxfb> fbList = rsRyjbxxfbList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).collect(Collectors.toList());
                List<ZzRyjbxx> userList = zzRyjbxxList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).collect(Collectors.toList());
                List<ZzDjxx> djList = zzDjxxList.stream().filter(it -> it.getRybm().equals(item.getUserCode())).collect(Collectors.toList());

                RsRyjbxxfb rsRyjbxxfb = fbList.size() > 0 ? fbList.get(0) : null;
                ZzRyjbxx zzRyjbxx = userList.size() > 0 ? userList.get(0) : null;
                ZzDjxx zzDjxx = djList.size() > 0 ? djList.get(0) : null;

                if (ggUserList.size() <= 0 || zzRyjbxx == null) {
                    errorInfo += "学号/工号匹配失败!";
                } else {
                    if (rsRyjbxxfb == null) {
                        rsRyjbxxfb = new RsRyjbxxfb();
                        rsRyjbxxfb.setRybm(item.getUserCode());
                        rsRyjbxxfbMapper.insert(rsRyjbxxfb);
                    }
                    if (zzDjxx == null) {
                        zzDjxx.setDjxxbs(UUID.randomUUID().toString());
                        zzDjxx.setRybm(item.getUserCode());
                        zzDjxxMapper.insert(zzDjxx);
                    }
                }

                if (rsRyjbxxfb != null && rsRyjbxxfb.getIsarchive() != null && rsRyjbxxfb.getIsarchive().equals(1))
                    errorInfo += "该人员信息已归档!";

                if (zzRyjbxx != null) {
                    switch (userStatus) {
                        case 5://入党积极分子
                            if (zzRyjbxx.getRyzt() == null || !zzRyjbxx.getRyzt().equals("1"))
                                errorInfo += "该成员当前状态不是入党申请人!";
                            try {
                                Date activeDate = dateUtils.strToDateExt(item.getActiveDate().trim());
                                if (activeDate == null) {
                                    throw new Exception("");
                                }
                                rsRyjbxxfb.setActivedate(activeDate);

                                if (dateUtils.getMonthDiff(rsRyjbxxfb.getApplydate(), activeDate) < 6)
                                    errorInfo += "申请入党6个月后才能成为积极分子!";

                            } catch (Exception ex) {
                                errorInfo += "确定积极分子时间格式错误!";
                            }
                            rsRyjbxxfb.setTrainuser1(item.getTrainUser1());
                            rsRyjbxxfb.setTrainuser2(item.getTrainUser2());
                            rsRyjbxxfb.setMobile(item.getContactMobile());
                            break;
                        case 6://发展对象
                            if (zzRyjbxx.getRyzt() == null || !zzRyjbxx.getRyzt().equals("5"))
                                errorInfo += "该成员当前状态不是积极分子!";
                            try {
                                Date passDate = dateUtils.strToDateExt(item.getPassDate().trim());
                                if (passDate == null) {
                                    throw new Exception("");
                                }
                                rsRyjbxxfb.setPassdate(passDate);

                                if (dateUtils.getMonthDiff(rsRyjbxxfb.getActivedate(), passDate) < 12)
                                    errorInfo += "确认积极分子一年后才能成为发展对象!";
                            } catch (Exception ex) {
                                errorInfo += "确认发展对象日期格式错误!";
                            }
                            break;
                        case 2://预备党员
                            if (zzRyjbxx.getRyzt() == null || !zzRyjbxx.getRyzt().equals("6"))
                                errorInfo += "该成员当前状态不是发展对象!";
                            try {
                                String inPartyDate = dateUtils.dateToStrFormat(dateUtils.strToDateExt(item.getInPartyDate().trim()), "yyyyMMdd");
                                if (stringUtils.IsNullOrEmpty(inPartyDate)) {
                                    throw new Exception("");
                                }
                                zzDjxx.setJrzgzzrq(inPartyDate);
                            } catch (Exception ex) {
                                errorInfo += "入党日期格式错误!";
                            }
                            break;
                        case 3://正式党员
                            if (zzRyjbxx.getRyzt() == null || !zzRyjbxx.getRyzt().equals("2"))
                                errorInfo += "该成员当前状态不是预备党员!";
                            try {
                                String becomeFullDate = dateUtils.dateToStrFormat(dateUtils.strToDateExt(item.getBecomeFullDate().trim()), "yyyyMMdd");
                                if (stringUtils.IsNullOrEmpty(becomeFullDate)) {
                                    throw new Exception("");
                                }
                                zzDjxx.setZzrq(becomeFullDate);
                            } catch (Exception ex) {
                                errorInfo += "转正日期格式错误!";
                            }
                            break;
                    }

                    zzRyjbxx.setRyzt(userStatus.toString());

                    resultList1.add(rsRyjbxxfb);
                    resultList2.add(zzRyjbxx);
                    resultList3.add(zzDjxx);
                }
            }

            if (!stringUtils.IsNullOrEmpty(errorInfo)) {
                item.setErrorInfo("第" + (i + 1) + "行，" + errorInfo);
                errorList.add(item);
            }
        }

        if (errorList.size() <= 0) {
            resultList1.forEach(item -> {
                rsRyjbxxfbMapper.updateByPrimaryKey(item);

                //转入预备党员，添加用户表
                if (userStatus.equals(2)) {
                    if (dbCfUsersList.stream().filter(it -> it.getUserid().equals(item.getRybm())).count() == 0) {
                        CfUsers cfUsers = new CfUsers();
                        cfUsers.setUserid(item.getRybm());
                        cfUsers.setUsername(item.getRybm());
                        cfUsers.setApplicationid("f0c4fa7f9f3c4fb6bd56aac608b7ad3f");
                        cfUsers.setIsanonymous(1);
                        cfUsers.setUserpwd(this.defaultPwd);
                        cfUsersMapper.insert(cfUsers);
                    }

                    //删除入党申请人角色
                    CfUserrolesKey cfUserrolesKey = new CfUserrolesKey();
                    cfUserrolesKey.setUserid(item.getRybm());
                    cfUserrolesKey.setRoleid(this.applyRoleId);
                    cfUserrolesMapper.deleteByPrimaryKey(cfUserrolesKey);
                }
            });
            resultList2.forEach(item -> {
                zzRyjbxxMapper.updateByExample(item, getZzRyjbxxExample(item.getRybm()));
            });
            resultList3.forEach(item -> {
                zzDjxxMapper.updateByExample(item, getZzDjxxExample(item.getRybm()));
            });

        }

        return errorList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int archive(List<String> userCodeList, Date exportDate, String exportPartyName,Date archiveDate) throws Exception {

        RsRyjbxxfbExample exp = new RsRyjbxxfbExample();
        RsRyjbxxfbExample.Criteria cri = exp.or().andRybmIn(userCodeList);
        List<RsRyjbxxfb> rsRyjbxxfbList = rsRyjbxxfbMapper.selectByExample(exp);
        rsRyjbxxfbList.forEach(item -> {
            item.setIsarchive(1);
            item.setExportdate(exportDate);
            item.setExportpartyname(exportPartyName);
            item.setArchivedate(archiveDate);
            rsRyjbxxfbMapper.updateByPrimaryKey(item);
        });

        return rsRyjbxxfbList.size();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int unArchive(List<String> userCodeList) throws Exception {

        RsRyjbxxfbExample exp = new RsRyjbxxfbExample();
        RsRyjbxxfbExample.Criteria cri = exp.or().andRybmIn(userCodeList);
        List<RsRyjbxxfb> rsRyjbxxfbList = rsRyjbxxfbMapper.selectByExample(exp);
        rsRyjbxxfbList.forEach(item -> {
            item.setIsarchive(0);
            item.setExportdate(null);
            item.setExportpartyname(null);
            item.setArchivedate(null);
            rsRyjbxxfbMapper.updateByPrimaryKey(item);
        });

        return rsRyjbxxfbList.size();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int audit(List<String> userCodeList, Integer applyApproveStatus) throws Exception {
        RsRyjbxxfbExample exp = new RsRyjbxxfbExample();
        RsRyjbxxfbExample.Criteria cri = exp.or().andRybmIn(userCodeList);
        List<RsRyjbxxfb> rsRyjbxxfbList = rsRyjbxxfbMapper.selectByExample(exp);
        List<CfUsers> dbCfUsersList = getCfUsersList(userCodeList);
        List<CfUserrolesKey> dbCfUserroleList = getCfUserroleList(userCodeList);

        rsRyjbxxfbList.forEach(item -> {
            item.setApplyapprovestatus(applyApproveStatus);

            if (applyApproveStatus.equals(3))
                item.setIsarchive(1);

            rsRyjbxxfbMapper.updateByPrimaryKey(item);

            if (applyApproveStatus.equals(2) && dbCfUsersList.stream().filter(it -> it.getUserid().equals(item.getRybm())).count() == 0) {
                CfUsers cfUsers = new CfUsers();
                cfUsers.setUserid(item.getRybm());
                cfUsers.setUsername(item.getRybm());
                cfUsers.setApplicationid("f0c4fa7f9f3c4fb6bd56aac608b7ad3f");
                cfUsers.setIsanonymous(1);
                cfUsers.setUserpwd(!stringUtils.IsNullOrEmpty(item.getPassword()) ? item.getPassword() : this.defaultPwd);
                cfUsersMapper.insert(cfUsers);
            }

            if (applyApproveStatus.equals(2) && dbCfUserroleList.stream().filter(it -> it.getUserid().equals(item.getRybm()) && it.getRoleid().equals(this.applyRoleId)).count() == 0) {
                CfUserrolesKey cfUserrolesKey = new CfUserrolesKey();
                cfUserrolesKey.setUserid(item.getRybm());
                cfUserrolesKey.setRoleid(this.applyRoleId);
                cfUserrolesMapper.insert(cfUserrolesKey);
            }

        });

        return rsRyjbxxfbList.size();
    }

    @Override
    public List<ApplyProgressVo> getApplyProgressList(String userCode) {
        List<ApplyProgressVo> result = new ArrayList<>();
        PartyUserAdmitVo data = this.getPartyUserByCode(userCode);

        for (int i = 1; i <= 5; i++) {
            ApplyProgressVo progressVo = new ApplyProgressVo();
            switch (i) {
                case 1:
                    progressVo.setName("入党申请");
                    progressVo.setPassDate(data.getApplyDate());
                    break;
                case 2:
                    progressVo.setName("积极分子");
                    progressVo.setPassDate(data.getActiveDate());
                    break;
                case 3:
                    progressVo.setName("发展对象");
                    progressVo.setPassDate(data.getPassDate());
                    break;
                case 4:
                    progressVo.setName("预备党员");
                    progressVo.setPassDate(data.getInPartyDate());
                    break;
                case 5:
                    progressVo.setName("正式党员");
                    progressVo.setPassDate(data.getBecomeFullDate());
                    break;
            }

            result.add(progressVo);
        }

        return result;
    }

    private List<CfUsers> getCfUsersList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        CfUsersExample exp = new CfUsersExample();
        CfUsersExample.Criteria cri = exp.or().andUseridIn(ids);
        return cfUsersMapper.selectByExample(exp);
    }

    private List<CfUserrolesKey> getCfUserroleList(List<String> ids) {
        if (ids.size() == 0)
            return new ArrayList<>();
        CfUserrolesExample exp = new CfUserrolesExample();
        CfUserrolesExample.Criteria cri = exp.or().andUseridIn(ids);
        return cfUserrolesMapper.selectByExample(exp);
    }

    private GgZgjbxx getGgZgjbxxByCode(String userCode) {
        List<GgZgjbxx> list = ggZgjbxxMapper.selectByExample(getGgZgjbxxExample(userCode));
        return list.size() > 0 ? list.get(0) : null;
    }

    private ZzRyjbxx getZzRyjbxxByCode(String userCode) {
        List<ZzRyjbxx> list = zzRyjbxxMapper.selectByExample(getZzRyjbxxExample(userCode));
        return list.size() > 0 ? list.get(0) : null;
    }

    private RsRyjbxxfb getRsRyjbxxfbByCode(String userCode) {
        List<RsRyjbxxfb> list = rsRyjbxxfbMapper.selectByExample(getRsRyjbxxfbExample(userCode));
        return list.size() > 0 ? list.get(0) : null;
    }

    private ZzDjxx getZzDjxxByCode(String userCode) {
        List<ZzDjxx> list = zzDjxxMapper.selectByExample(getZzDjxxExample(userCode));
        return list.size() > 0 ? list.get(0) : null;
    }

    private GgZgjbxxExample getGgZgjbxxExample(String userCode) {
        GgZgjbxxExample exp = new GgZgjbxxExample();
        GgZgjbxxExample.Criteria cri = exp.or();
        cri.andRybmEqualTo(userCode);
        return exp;
    }

    private ZzRyjbxxExample getZzRyjbxxExample(String userCode) {
        ZzRyjbxxExample exp = new ZzRyjbxxExample();
        ZzRyjbxxExample.Criteria cri = exp.or();
        cri.andRybmEqualTo(userCode);
        return exp;
    }

    private RsRyjbxxfbExample getRsRyjbxxfbExample(String userCode) {
        RsRyjbxxfbExample exp = new RsRyjbxxfbExample();
        RsRyjbxxfbExample.Criteria cri = exp.or();
        cri.andRybmEqualTo(userCode);
        return exp;
    }

    private ZzDjxxExample getZzDjxxExample(String userCode) {
        ZzDjxxExample exp = new ZzDjxxExample();
        ZzDjxxExample.Criteria cri = exp.or();
        cri.andRybmEqualTo(userCode);
        return exp;
    }


}
