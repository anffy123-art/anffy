package com.px.partybuild.model;

import java.util.Date;

public class DjTaskusers {
    private String id;

    private String taskid;

    private String userid;

    private String username;

    private String dzzdm;

    private String dzzmc;

    private Integer isreceive;

    private Date receivetime;

    private Integer receivenum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
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

    public String getDzzdm() {
        return dzzdm;
    }

    public void setDzzdm(String dzzdm) {
        this.dzzdm = dzzdm == null ? null : dzzdm.trim();
    }

    public String getDzzmc() {
        return dzzmc;
    }

    public void setDzzmc(String dzzmc) {
        this.dzzmc = dzzmc == null ? null : dzzmc.trim();
    }

    public Integer getIsreceive() {
        return isreceive;
    }

    public void setIsreceive(Integer isreceive) {
        this.isreceive = isreceive;
    }

    public Date getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(Date receivetime) {
        this.receivetime = receivetime;
    }

    public Integer getReceivenum() {
        return receivenum;
    }

    public void setReceivenum(Integer receivenum) {
        this.receivenum = receivenum;
    }
}