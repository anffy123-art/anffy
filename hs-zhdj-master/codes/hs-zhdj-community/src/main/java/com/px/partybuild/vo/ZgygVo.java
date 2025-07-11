package com.px.partybuild.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ZgygVo {
    private String zgtgid;
    private String title;
    private Date closeDate;
    private String typeValue;
    private String typeName;
    private String ask;
    private String status;
    private Date createTime;
    private String createUserId;
    private String createUserName;
    private String statusName;
    private Integer dwsl;
    private Integer jssl;
}
