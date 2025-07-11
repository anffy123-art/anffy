package com.px.partybuild.model;

import java.util.Date;

public class DjzzrsJgfz {
    private String jgfzid;

    private String fzmc;

    private String fjgfzid;

    private String fzzt;

    private Date createTime;

    private String createPerson;

    private Date updateTime;

    private String updatePerson;

    private String comeFrom;

    private Integer version;

    private String orgId;

    private String remarks;

    private Integer orderby;

    public String getJgfzid() {
        return jgfzid;
    }

    public void setJgfzid(String jgfzid) {
        this.jgfzid = jgfzid == null ? null : jgfzid.trim();
    }

    public String getFzmc() {
        return fzmc;
    }

    public void setFzmc(String fzmc) {
        this.fzmc = fzmc == null ? null : fzmc.trim();
    }

    public String getFjgfzid() {
        return fjgfzid;
    }

    public void setFjgfzid(String fjgfzid) {
        this.fjgfzid = fjgfzid == null ? null : fjgfzid.trim();
    }

    public String getFzzt() {
        return fzzt;
    }

    public void setFzzt(String fzzt) {
        this.fzzt = fzzt == null ? null : fzzt.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson == null ? null : updatePerson.trim();
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom = comeFrom == null ? null : comeFrom.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }
}