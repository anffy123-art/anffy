package com.px.partybuild.model;

import java.util.Date;

public class YsJfys {
    private String jfysid;

    private Integer nd;

    private String ysbmc;

    private Date cjsj;

    private String cjr;

    public String getJfysid() {
        return jfysid;
    }

    public void setJfysid(String jfysid) {
        this.jfysid = jfysid == null ? null : jfysid.trim();
    }

    public Integer getNd() {
        return nd;
    }

    public void setNd(Integer nd) {
        this.nd = nd;
    }

    public String getYsbmc() {
        return ysbmc;
    }

    public void setYsbmc(String ysbmc) {
        this.ysbmc = ysbmc == null ? null : ysbmc.trim();
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr == null ? null : cjr.trim();
    }
}