package com.px.partybuild.controller.jsonmodel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;
import java.util.List;

public class SyncModel {

    private String tn;
    private Boolean wb;
    private String token;
    private Date dt;
    private Date beginTime;

    @JsonDeserialize(using = ListStrJsonDeserializer.class)
    private List<String> dataRow;

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getDataRow() {
        return dataRow;
    }

    public void setDataRow(List<String> dataRow) {
        this.dataRow = dataRow;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Boolean getWb() {
        return wb;
    }

    public void setWb(Boolean wb) {
        this.wb = wb;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }
}
