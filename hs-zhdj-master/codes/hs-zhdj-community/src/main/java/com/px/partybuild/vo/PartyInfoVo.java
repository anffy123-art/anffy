package com.px.partybuild.vo;

import lombok.Data;

@Data
public class PartyInfoVo {
    private String zzqkxxbs;

    private String dzzdm;

    private String dzzmc;

    private String zzlb;
    //组织类别名称
    private String zzlbmc;

    private String jczzfl;
    //基层组织分类名称
    private String jczzflmc;

    private String jldzzrq;

    private String scytdzb;

    private String kzpyrq;

    private String jspyrq;

    //党员总数
    private Integer dyzs;
    //职工人数
    private Integer zgrs;
    //在岗人数
    private Integer zgcount;

    //委员数
    private Long leaderCount;
    //下级党组织数
    private Integer childCount;
    //领导届次
    private String ldjtjc;
    //上次换届时间
    private String schjsj;
    //到期换届时间
    private String dqhjsj;
    //预备党员
    private Integer ybdy;
    //积极分子
    private Integer jjfz;
    //申请入党数
    private Integer sqrd;
    //发展对象
    private Integer fzdx;
    //年度分类定级
    private String djkpLevel;
}
