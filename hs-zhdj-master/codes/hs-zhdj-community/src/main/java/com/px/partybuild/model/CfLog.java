package com.px.partybuild.model;

import java.util.Date;

public class CfLog {
    private String logid;

    private String requestip;

    private Date logtime;

    private String opmodule;

    private String userid;

    private String logtitle;

    private String clientinfo;

    private Integer responsetime;

    private Integer iserror;

    private String logtext;

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid == null ? null : logid.trim();
    }

    public String getRequestip() {
        return requestip;
    }

    public void setRequestip(String requestip) {
        this.requestip = requestip == null ? null : requestip.trim();
    }

    public Date getLogtime() {
        return logtime;
    }

    public void setLogtime(Date logtime) {
        this.logtime = logtime;
    }

    public String getOpmodule() {
        return opmodule;
    }

    public void setOpmodule(String opmodule) {
        this.opmodule = opmodule == null ? null : opmodule.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getLogtitle() {
        return logtitle;
    }

    public void setLogtitle(String logtitle) {
        this.logtitle = logtitle == null ? null : logtitle.trim();
    }

    public String getClientinfo() {
        return clientinfo;
    }

    public void setClientinfo(String clientinfo) {
        this.clientinfo = clientinfo == null ? null : clientinfo.trim();
    }

    public Integer getResponsetime() {
        return responsetime;
    }

    public void setResponsetime(Integer responsetime) {
        this.responsetime = responsetime;
    }

    public Integer getIserror() {
        return iserror;
    }

    public void setIserror(Integer iserror) {
        this.iserror = iserror;
    }

    public String getLogtext() {
        return logtext;
    }

    public void setLogtext(String logtext) {
        this.logtext = logtext == null ? null : logtext.trim();
    }
}