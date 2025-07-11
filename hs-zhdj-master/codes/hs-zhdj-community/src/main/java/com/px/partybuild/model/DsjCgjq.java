package com.px.partybuild.model;

public class DsjCgjq {
    private String cgjqbs;

    private String lbmc;

    private Integer sl;

    public String getCgjqbs() {
        return cgjqbs;
    }

    public void setCgjqbs(String cgjqbs) {
        this.cgjqbs = cgjqbs == null ? null : cgjqbs.trim();
    }

    public String getLbmc() {
        return lbmc;
    }

    public void setLbmc(String lbmc) {
        this.lbmc = lbmc == null ? null : lbmc.trim();
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }
}