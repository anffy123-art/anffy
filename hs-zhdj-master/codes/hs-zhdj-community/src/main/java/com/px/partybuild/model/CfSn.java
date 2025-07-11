package com.px.partybuild.model;

import java.util.Date;

public class CfSn {
    private String snid;

    private Integer snnum;

    private String snkey;

    private String prefix;

    private Date resettime;

    public String getSnid() {
        return snid;
    }

    public void setSnid(String snid) {
        this.snid = snid == null ? null : snid.trim();
    }

    public Integer getSnnum() {
        return snnum;
    }

    public void setSnnum(Integer snnum) {
        this.snnum = snnum;
    }

    public String getSnkey() {
        return snkey;
    }

    public void setSnkey(String snkey) {
        this.snkey = snkey == null ? null : snkey.trim();
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix == null ? null : prefix.trim();
    }

    public Date getResettime() {
        return resettime;
    }

    public void setResettime(Date resettime) {
        this.resettime = resettime;
    }
}