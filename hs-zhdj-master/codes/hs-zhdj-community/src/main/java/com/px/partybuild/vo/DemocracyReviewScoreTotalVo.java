package com.px.partybuild.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DemocracyReviewScoreTotalVo {
    public String democracyReviewPlanId;
    public Integer year;
    public String title;
    public String userName;
    public String userCode;
    public String partyCode;
    public String partyName;
    public String parentCode;
    public String parentName;
    public BigDecimal score;
    public Integer reviewUserCount;
}
