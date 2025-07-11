package com.px.partybuild.model;

public class CfMenu {
    private String menuid;

    private String applicationid;

    private String parentmenuid;

    private String mnusystem;

    private Integer menuorder;

    private String menuno;

    private String menuname;

    private String menuprogram;

    private String menupic;

    private String menudesc;

    private Integer isvisible;

    private Integer isleaf;

    private Integer isblank;

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public String getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(String applicationid) {
        this.applicationid = applicationid == null ? null : applicationid.trim();
    }

    public String getParentmenuid() {
        return parentmenuid;
    }

    public void setParentmenuid(String parentmenuid) {
        this.parentmenuid = parentmenuid == null ? null : parentmenuid.trim();
    }

    public String getMnusystem() {
        return mnusystem;
    }

    public void setMnusystem(String mnusystem) {
        this.mnusystem = mnusystem == null ? null : mnusystem.trim();
    }

    public Integer getMenuorder() {
        return menuorder;
    }

    public void setMenuorder(Integer menuorder) {
        this.menuorder = menuorder;
    }

    public String getMenuno() {
        return menuno;
    }

    public void setMenuno(String menuno) {
        this.menuno = menuno == null ? null : menuno.trim();
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenuprogram() {
        return menuprogram;
    }

    public void setMenuprogram(String menuprogram) {
        this.menuprogram = menuprogram == null ? null : menuprogram.trim();
    }

    public String getMenupic() {
        return menupic;
    }

    public void setMenupic(String menupic) {
        this.menupic = menupic == null ? null : menupic.trim();
    }

    public String getMenudesc() {
        return menudesc;
    }

    public void setMenudesc(String menudesc) {
        this.menudesc = menudesc == null ? null : menudesc.trim();
    }

    public Integer getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(Integer isvisible) {
        this.isvisible = isvisible;
    }

    public Integer getIsleaf() {
        return isleaf;
    }

    public void setIsleaf(Integer isleaf) {
        this.isleaf = isleaf;
    }

    public Integer getIsblank() {
        return isblank;
    }

    public void setIsblank(Integer isblank) {
        this.isblank = isblank;
    }
}