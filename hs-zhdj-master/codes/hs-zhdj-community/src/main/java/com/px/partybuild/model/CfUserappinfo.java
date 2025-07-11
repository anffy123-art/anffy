package com.px.partybuild.model;

public class CfUserappinfo {
    private String userappinfoid;

    private String username;

    private String refuserid;

    public String getUserappinfoid() {
        return userappinfoid;
    }

    public void setUserappinfoid(String userappinfoid) {
        this.userappinfoid = userappinfoid == null ? null : userappinfoid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRefuserid() {
        return refuserid;
    }

    public void setRefuserid(String refuserid) {
        this.refuserid = refuserid == null ? null : refuserid.trim();
    }
}