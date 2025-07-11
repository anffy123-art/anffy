package com.px.partybuild.model;

public class CfLeader {
    private String leaderguid;

    private String dpid;

    private String pos;

    private String userid;

    private String sequence;

    public String getLeaderguid() {
        return leaderguid;
    }

    public void setLeaderguid(String leaderguid) {
        this.leaderguid = leaderguid == null ? null : leaderguid.trim();
    }

    public String getDpid() {
        return dpid;
    }

    public void setDpid(String dpid) {
        this.dpid = dpid == null ? null : dpid.trim();
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos == null ? null : pos.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence == null ? null : sequence.trim();
    }
}