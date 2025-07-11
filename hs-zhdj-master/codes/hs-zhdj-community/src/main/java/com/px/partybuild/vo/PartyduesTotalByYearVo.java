package com.px.partybuild.vo;

import lombok.Data;

import java.util.List;

@Data
public class PartyduesTotalByYearVo {
    public String partyCode;
    public String partyName;
    public Integer year;

    public List<PartyduesTotalDetailVo> detailList;

}
