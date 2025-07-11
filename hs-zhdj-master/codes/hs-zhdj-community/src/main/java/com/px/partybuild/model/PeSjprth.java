package com.px.partybuild.model;

import java.util.Date;

public class PeSjprth {
    private String sjprthid;

    private String joinuserid;

    private Date talktime;

    private Date progresstime;

    private Date createtime;

    private String createuserid;

    private String createusername;

    private Date updatetime;

    private String updateuserid;

    private String updateusername;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    public String getSjprthid() {
        return sjprthid;
    }

    public void setSjprthid(String sjprthid) {
        this.sjprthid = sjprthid == null ? null : sjprthid.trim();
    }

    public String getJoinuserid() {
        return joinuserid;
    }

    public void setJoinuserid(String joinuserid) {
        this.joinuserid = joinuserid == null ? null : joinuserid.trim();
    }

    public Date getTalktime() {
        return talktime;
    }

    public void setTalktime(Date talktime) {
        this.talktime = talktime;
    }

    public Date getProgresstime() {
        return progresstime;
    }

    public void setProgresstime(Date progresstime) {
        this.progresstime = progresstime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid == null ? null : createuserid.trim();
    }

    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername == null ? null : createusername.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuserid() {
        return updateuserid;
    }

    public void setUpdateuserid(String updateuserid) {
        this.updateuserid = updateuserid == null ? null : updateuserid.trim();
    }

    public String getUpdateusername() {
        return updateusername;
    }

    public void setUpdateusername(String updateusername) {
        this.updateusername = updateusername == null ? null : updateusername.trim();
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public String getOperatestate() {
        return operatestate;
    }

    public void setOperatestate(String operatestate) {
        this.operatestate = operatestate == null ? null : operatestate.trim();
    }

    public String getSyncstate() {
        return syncstate;
    }

    public void setSyncstate(String syncstate) {
        this.syncstate = syncstate == null ? null : syncstate.trim();
    }
}