package com.px.partybuild.model;

import java.util.Date;

public class UsUserthought {
    private String userthoughtid;

    private String username;

    private String partyname;

    private String partycode;

    private Integer thoughttype;

    private Integer questiontype;

    private Date findtime;

    private String acceptuser;

    private String question;

    private Integer handletype;

    private Integer destroytype;

    private Date destroytime;

    private Integer handlestate;

    private Date createtime;

    private String createuserid;

    private String createusername;

    private Date updatetime;

    private String updateuserid;

    private String updateusername;

    private Date operatetime;

    private String operatestate;

    private String syncstate;

    private String handlecontent;

    public String getUserthoughtid() {
        return userthoughtid;
    }

    public void setUserthoughtid(String userthoughtid) {
        this.userthoughtid = userthoughtid == null ? null : userthoughtid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname == null ? null : partyname.trim();
    }

    public String getPartycode() {
        return partycode;
    }

    public void setPartycode(String partycode) {
        this.partycode = partycode == null ? null : partycode.trim();
    }

    public Integer getThoughttype() {
        return thoughttype;
    }

    public void setThoughttype(Integer thoughttype) {
        this.thoughttype = thoughttype;
    }

    public Integer getQuestiontype() {
        return questiontype;
    }

    public void setQuestiontype(Integer questiontype) {
        this.questiontype = questiontype;
    }

    public Date getFindtime() {
        return findtime;
    }

    public void setFindtime(Date findtime) {
        this.findtime = findtime;
    }

    public String getAcceptuser() {
        return acceptuser;
    }

    public void setAcceptuser(String acceptuser) {
        this.acceptuser = acceptuser == null ? null : acceptuser.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public Integer getHandletype() {
        return handletype;
    }

    public void setHandletype(Integer handletype) {
        this.handletype = handletype;
    }

    public Integer getDestroytype() {
        return destroytype;
    }

    public void setDestroytype(Integer destroytype) {
        this.destroytype = destroytype;
    }

    public Date getDestroytime() {
        return destroytime;
    }

    public void setDestroytime(Date destroytime) {
        this.destroytime = destroytime;
    }

    public Integer getHandlestate() {
        return handlestate;
    }

    public void setHandlestate(Integer handlestate) {
        this.handlestate = handlestate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid == null ? null : createuserid.trim();
    }

    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername == null ? null : createusername.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateuserid() {
        return updateuserid;
    }

    public void setUpdateuserid(String updateuserid) {
        this.updateuserid = updateuserid == null ? null : updateuserid.trim();
    }

    public String getUpdateusername() {
        return updateusername;
    }

    public void setUpdateusername(String updateusername) {
        this.updateusername = updateusername == null ? null : updateusername.trim();
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public String getOperatestate() {
        return operatestate;
    }

    public void setOperatestate(String operatestate) {
        this.operatestate = operatestate == null ? null : operatestate.trim();
    }

    public String getSyncstate() {
        return syncstate;
    }

    public void setSyncstate(String syncstate) {
        this.syncstate = syncstate == null ? null : syncstate.trim();
    }

    public String getHandlecontent() {
        return handlecontent;
    }

    public void setHandlecontent(String handlecontent) {
        this.handlecontent = handlecontent == null ? null : handlecontent.trim();
    }
}