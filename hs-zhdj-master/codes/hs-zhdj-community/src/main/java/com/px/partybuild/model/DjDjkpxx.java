package com.px.partybuild.model;

import java.util.Date;

public class DjDjkpxx {
    private String id;

    private String dzzmc;

    private String dzzdm;

    private Integer year;

    private Double quarter1;

    private Double quarter2;

    private Double quarter3;

    private Double quarter4;

    private Double annualscore;

    private Integer judgelevel;

    private String createuserid;

    private String createusername;

    private Date updatetime;

    private String updateuserid;

    private String updateusername;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDzzmc() {
        return dzzmc;
    }

    public void setDzzmc(String dzzmc) {
        this.dzzmc = dzzmc == null ? null : dzzmc.trim();
    }

    public String getDzzdm() {
        return dzzdm;
    }

    public void setDzzdm(String dzzdm) {
        this.dzzdm = dzzdm == null ? null : dzzdm.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getQuarter1() {
        return quarter1;
    }

    public void setQuarter1(Double quarter1) {
        this.quarter1 = quarter1;
    }

    public Double getQuarter2() {
        return quarter2;
    }

    public void setQuarter2(Double quarter2) {
        this.quarter2 = quarter2;
    }

    public Double getQuarter3() {
        return quarter3;
    }

    public void setQuarter3(Double quarter3) {
        this.quarter3 = quarter3;
    }

    public Double getQuarter4() {
        return quarter4;
    }

    public void setQuarter4(Double quarter4) {
        this.quarter4 = quarter4;
    }

    public Double getAnnualscore() {
        return annualscore;
    }

    public void setAnnualscore(Double annualscore) {
        this.annualscore = annualscore;
    }

    public Integer getJudgelevel() {
        return judgelevel;
    }

    public void setJudgelevel(Integer judgelevel) {
        this.judgelevel = judgelevel;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid == null ? null : createuserid.trim();
    }

    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername == null ? null : createusername.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuserid() {
        return updateuserid;
    }

    public void setUpdateuserid(String updateuserid) {
        this.updateuserid = updateuserid == null ? null : updateuserid.trim();
    }

    public String getUpdateusername() {
        return updateusername;
    }

    public void setUpdateusername(String updateusername) {
        this.updateusername = updateusername == null ? null : updateusername.trim();
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
}