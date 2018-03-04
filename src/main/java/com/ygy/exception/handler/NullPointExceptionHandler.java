package com.ygy.exception.handler;

import com.ygy.exception.model.ExceptionParams;
import com.ygy.exception.model.ResultBean;
import com.ygy.exception.annotation.YgyExceptionHandler;
import com.ygy.exception.chain.ExceptionHandlerChain;
import com.ygy.exception.enums.ExceptionSubCodeEnum;
import org.springframework.stereotype.Component;

/**
 * Created by guoyao on 2018/2/25.
 * 空指针异常处理 jdk 自有异常
 */
@YgyExceptionHandler
@Component
public class NullPointExceptionHandler implements ExceptionHandler {

    @Override
    public ResultBean handlerException(Exception e, ExceptionParams exceptionParams, ExceptionHandlerChain chain) {
        if (e instanceof NullPointerException) {
           return ResultBean.ofNormalError(e,exceptionParams, ExceptionSubCodeEnum.NULL_POINT_EXCEPTION);
        }
        return  chain.doHandler(e,exceptionParams);
    }
}
