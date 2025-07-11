package com.px.partybuild.model;

public class PeConfirmuserWithBLOBs extends PeConfirmuser {
    private String trainopinion;

    private String groupopinion;

    private String partyuseropinion;

    private String massesopinion;

    private String branchopinion;

    private String decisioncontent;

    public String getTrainopinion() {
        return trainopinion;
    }

    public void setTrainopinion(String trainopinion) {
        this.trainopinion = trainopinion == null ? null : trainopinion.trim();
    }

    public String getGroupopinion() {
        return groupopinion;
    }

    public void setGroupopinion(String groupopinion) {
        this.groupopinion = groupopinion == null ? null : groupopinion.trim();
    }

    public String getPartyuseropinion() {
        return partyuseropinion;
    }

    public void setPartyuseropinion(String partyuseropinion) {
        this.partyuseropinion = partyuseropinion == null ? null : partyuseropinion.trim();
    }

    public String getMassesopinion() {
        return massesopinion;
    }

    public void setMassesopinion(String massesopinion) {
        this.massesopinion = massesopinion == null ? null : massesopinion.trim();
    }

    public String getBranchopinion() {
        return branchopinion;
    }

    public void setBranchopinion(String branchopinion) {
        this.branchopinion = branchopinion == null ? null : branchopinion.trim();
    }

    public String getDecisioncontent() {
        return decisioncontent;
    }

    public void setDecisioncontent(String decisioncontent) {
        this.decisioncontent = decisioncontent == null ? null : decisioncontent.trim();
    }
}