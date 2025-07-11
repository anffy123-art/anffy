package com.px.partybuild.vo;

import com.px.partybuild.controller.jsonmodel.DesModel;
import lombok.Data;

import java.util.Date;

@Data
public class PartyUserAdmitVo {
    private String userId;
    //学号/工号/党员编码
    private String userCode;
    private String userName;
    private String partyCode;
    private String partyName;
    private String sexId;
    private String sex;
    private String userStatus;
    private String userStatusName;
    private Date birthDate;
    private String nationalId;
    private String national;
    private String nativePlace;
    private Date applyDate;
    private Date activeDate;
    private Date passDate;
    private Date inPartyDate;
    private Date becomeFullDate;
    private Integer isArchive;
    private String isArchiveName;
    //学历
    private String educationalId;
    private String educational;
    private String idCard;
    private String gradeName;
    private String className;
    private Date enrollmentDate;
    private Date graduateDate;
    private String trainUser1;
    private String trainUser2;
    private String contactMobile;
    private Boolean isStudent;
    private String isStudentName;
    private String password;

    //入党申请审核状态
    private Integer applyApproveStatus;
    private String applyApproveStatusName;

    private String applyFileReId;

    private String userNo;

    private Date exportDate;

    public Date archiveDate;
}
