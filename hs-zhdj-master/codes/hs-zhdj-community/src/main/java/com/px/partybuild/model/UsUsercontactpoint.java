package com.px.partybuild.model;

public class UsUsercontactpoint {
    private String id;

    private String rybm;

    private String dzzdm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm == null ? null : rybm.trim();
    }

    public String getDzzdm() {
        return dzzdm;
    }

    public void setDzzdm(String dzzdm) {
        this.dzzdm = dzzdm == null ? null : dzzdm.trim();
    }
}