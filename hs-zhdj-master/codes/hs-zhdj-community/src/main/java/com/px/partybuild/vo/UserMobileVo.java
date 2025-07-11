package com.px.partybuild.vo;

import lombok.Data;

@Data
public class UserMobileVo {

    private String userCode;
    private String mobile;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
