package com.px.partybuild.model;

public class PeFlowWithBLOBs extends PeFlow {
    private String guidelines;

    private String appguidelines;

    public String getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines == null ? null : guidelines.trim();
    }

    public String getAppguidelines() {
        return appguidelines;
    }

    public void setAppguidelines(String appguidelines) {
        this.appguidelines = appguidelines == null ? null : appguidelines.trim();
    }
}