package com.px.partybuild.model;

public class PeBranchtalkWithBLOBs extends PeBranchtalk {
    private String groupopintion;

    private String decisioncontent;

    public String getGroupopintion() {
        return groupopintion;
    }

    public void setGroupopintion(String groupopintion) {
        this.groupopintion = groupopintion == null ? null : groupopintion.trim();
    }

    public String getDecisioncontent() {
        return decisioncontent;
    }

    public void setDecisioncontent(String decisioncontent) {
        this.decisioncontent = decisioncontent == null ? null : decisioncontent.trim();
    }
}