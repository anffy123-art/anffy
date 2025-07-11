package com.px.partybuild.filter.exception;

import java.util.Map;

public class RespGenerstor {
    public static BaseResponse success(Object data) {
        return new BaseResponse(true, BaseErrorEnum.SUCCESS.getCode(), "", data, null);
    }

    public static BaseResponse<Object> fail(BaseErrorEnum baseErrorEnum, Object data) {
        return new BaseResponse<Object>(false, baseErrorEnum.getCode(), baseErrorEnum.getMessage() + data.toString(), data, null);
    }

    public static BaseResponse<Object> fail(String code, String message) {
        return new BaseResponse<Object>(false, code, message, null, null);
    }

    /**
     * 导入时，数据不填充错误信息
     * @param baseErrorEnum 错误代码
     * @param data          接口数据
     * @return
     */
    public static BaseResponse<Object> importFail(BaseErrorEnum baseErrorEnum, Object data) {
        return new BaseResponse<Object>(false, baseErrorEnum.getCode(), baseErrorEnum.getMessage(), data, null);
    }
}
