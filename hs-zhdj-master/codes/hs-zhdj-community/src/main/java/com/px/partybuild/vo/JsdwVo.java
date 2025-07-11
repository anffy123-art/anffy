package com.px.partybuild.vo;

import lombok.Data;

import java.util.Date;

@Data
public class JsdwVo {
    private String dzzdm;

    private String leader;

    private String dwName;//党委名称
    private String  leaderName;//负责人名称
    private String leaderDzbName;//负责人在党支部
    private String dzbmc;//党支部名称
    private Short status;//状态
    private String statusName;
    private Date receiveTime;
    private Short issend;
    private String title;
    private String zgtgid;
    private String jsdwid;
}
