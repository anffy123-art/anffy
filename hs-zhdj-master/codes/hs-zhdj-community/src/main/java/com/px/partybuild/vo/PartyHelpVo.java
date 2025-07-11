package com.px.partybuild.vo;

import com.px.partybuild.model.UsPartyhelp;
import lombok.Data;

@Data
public class PartyHelpVo extends UsPartyhelp {
    public String userName;
    public String partyCode;
    public String partyName;
    public String recordStatusName;
    public String approveUserName;
    public String userNo;
}
