package com.px.partybuild.vo;

import com.px.partybuild.controller.jsonmodel.DesModel;
import lombok.Data;

@Data
public class RegisterVo {
    private PartyUserAdmitVo userData;
    private DesModel desData;
}
