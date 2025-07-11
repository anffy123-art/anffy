package com.px.partybuild.model;

public class ZzLearningplanWithBLOBs extends ZzLearningplan {
    private String request;

    private String content;

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}