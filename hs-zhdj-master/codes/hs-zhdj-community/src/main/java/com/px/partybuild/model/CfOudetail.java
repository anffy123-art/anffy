package com.px.partybuild.model;

public class CfOudetail {
    private String dpkey;

    private String dpid;

    private String dpname;

    private String parentdpid;

    private String dpfullname;

    private String dpcode;

    private String istmpdp;

    private String deptorderno;

    private Integer isdel;

    public String getDpkey() {
        return dpkey;
    }

    public void setDpkey(String dpkey) {
        this.dpkey = dpkey == null ? null : dpkey.trim();
    }

    public String getDpid() {
        return dpid;
    }

    public void setDpid(String dpid) {
        this.dpid = dpid == null ? null : dpid.trim();
    }

    public String getDpname() {
        return dpname;
    }

    public void setDpname(String dpname) {
        this.dpname = dpname == null ? null : dpname.trim();
    }

    public String getParentdpid() {
        return parentdpid;
    }

    public void setParentdpid(String parentdpid) {
        this.parentdpid = parentdpid == null ? null : parentdpid.trim();
    }

    public String getDpfullname() {
        return dpfullname;
    }

    public void setDpfullname(String dpfullname) {
        this.dpfullname = dpfullname == null ? null : dpfullname.trim();
    }

    public String getDpcode() {
        return dpcode;
    }

    public void setDpcode(String dpcode) {
        this.dpcode = dpcode == null ? null : dpcode.trim();
    }

    public String getIstmpdp() {
        return istmpdp;
    }

    public void setIstmpdp(String istmpdp) {
        this.istmpdp = istmpdp == null ? null : istmpdp.trim();
    }

    public String getDeptorderno() {
        return deptorderno;
    }

    public void setDeptorderno(String deptorderno) {
        this.deptorderno = deptorderno == null ? null : deptorderno.trim();
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }
}