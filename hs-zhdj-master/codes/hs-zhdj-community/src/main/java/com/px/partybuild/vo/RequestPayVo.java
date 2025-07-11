package com.px.partybuild.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RequestPayVo {
    public String payRelId;
    public BigDecimal payAmount;
    public String title;
    public String tradeType;
    public String openId;
}
