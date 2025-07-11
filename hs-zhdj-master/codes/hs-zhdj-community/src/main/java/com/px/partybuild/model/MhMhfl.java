package com.px.partybuild.model;

import java.util.Date;

public class MhMhfl {
    private String mhflbs;

    private String sjfl;

    private String flmc;

    private String lmurl;

    private Integer sfxs;

    private Integer px;

    private String bz;

    private Date cjsj;

    private Integer jb;

    public String getMhflbs() {
        return mhflbs;
    }

    public void setMhflbs(String mhflbs) {
        this.mhflbs = mhflbs == null ? null : mhflbs.trim();
    }

    public String getSjfl() {
        return sjfl;
    }

    public void setSjfl(String sjfl) {
        this.sjfl = sjfl == null ? null : sjfl.trim();
    }

    public String getFlmc() {
        return flmc;
    }

    public void setFlmc(String flmc) {
        this.flmc = flmc == null ? null : flmc.trim();
    }

    public String getLmurl() {
        return lmurl;
    }

    public void setLmurl(String lmurl) {
        this.lmurl = lmurl == null ? null : lmurl.trim();
    }

    public Integer getSfxs() {
        return sfxs;
    }

    public void setSfxs(Integer sfxs) {
        this.sfxs = sfxs;
    }

    public Integer getPx() {
        return px;
    }

    public void setPx(Integer px) {
        this.px = px;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Integer getJb() {
        return jb;
    }

    public void setJb(Integer jb) {
        this.jb = jb;
    }
}