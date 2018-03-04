package com.ygy.exception.handler;


import com.ygy.exception.model.ExceptionParams;
import com.ygy.exception.model.ResultBean;
import com.ygy.exception.chain.ExceptionHandlerChain;

/**
 * Created by guoyao on 2018/2/23.
 * 异常处理器，对特定异常处理方式。
 */
public interface ExceptionHandler {

    public ResultBean handlerException(Exception e, ExceptionParams params, ExceptionHandlerChain chain);

}
