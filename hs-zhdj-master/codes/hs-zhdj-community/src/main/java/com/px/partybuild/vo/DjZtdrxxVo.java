package com.px.partybuild.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DjZtdrxxVo {
    private String id;

    private String dzzmc;

    private String dzzdm;

    private String title;

    private Date activitytime;

    private String location;

    private BigDecimal subjecttype;

    private String createuserid;

    private String createusername;

    private Date updatetime;

    private String updateuserid;

    private String updateusername;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    private String subjectcontent;

    private String subjecttypename;

    private String fileid;

    private String fileurl;

    private String dwmc;
}
