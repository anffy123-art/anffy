package com.px.partybuild.model;

import java.util.Date;

public class CfFile {
    private String fileid;

    private String filename;

    private String filesuffix;

    private String fileurl;

    private Integer filetype;

    private String sfileid;

    private String userid;

    private String filerefid;

    private Date createtime;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    private String filenote;

    public String getFileid() {
        return fileid;
    }

    public void setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFilesuffix() {
        return filesuffix;
    }

    public void setFilesuffix(String filesuffix) {
        this.filesuffix = filesuffix == null ? null : filesuffix.trim();
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public Integer getFiletype() {
        return filetype;
    }

    public void setFiletype(Integer filetype) {
        this.filetype = filetype;
    }

    public String getSfileid() {
        return sfileid;
    }

    public void setSfileid(String sfileid) {
        this.sfileid = sfileid == null ? null : sfileid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getFilerefid() {
        return filerefid;
    }

    public void setFilerefid(String filerefid) {
        this.filerefid = filerefid == null ? null : filerefid.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public String getFilenote() {
        return filenote;
    }

    public void setFilenote(String filenote) {
        this.filenote = filenote == null ? null : filenote.trim();
    }
}