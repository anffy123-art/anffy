package com.px.partybuild.model;

import java.util.Date;

public class ZzLearningmeeting {
    private String meetingid;

    private String dzzdm;

    private String meetingname;

    private String location;

    private Date meetingdate;

    private String topics;

    private String remark;

    private Date createtime;

    private String createuserid;

    private String createusername;

    private Date updatetime;

    private String updateuserid;

    private String updateusername;

    public String getMeetingid() {
        return meetingid;
    }

    public void setMeetingid(String meetingid) {
        this.meetingid = meetingid == null ? null : meetingid.trim();
    }

    public String getDzzdm() {
        return dzzdm;
    }

    public void setDzzdm(String dzzdm) {
        this.dzzdm = dzzdm == null ? null : dzzdm.trim();
    }

    public String getMeetingname() {
        return meetingname;
    }

    public void setMeetingname(String meetingname) {
        this.meetingname = meetingname == null ? null : meetingname.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getMeetingdate() {
        return meetingdate;
    }

    public void setMeetingdate(Date meetingdate) {
        this.meetingdate = meetingdate;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics == null ? null : topics.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}