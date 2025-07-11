package com.px.partybuild.model;

public class DsjDydt {
    private String dydtbs;

    private Integer nd;

    private Integer zr;

    private Integer zc;

    private Integer nbjz;

    public String getDydtbs() {
        return dydtbs;
    }

    public void setDydtbs(String dydtbs) {
        this.dydtbs = dydtbs == null ? null : dydtbs.trim();
    }

    public Integer getNd() {
        return nd;
    }

    public void setNd(Integer nd) {
        this.nd = nd;
    }

    public Integer getZr() {
        return zr;
    }

    public void setZr(Integer zr) {
        this.zr = zr;
    }

    public Integer getZc() {
        return zc;
    }

    public void setZc(Integer zc) {
        this.zc = zc;
    }

    public Integer getNbjz() {
        return nbjz;
    }

    public void setNbjz(Integer nbjz) {
        this.nbjz = nbjz;
    }
}