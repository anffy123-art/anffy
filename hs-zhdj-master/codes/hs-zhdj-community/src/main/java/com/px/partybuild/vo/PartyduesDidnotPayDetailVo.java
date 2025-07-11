package com.px.partybuild.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PartyduesDidnotPayDetailVo {
    public Integer year;
    public Integer month;
    public String partyCode;
    public String partyName;
    public String userCode;
    public String userName;
    public BigDecimal didNotPayAmount;
}
