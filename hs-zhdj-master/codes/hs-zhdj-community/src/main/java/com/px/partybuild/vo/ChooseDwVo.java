package com.px.partybuild.vo;

import lombok.Data;

/**
 * create by huang.l 2019.8.28 14.42
 */
@Data
public class ChooseDwVo {
    private String id;
    private String dwId;
    private String dwName;
    private String checked;
    private String secretaryNames;
    private String secretaryIds;
    private Integer state;
    private java.util.Date receiveTime;
}
