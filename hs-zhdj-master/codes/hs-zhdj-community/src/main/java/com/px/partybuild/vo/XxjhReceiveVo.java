package com.px.partybuild.vo;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @author H
 *
 */
@Data
public class XxjhReceiveVo {
    private String faid;
    private String dwName;
    private Date createTime;
    private String receiveUserName;
    private Integer state;
    private Date receiveTime;
}
