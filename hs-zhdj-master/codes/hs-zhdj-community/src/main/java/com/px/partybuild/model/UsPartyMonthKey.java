package com.px.partybuild.model;

public class UsPartyMonthKey {
    private Integer yearmonth;

    private String usercode;

    public Integer getYearmonth() {
        return yearmonth;
    }

    public void setYearmonth(Integer yearmonth) {
        this.yearmonth = yearmonth;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }
}