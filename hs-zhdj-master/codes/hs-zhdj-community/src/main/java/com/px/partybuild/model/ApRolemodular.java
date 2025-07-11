package com.px.partybuild.model;

public class ApRolemodular {
    private String rmid;

    private String modularid;

    private String roleid;

    private Integer iscommonuse;

    private Integer orderby;

    public String getRmid() {
        return rmid;
    }

    public void setRmid(String rmid) {
        this.rmid = rmid == null ? null : rmid.trim();
    }

    public String getModularid() {
        return modularid;
    }

    public void setModularid(String modularid) {
        this.modularid = modularid == null ? null : modularid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public Integer getIscommonuse() {
        return iscommonuse;
    }

    public void setIscommonuse(Integer iscommonuse) {
        this.iscommonuse = iscommonuse;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }
}