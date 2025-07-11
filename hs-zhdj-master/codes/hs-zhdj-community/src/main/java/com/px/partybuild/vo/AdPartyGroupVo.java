package com.px.partybuild.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AdPartyGroupVo {
    private String id;

    private String parentid;

    private String name;

    private String fullids;

    private Integer sort;

    private String createuserid;

    private Date createtime;

    private String modifyuserid;

    private Date modifytime;

    private List<AdPartyGroupVo> childList;
}
