package com.px.partybuild.util;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "custom-dfs")
public class HdfsConfig {

    private String user;
    private String nameServices;
    private String defaultFs;
    private String hdfsPath;
    private List<Map<String, String>> dfsNodes;

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public String getDefaultFs() {
        return defaultFs;
    }

    public void setDefaultFs(String defaultFs) {
        this.defaultFs = defaultFs;
    }

    public List<Map<String, String>> getDfsNodes() {
        return dfsNodes;
    }

    public void setDfsNodes(List<Map<String, String>> dfsNodes) {
        this.dfsNodes = dfsNodes;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath;
    }
}
