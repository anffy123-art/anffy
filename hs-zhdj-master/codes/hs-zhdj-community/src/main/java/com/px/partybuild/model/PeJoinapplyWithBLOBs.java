package com.px.partybuild.model;

public class PeJoinapplyWithBLOBs extends PeJoinapply {
    private String memo;

    private String content;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}