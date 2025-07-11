package com.px.partybuild.filter.exception;

public enum BaseErrorEnum implements BaseErrorInfoInterface {
    SUCCESS("200", "成功"),
    BODY_NOT_MATCH("400", "数据格式不匹配！请联系系统管理员！"),
    NOT_FOUND("404", "访问资源不存在"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误！请联系系统管理员！"),
    USER_PASSWORD_ERROR("10001", "用户名或密码错误！"),
    DELETE_NOT_DATA_ERROR("10002", "删除的数据不存在！"),
    IMPORT_DATA_ERROR("10003", "导入数据存在错误，请查看错误列表，更正后重新导入！"),
    APP_LOGIN_ERROR("10004", "无登录App权限！");

    private String code;

    private String message;

    BaseErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
