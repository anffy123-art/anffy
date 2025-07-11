package com.px.partybuild.model;

public class ApModular {
    private String mid;

    private String modulargroup;

    private String modularname;

    private Integer orderby;

    private String parentid;

    private String icon;

    private String modularno;

    private Integer modulargrouptype;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid == null ? null : mid.trim();
    }

    public String getModulargroup() {
        return modulargroup;
    }

    public void setModulargroup(String modulargroup) {
        this.modulargroup = modulargroup == null ? null : modulargroup.trim();
    }

    public String getModularname() {
        return modularname;
    }

    public void setModularname(String modularname) {
        this.modularname = modularname == null ? null : modularname.trim();
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getModularno() {
        return modularno;
    }

    public void setModularno(String modularno) {
        this.modularno = modularno == null ? null : modularno.trim();
    }

    public Integer getModulargrouptype() {
        return modulargrouptype;
    }

    public void setModulargrouptype(Integer modulargrouptype) {
        this.modulargrouptype = modulargrouptype;
    }
}