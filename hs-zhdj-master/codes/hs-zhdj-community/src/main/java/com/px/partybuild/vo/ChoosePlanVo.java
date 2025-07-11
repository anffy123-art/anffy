package com.px.partybuild.vo;

import java.util.Date;

import lombok.Data;

/**
 * 选择计划实体
 * create by huang.l 2019.9.3 1425
 */
@Data
public class ChoosePlanVo extends CommonVo{
    private String sendDepartmentName;
    private String receiveDepartmentId;
    private String receiveDepartmentName;
    private String typeName;
    private Date endTime;//完成时间
    private Date publishTime;//发布时间
}

