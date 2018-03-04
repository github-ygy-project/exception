package com.ygy.exception.handler;

import com.ygy.exception.model.ExceptionParams;
import com.ygy.exception.model.ResultBean;
import com.ygy.exception.annotation.ExceptionHandler;
import com.ygy.exception.chain.ExceptionHandlerChain;
import com.ygy.exception.enums.ExceptionSubCodeEnum;
import org.springframework.stereotype.Component;

/**
 * Created by guoyao on 2018/2/25.
 * 空指针异常处理 jdk 自有异常
 */
@ExceptionHandler
@Component
public class NullPointExceptionHandler implements com.ygy.exception.handler.ExceptionHandler {

    @Override
    public ResultBean handlerException(Exception e, ExceptionParams exceptionParams, ExceptionHandlerChain chain) {
        if (e instanceof NullPointerException) {
           return ResultBean.ofNormalError(e,exceptionParams, ExceptionSubCodeEnum.NULL_POINT_EXCEPTION);
        }
        return  chain.doHandler(e,exceptionParams);
    }
}
