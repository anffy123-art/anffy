package com.px.partybuild.model;

import java.util.Date;

public class DjDnghbfmx {
    private String id;

    private String dnghbfid;

    private Date caredate;

    private String carecontent;

    private Integer helpformtype;

    private String helpform;

    private Integer amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDnghbfid() {
        return dnghbfid;
    }

    public void setDnghbfid(String dnghbfid) {
        this.dnghbfid = dnghbfid == null ? null : dnghbfid.trim();
    }

    public Date getCaredate() {
        return caredate;
    }

    public void setCaredate(Date caredate) {
        this.caredate = caredate;
    }

    public String getCarecontent() {
        return carecontent;
    }

    public void setCarecontent(String carecontent) {
        this.carecontent = carecontent == null ? null : carecontent.trim();
    }

    public Integer getHelpformtype() {
        return helpformtype;
    }

    public void setHelpformtype(Integer helpformtype) {
        this.helpformtype = helpformtype;
    }

    public String getHelpform() {
        return helpform;
    }

    public void setHelpform(String helpform) {
        this.helpform = helpform == null ? null : helpform.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}