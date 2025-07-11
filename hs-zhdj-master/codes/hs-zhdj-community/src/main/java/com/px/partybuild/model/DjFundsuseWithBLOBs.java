package com.px.partybuild.model;

public class DjFundsuseWithBLOBs extends DjFundsuse {
    private String expendreason;

    private String expenddetail;

    public String getExpendreason() {
        return expendreason;
    }

    public void setExpendreason(String expendreason) {
        this.expendreason = expendreason == null ? null : expendreason.trim();
    }

    public String getExpenddetail() {
        return expenddetail;
    }

    public void setExpenddetail(String expenddetail) {
        this.expenddetail = expenddetail == null ? null : expenddetail.trim();
    }
}