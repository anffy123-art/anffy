package com.px.partybuild.model;

public class DsjFiletype {
    private String filetypeid;

    private String parenttypeid;

    private String filetypename;

    private Integer treelevel;

    public String getFiletypeid() {
        return filetypeid;
    }

    public void setFiletypeid(String filetypeid) {
        this.filetypeid = filetypeid == null ? null : filetypeid.trim();
    }

    public String getParenttypeid() {
        return parenttypeid;
    }

    public void setParenttypeid(String parenttypeid) {
        this.parenttypeid = parenttypeid == null ? null : parenttypeid.trim();
    }

    public String getFiletypename() {
        return filetypename;
    }

    public void setFiletypename(String filetypename) {
        this.filetypename = filetypename == null ? null : filetypename.trim();
    }

    public Integer getTreelevel() {
        return treelevel;
    }

    public void setTreelevel(Integer treelevel) {
        this.treelevel = treelevel;
    }
}