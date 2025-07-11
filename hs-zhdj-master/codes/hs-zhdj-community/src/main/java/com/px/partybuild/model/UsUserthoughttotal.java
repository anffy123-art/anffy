package com.px.partybuild.model;

import java.util.Date;

public class UsUserthoughttotal {
    private String userthoughttotalid;

    private Integer month;

    private String partyname;

    private String partycode;

    private String writeuser;

    private String approveuser;

    private Date writetime;

    private Date createtime;

    private String createuserid;

    private String createusername;

    private Date updatetime;

    private String updateuserid;

    private String updateusername;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    private String totalcontent;

    public String getUserthoughttotalid() {
        return userthoughttotalid;
    }

    public void setUserthoughttotalid(String userthoughttotalid) {
        this.userthoughttotalid = userthoughttotalid == null ? null : userthoughttotalid.trim();
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname == null ? null : partyname.trim();
    }

    public String getPartycode() {
        return partycode;
    }

    public void setPartycode(String partycode) {
        this.partycode = partycode == null ? null : partycode.trim();
    }

    public String getWriteuser() {
        return writeuser;
    }

    public void setWriteuser(String writeuser) {
        this.writeuser = writeuser == null ? null : writeuser.trim();
    }

    public String getApproveuser() {
        return approveuser;
    }

    public void setApproveuser(String approveuser) {
        this.approveuser = approveuser == null ? null : approveuser.trim();
    }

    public Date getWritetime() {
        return writetime;
    }

    public void setWritetime(Date writetime) {
        this.writetime = writetime;
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

    public String getTotalcontent() {
        return totalcontent;
    }

    public void setTotalcontent(String totalcontent) {
        this.totalcontent = totalcontent == null ? null : totalcontent.trim();
    }
}