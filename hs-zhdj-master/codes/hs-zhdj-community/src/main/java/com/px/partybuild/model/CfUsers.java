package com.px.partybuild.model;

import java.util.Date;

public class CfUsers {
    private String userid;

    private String applicationid;

    private String username;

    private Integer isanonymous;

    private Date lastactivitydate;

    private String userpwd;

    private Integer forceloginout;

    private String oauserid;

    private String oausersfz;

    private String wxuserid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid == null ? null : applicationid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getIsanonymous() {
        return isanonymous;
    }

    public void setIsanonymous(Integer isanonymous) {
        this.isanonymous = isanonymous;
    }

    public Date getLastactivitydate() {
        return lastactivitydate;
    }

    public void setLastactivitydate(Date lastactivitydate) {
        this.lastactivitydate = lastactivitydate;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public Integer getForceloginout() {
        return forceloginout;
    }

    public void setForceloginout(Integer forceloginout) {
        this.forceloginout = forceloginout;
    }

    public String getOauserid() {
        return oauserid;
    }

    public void setOauserid(String oauserid) {
        this.oauserid = oauserid == null ? null : oauserid.trim();
    }

    public String getOausersfz() {
        return oausersfz;
    }

    public void setOausersfz(String oausersfz) {
        this.oausersfz = oausersfz == null ? null : oausersfz.trim();
    }

    public String getWxuserid() {
        return wxuserid;
    }

    public void setWxuserid(String wxuserid) {
        this.wxuserid = wxuserid == null ? null : wxuserid.trim();
    }
}