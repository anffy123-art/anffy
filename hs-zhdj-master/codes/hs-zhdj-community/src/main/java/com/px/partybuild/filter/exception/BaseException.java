package com.px.partybuild.filter.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException {

    private String code;

    private String message;


    public BaseException() {
        super();
    }

    public BaseException(BaseErrorEnum baseErrorEnum) {
        super(baseErrorEnum.getCode());
        this.code = baseErrorEnum.getCode();
        this.message = baseErrorEnum.getMessage();
    }

    public BaseException(String code, String message) {
        super(code);
        this.code = (code == null || code.length() == 0) ? "未配置异常编码" : code;
        this.message = message;
    }
}
