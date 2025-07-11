package com.px.partybuild.model;

public class PeTraininspectRecordWithBLOBs extends PeTraininspectRecord {
    private String practicecontent;

    private String talkcontent;

    private String activitycontent;

    private String reportcontent;

    public String getPracticecontent() {
        return practicecontent;
    }

    public void setPracticecontent(String practicecontent) {
        this.practicecontent = practicecontent == null ? null : practicecontent.trim();
    }

    public String getTalkcontent() {
        return talkcontent;
    }

    public void setTalkcontent(String talkcontent) {
        this.talkcontent = talkcontent == null ? null : talkcontent.trim();
    }

    public String getActivitycontent() {
        return activitycontent;
    }

    public void setActivitycontent(String activitycontent) {
        this.activitycontent = activitycontent == null ? null : activitycontent.trim();
    }

    public String getReportcontent() {
        return reportcontent;
    }

    public void setReportcontent(String reportcontent) {
        this.reportcontent = reportcontent == null ? null : reportcontent.trim();
    }
}