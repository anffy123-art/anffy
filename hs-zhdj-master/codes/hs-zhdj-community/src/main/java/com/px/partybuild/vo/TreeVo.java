package com.px.partybuild.vo;

import lombok.Data;

import java.util.List;

@Data
public class TreeVo {
    private String id;

    private String parentid;

    private String name;

    private String fullids;

    private Integer sort;

    private Integer chlidShow;

    private List<TreeVo> childList;
}
