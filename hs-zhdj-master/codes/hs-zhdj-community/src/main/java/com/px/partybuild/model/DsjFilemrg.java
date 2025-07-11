package com.px.partybuild.model;

import java.util.Date;

public class DsjFilemrg {
    private String fileid;

    private String filename;

    private String fileurl;

    private String extendedname;

    private Date createdatetime;

    private String filetypeid;

    private String filecode;

    private Integer filecode2;

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

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl == null ? null : fileurl.trim();
    }

    public String getExtendedname() {
        return extendedname;
    }

    public void setExtendedname(String extendedname) {
        this.extendedname = extendedname == null ? null : extendedname.trim();
    }

    public Date getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    public String getFiletypeid() {
        return filetypeid;
    }

    public void setFiletypeid(String filetypeid) {
        this.filetypeid = filetypeid == null ? null : filetypeid.trim();
    }

    public String getFilecode() {
        return filecode;
    }

    public void setFilecode(String filecode) {
        this.filecode = filecode == null ? null : filecode.trim();
    }

    public Integer getFilecode2() {
        return filecode2;
    }

    public void setFilecode2(Integer filecode2) {
        this.filecode2 = filecode2;
    }
}