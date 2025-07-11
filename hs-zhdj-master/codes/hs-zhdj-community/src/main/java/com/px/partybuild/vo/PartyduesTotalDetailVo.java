package com.px.partybuild.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PartyduesTotalDetailVo {
    public String partyCode;
    public String partyName;
    public Integer year;
    public Integer month;
    public BigDecimal amount;
}
