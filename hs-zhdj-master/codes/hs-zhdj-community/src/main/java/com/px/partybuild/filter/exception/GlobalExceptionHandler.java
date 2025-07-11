package com.px.partybuild.filter.exception;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Log logger = LogFactory.getLog(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BaseException.class)
    public BaseResponse<Object> baseExceptionHandler(BaseException e) {
        logger.error("发生业务异常！原因是：" + e.getMessage());
        return RespGenerstor.fail(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(value = NullPointerException.class)
    public BaseResponse<Object> exceptionHandler(NullPointerException e) {
        logger.error("发生空指针异常！原因是：" + e);
        return RespGenerstor.fail(BaseErrorEnum.BODY_NOT_MATCH,"");
    }

    @ExceptionHandler(value = Exception.class)
    public BaseResponse<Object> exceptionHandler(Exception e) {
        logger.error("未知异常！原因是：" + e);
        return RespGenerstor.fail(BaseErrorEnum.INTERNAL_SERVER_ERROR,"");
    }

}
