package com.px.partybuild.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PartyDuesPayVo {
    public String userName;
    public String userCode;
    public String partyCode;
    public String partyName;
    public String year;
    public String month;
    public Date payTime;
    public Integer payState;
    public String payStateName;
    public BigDecimal payAmount;
    public Date createTime;
    public Date modifyTime;
}
