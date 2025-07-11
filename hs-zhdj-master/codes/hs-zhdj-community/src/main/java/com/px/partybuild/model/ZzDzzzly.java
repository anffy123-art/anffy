package com.px.partybuild.model;

public class ZzDzzzly {
    private String dzzzlyid;

    private String dzzdm;

    private String dzzmc;

    private String rybm;

    private String xm;

    private Integer zlytype;

    public String getDzzzlyid() {
        return dzzzlyid;
    }

    public void setDzzzlyid(String dzzzlyid) {
        this.dzzzlyid = dzzzlyid == null ? null : dzzzlyid.trim();
    }

    public String getDzzdm() {
        return dzzdm;
    }

    public void setDzzdm(String dzzdm) {
        this.dzzdm = dzzdm == null ? null : dzzdm.trim();
    }

    public String getDzzmc() {
        return dzzmc;
    }

    public void setDzzmc(String dzzmc) {
        this.dzzmc = dzzmc == null ? null : dzzmc.trim();
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm == null ? null : rybm.trim();
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm == null ? null : xm.trim();
    }

    public Integer getZlytype() {
        return zlytype;
    }

    public void setZlytype(Integer zlytype) {
        this.zlytype = zlytype;
    }
}