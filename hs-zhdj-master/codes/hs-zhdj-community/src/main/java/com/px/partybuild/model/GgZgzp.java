package com.px.partybuild.model;

public class GgZgzp {
    private String zgzpbs;

    private String rybm;

    private String yl04;

    private String yl07;

    private byte[] grzp;

    public String getZgzpbs() {
        return zgzpbs;
    }

    public void setZgzpbs(String zgzpbs) {
        this.zgzpbs = zgzpbs == null ? null : zgzpbs.trim();
    }

    public String getRybm() {
        return rybm;
    }

    public void setRybm(String rybm) {
        this.rybm = rybm == null ? null : rybm.trim();
    }

    public String getYl04() {
        return yl04;
    }

    public void setYl04(String yl04) {
        this.yl04 = yl04 == null ? null : yl04.trim();
    }

    public String getYl07() {
        return yl07;
    }

    public void setYl07(String yl07) {
        this.yl07 = yl07 == null ? null : yl07.trim();
    }

    public byte[] getGrzp() {
        return grzp;
    }

    public void setGrzp(byte[] grzp) {
        this.grzp = grzp;
    }
}