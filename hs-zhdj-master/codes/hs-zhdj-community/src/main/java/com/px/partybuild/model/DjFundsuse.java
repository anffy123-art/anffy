package com.px.partybuild.model;

import java.util.Date;

public class DjFundsuse {
    private String fundsuseid;

    private String partycode;

    private String handleuserid;

    private String handleusername;

    private Date expendtime;

    private Integer expendmoney;

    private Integer expendscope;

    private Integer expendtype;

    private Date createtime;

    private String createuserid;

    private String createusername;

    private Date updatetime;

    private String updateuserid;

    private String updateusername;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    public String getFundsuseid() {
        return fundsuseid;
    }

    public void setFundsuseid(String fundsuseid) {
        this.fundsuseid = fundsuseid == null ? null : fundsuseid.trim();
    }

    public String getPartycode() {
        return partycode;
    }

    public void setPartycode(String partycode) {
        this.partycode = partycode == null ? null : partycode.trim();
    }

    public String getHandleuserid() {
        return handleuserid;
    }

    public void setHandleuserid(String handleuserid) {
        this.handleuserid = handleuserid == null ? null : handleuserid.trim();
    }

    public String getHandleusername() {
        return handleusername;
    }

    public void setHandleusername(String handleusername) {
        this.handleusername = handleusername == null ? null : handleusername.trim();
    }

    public Date getExpendtime() {
        return expendtime;
    }

    public void setExpendtime(Date expendtime) {
        this.expendtime = expendtime;
    }

    public Integer getExpendmoney() {
        return expendmoney;
    }

    public void setExpendmoney(Integer expendmoney) {
        this.expendmoney = expendmoney;
    }

    public Integer getExpendscope() {
        return expendscope;
    }

    public void setExpendscope(Integer expendscope) {
        this.expendscope = expendscope;
    }

    public Integer getExpendtype() {
        return expendtype;
    }

    public void setExpendtype(Integer expendtype) {
        this.expendtype = expendtype;
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