package com.px.partybuild.model;

import java.util.Date;

public class DjBrand {
    private String brandid;

    private String partyname;

    private String partycode;

    private String pbrandname;

    private Integer creattype;

    private Date brandtime;

    private Date createtime;

    private String createuserid;

    private String createusername;

    private Date updatetime;

    private String updateuserid;

    private String updateusername;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    private String brandcontent;

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid == null ? null : brandid.trim();
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

    public String getPbrandname() {
        return pbrandname;
    }

    public void setPbrandname(String pbrandname) {
        this.pbrandname = pbrandname == null ? null : pbrandname.trim();
    }

    public Integer getCreattype() {
        return creattype;
    }

    public void setCreattype(Integer creattype) {
        this.creattype = creattype;
    }

    public Date getBrandtime() {
        return brandtime;
    }

    public void setBrandtime(Date brandtime) {
        this.brandtime = brandtime;
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

    public String getBrandcontent() {
        return brandcontent;
    }

    public void setBrandcontent(String brandcontent) {
        this.brandcontent = brandcontent == null ? null : brandcontent.trim();
    }
}