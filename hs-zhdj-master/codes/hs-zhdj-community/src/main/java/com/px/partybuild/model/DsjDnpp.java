package com.px.partybuild.model;

public class DsjDnpp {
    private String dnppbs;

    private String lbmc;

    private Integer sl;

    public String getDnppbs() {
        return dnppbs;
    }

    public void setDnppbs(String dnppbs) {
        this.dnppbs = dnppbs == null ? null : dnppbs.trim();
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