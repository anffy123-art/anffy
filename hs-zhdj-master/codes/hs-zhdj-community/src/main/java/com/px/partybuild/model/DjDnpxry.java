package com.px.partybuild.model;

public class DjDnpxry {
    private String id;

    private String dnpxid;

    private String userid;

    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDnpxid() {
        return dnpxid;
    }

    public void setDnpxid(String dnpxid) {
        this.dnpxid = dnpxid == null ? null : dnpxid.trim();
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
}