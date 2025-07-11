package com.px.partybuild.model;

public class UsPartyMonth extends UsPartyMonthKey {
    private String partycode;

    public String getPartycode() {
        return partycode;
    }

    public void setPartycode(String partycode) {
        this.partycode = partycode == null ? null : partycode.trim();
    }
}