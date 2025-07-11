package com.px.partybuild.model;

public class ApUserusemodular {
    private String uumid;

    private String modularid;

    private String userid;

    private Integer orderby;

    private Integer isdisplay;

    private String roleid;

    public String getUumid() {
        return uumid;
    }

    public void setUumid(String uumid) {
        this.uumid = uumid == null ? null : uumid.trim();
    }

    public String getModularid() {
        return modularid;
    }

    public void setModularid(String modularid) {
        this.modularid = modularid == null ? null : modularid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public Integer getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(Integer isdisplay) {
        this.isdisplay = isdisplay;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }
}