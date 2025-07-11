package com.px.partybuild.vo;

import com.px.partybuild.model.CfLog;
import lombok.Data;

@Data
public class LogVo extends CfLog {
    private String menuname;
    private String pmenuname;
    private String username;
}
