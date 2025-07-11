package com.px.partybuild.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class DjDnghbfmxVo {
    private String id;

    private String dnghbfid;

    private Date caredate;

    private String carecontent;

    private String helpform;

    private BigDecimal amount;

    private Integer helpformtype;

    private String helpformtypename;
}
