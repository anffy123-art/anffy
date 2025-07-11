package com.px.partybuild.filter.exception;

import com.px.partybuild.controller.jsonmodel.RequsetData;
import lombok.Data;

import java.util.Map;

@Data
public class BaseResponse<T> extends RequsetData<T> {

    private String code;

    public BaseResponse(Boolean success, String code, String message, T data, Map<String, Object> extData) {
        super();
        this.setExtdata(extData);
        this.setMsg(message);
        this.setItem(data);
        this.setSuccess(success);
        this.code = code;
    }

    public BaseResponse() {
        super();
    }
}
