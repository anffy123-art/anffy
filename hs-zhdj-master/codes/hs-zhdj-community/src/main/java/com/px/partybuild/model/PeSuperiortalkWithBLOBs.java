package com.px.partybuild.model;

public class PeSuperiortalkWithBLOBs extends PeSuperiortalk {
    private String talkcontent;

    private String reportcontent;

    public String getTalkcontent() {
        return talkcontent;
    }

    public void setTalkcontent(String talkcontent) {
        this.talkcontent = talkcontent == null ? null : talkcontent.trim();
    }

    public String getReportcontent() {
        return reportcontent;
    }

    public void setReportcontent(String reportcontent) {
        this.reportcontent = reportcontent == null ? null : reportcontent.trim();
    }
}