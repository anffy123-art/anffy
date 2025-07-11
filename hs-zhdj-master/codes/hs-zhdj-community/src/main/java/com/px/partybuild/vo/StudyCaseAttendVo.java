package com.px.partybuild.vo;

import lombok.Data;

/**
 * 考勤详情实体类
 * create by huang.l 2019.8.30 17.31
 */
@Data
public class StudyCaseAttendVo {
    private String id;//方案考勤表记录ID
    private Short absent;
    private String absentReasonCode;
    private String absentReason;
    private Long speaknumber;
}
