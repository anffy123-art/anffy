package com.px.partybuild.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PartyduesTotalVo {
    public Integer year;
    public Integer month;
    public String partyCode;
    public String partyName;
    /**
     * 党员数
     */
    public Integer userCount;
    /**
     * 已缴人数
     */
    public Integer alreadyPayUserCount;
    /**
     * 已缴金额
     */
    public BigDecimal alreadyPayAmount;
    /**
     * 未缴人数
     */
    public Integer didnotPayUserCount;
    /**
     * 未缴金额
     */
    public BigDecimal didnotPayAmount;
}
