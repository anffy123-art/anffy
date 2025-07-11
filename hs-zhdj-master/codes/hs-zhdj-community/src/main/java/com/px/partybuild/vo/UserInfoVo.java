package com.px.partybuild.vo;

import lombok.Data;

@Data
public class UserInfoVo {
    private String userName;
    private String userCode;
    //学号/工号，取cfuser表username
    private String mobile;
    private String partyCode;
    private String partyName;
    private String sex;
    private String national;
    private String birthDate;
    private String nativePlace;
    private String education;
    private String politicalStatus;
    private String inPartyDate;
    private String applyDate;
    private String activeDate;
    private String passDate;
    private String becomeFullDate;
    private String idCard;
    private String gradeName;
    private String className;
    private String enrollmentDate;
    private String graduateDate;
    private String workDate;
    //联系电话，取rs_ryjbxxfb表mobile
    private String contactMobile;
    private String technologyPosition;
    private String trainUser1;
    private String trainUser2;
    private String isStudent;
    private String errorInfo;
}
