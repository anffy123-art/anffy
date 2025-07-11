package com.px.partybuild.model;

import java.util.Date;

public class MhSylm {
    private String sylmbs;

    private Integer lmlx;

    private String lmbt;

    private String lmtpdz;

    private String xqdz;

    private Integer zt;

    private Integer sx;

    private String yl1;

    private String yl2;

    private Date cjsj;

    public String getSylmbs() {
        return sylmbs;
    }

    public void setSylmbs(String sylmbs) {
        this.sylmbs = sylmbs == null ? null : sylmbs.trim();
    }

    public Integer getLmlx() {
        return lmlx;
    }

    public void setLmlx(Integer lmlx) {
        this.lmlx = lmlx;
    }

    public String getLmbt() {
        return lmbt;
    }

    public void setLmbt(String lmbt) {
        this.lmbt = lmbt == null ? null : lmbt.trim();
    }

    public String getLmtpdz() {
        return lmtpdz;
    }

    public void setLmtpdz(String lmtpdz) {
        this.lmtpdz = lmtpdz == null ? null : lmtpdz.trim();
    }

    public String getXqdz() {
        return xqdz;
    }

    public void setXqdz(String xqdz) {
        this.xqdz = xqdz == null ? null : xqdz.trim();
    }

    public Integer getZt() {
        return zt;
    }

    public void setZt(Integer zt) {
        this.zt = zt;
    }

    public Integer getSx() {
        return sx;
    }

    public void setSx(Integer sx) {
        this.sx = sx;
    }

    public String getYl1() {
        return yl1;
    }

    public void setYl1(String yl1) {
        this.yl1 = yl1 == null ? null : yl1.trim();
    }

    public String getYl2() {
        return yl2;
    }

    public void setYl2(String yl2) {
        this.yl2 = yl2 == null ? null : yl2.trim();
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }
}