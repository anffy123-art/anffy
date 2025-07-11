package com.px.partybuild.model;

public class DjPartyactivityroomgroup {
    private String groupid;

    private String partyactivityroomid;

    private String dzzdm;

    private String dzzmc;

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    public String getPartyactivityroomid() {
        return partyactivityroomid;
    }

    public void setPartyactivityroomid(String partyactivityroomid) {
        this.partyactivityroomid = partyactivityroomid == null ? null : partyactivityroomid.trim();
    }

    public String getDzzdm() {
        return dzzdm;
    }

    public void setDzzdm(String dzzdm) {
        this.dzzdm = dzzdm == null ? null : dzzdm.trim();
    }

    public String getDzzmc() {
        return dzzmc;
    }

    public void setDzzmc(String dzzmc) {
        this.dzzmc = dzzmc == null ? null : dzzmc.trim();
    }
}