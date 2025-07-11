package com.px.partybuild.model;

import java.util.Date;

public class PePutrecord {
    private String putrecordid;

    private String joinuserid;

    private Integer hasprecedure;

    private Date branchaudittime;

    private Date partyaudittime;

    private Integer auditresult;

    private Date progresstime;

    private String memo;

    private Date createtime;

    private String createuserid;

    private String createusername;

    private Date updatetime;

    private String updateuserid;

    private String updateusername;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    public String getPutrecordid() {
        return putrecordid;
    }

    public void setPutrecordid(String putrecordid) {
        this.putrecordid = putrecordid == null ? null : putrecordid.trim();
    }

    public String getJoinuserid() {
        return joinuserid;
    }

    public void setJoinuserid(String joinuserid) {
        this.joinuserid = joinuserid == null ? null : joinuserid.trim();
    }

    public Integer getHasprecedure() {
        return hasprecedure;
    }

    public void setHasprecedure(Integer hasprecedure) {
        this.hasprecedure = hasprecedure;
    }

    public Date getBranchaudittime() {
        return branchaudittime;
    }

    public void setBranchaudittime(Date branchaudittime) {
        this.branchaudittime = branchaudittime;
    }

    public Date getPartyaudittime() {
        return partyaudittime;
    }

    public void setPartyaudittime(Date partyaudittime) {
        this.partyaudittime = partyaudittime;
    }

    public Integer getAuditresult() {
        return auditresult;
    }

    public void setAuditresult(Integer auditresult) {
        this.auditresult = auditresult;
    }

    public Date getProgresstime() {
        return progresstime;
    }

    public void setProgresstime(Date progresstime) {
        this.progresstime = progresstime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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