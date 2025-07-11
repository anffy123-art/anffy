package com.px.partybuild.vo;

import lombok.Data;

@Data
public class PartyUserInfoVo {
    private String usertype;
    private String ryjbxxbs;
    private String rybm;
    private String xm;
    private String szdzbdm;
    private String ryzt;
    private String xjszwmc;
    private String xb;
    private String jg;
    private String mz;
    private String csrq;
    private String xl;
    private String sfzh;
    //党组织名称
    private String dzzmc;
    //政治面貌
    private String ryztmc;
    //性别名称
    private String xbmc;
    //民族名称
    private String mzmc;
    //学历名称
    private String xlmc;
    private String mobile;
    private String age;
    //现任职务
    private String zwmc;
    //党内职务
    private String dnzw;
    //技术专业职务
    private String jszwmc;
    //入党时间（党籍信息表 字段jrzgzzrq）
    private String rdsj;
    //转正时间（党籍信息表 字段zzrq）
    private String zzsj;
    //是否流动党员（党籍副表）
    private Integer sflddy;
    //是否失联党员（党籍副表）
    private Integer sfsldy;
    //党委名称
    private String dwname;
    //领导班子成员联系点
    private String contactpoint;
    private Boolean isStudent;
}
