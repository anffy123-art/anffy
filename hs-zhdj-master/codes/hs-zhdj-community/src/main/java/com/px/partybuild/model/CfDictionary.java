package com.px.partybuild.model;

import java.util.Date;

public class CfDictionary {
    private String dictionaryid;

    private Integer dickey;

    private String dicvalue;

    private String dictypekey;

    private Integer dictype;

    private String applicationid;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    private String dicnote;

    public String getDictionaryid() {
        return dictionaryid;
    }

    public void setDictionaryid(String dictionaryid) {
        this.dictionaryid = dictionaryid == null ? null : dictionaryid.trim();
    }

    public Integer getDickey() {
        return dickey;
    }

    public void setDickey(Integer dickey) {
        this.dickey = dickey;
    }

    public String getDicvalue() {
        return dicvalue;
    }

    public void setDicvalue(String dicvalue) {
        this.dicvalue = dicvalue == null ? null : dicvalue.trim();
    }

    public String getDictypekey() {
        return dictypekey;
    }

    public void setDictypekey(String dictypekey) {
        this.dictypekey = dictypekey == null ? null : dictypekey.trim();
    }

    public Integer getDictype() {
        return dictype;
    }

    public void setDictype(Integer dictype) {
        this.dictype = dictype;
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid == null ? null : applicationid.trim();
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

    public String getDicnote() {
        return dicnote;
    }

    public void setDicnote(String dicnote) {
        this.dicnote = dicnote == null ? null : dicnote.trim();
    }
}