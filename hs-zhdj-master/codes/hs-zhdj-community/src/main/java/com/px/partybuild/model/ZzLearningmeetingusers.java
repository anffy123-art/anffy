package com.px.partybuild.model;

public class ZzLearningmeetingusers {
    private String meetinguserid;

    private String meetingid;

    private String userid;

    private String username;

    private Integer usertype;

    public String getMeetinguserid() {
        return meetinguserid;
    }

    public void setMeetinguserid(String meetinguserid) {
        this.meetinguserid = meetinguserid == null ? null : meetinguserid.trim();
    }

    public String getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(String meetingid) {
        this.meetingid = meetingid == null ? null : meetingid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }
}