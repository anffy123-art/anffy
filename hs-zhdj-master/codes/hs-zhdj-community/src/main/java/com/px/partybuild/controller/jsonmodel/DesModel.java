package com.px.partybuild.controller.jsonmodel;

import java.time.LocalDateTime;
import java.util.Date;

public class DesModel {
    private String token;
    private Date tm;

    private boolean inApp;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTm() {
        return tm;
    }

    public void setTm(Date tm) {
        this.tm = tm;
    }

    public boolean isInApp() {
        return inApp;
    }

    public void setInApp(boolean inApp) {
        this.inApp = inApp;
    }
}
