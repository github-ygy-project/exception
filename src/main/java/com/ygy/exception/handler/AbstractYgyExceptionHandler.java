package com.ygy.exception.handler;

import com.ygy.exception.model.AbstractException;
import com.ygy.exception.model.ExceptionParams;
import com.ygy.exception.model.ResultBean;
import com.ygy.exception.annotation.YgyExceptionHandler;
import com.ygy.exception.chain.ExceptionHandlerChain;
import org.springframework.stereotype.Component;


/**
 * Created by guoyao on 2018/2/25.
 * 自定义业务异常 统一处理异常
 */
@Component
@YgyExceptionHandler(order = "100")
public class AbstractYgyExceptionHandler implements ExceptionHandler {

    @Override
    public ResultBean handlerException(Exception e, ExceptionParams exceptionParams, ExceptionHandlerChain chain) {
        if (e instanceof AbstractException) {
            return  ResultBean.ofError((AbstractException) e, exceptionParams);
        }
       return chain.doHandler(e,exceptionParams);
    }
}




