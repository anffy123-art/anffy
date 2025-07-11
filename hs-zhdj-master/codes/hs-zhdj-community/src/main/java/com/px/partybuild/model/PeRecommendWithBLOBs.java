package com.px.partybuild.model;

public class PeRecommendWithBLOBs extends PeRecommend {
    private String showcontent;

    private String opinioncontent;

    private String decisioncontent;

    public String getShowcontent() {
        return showcontent;
    }

    public void setShowcontent(String showcontent) {
        this.showcontent = showcontent == null ? null : showcontent.trim();
    }

    public String getOpinioncontent() {
        return opinioncontent;
    }

    public void setOpinioncontent(String opinioncontent) {
        this.opinioncontent = opinioncontent == null ? null : opinioncontent.trim();
    }

    public String getDecisioncontent() {
        return decisioncontent;
    }

    public void setDecisioncontent(String decisioncontent) {
        this.decisioncontent = decisioncontent == null ? null : decisioncontent.trim();
    }
}