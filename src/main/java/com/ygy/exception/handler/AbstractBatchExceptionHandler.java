package com.ygy.exception.handler;

import com.ygy.exception.model.AbstractBatchException;
import com.ygy.exception.model.ExceptionParams;
import com.ygy.exception.model.ResultBean;
import com.ygy.exception.annotation.YgyExceptionHandler;
import com.ygy.exception.chain.ExceptionHandlerChain;
import org.springframework.stereotype.Component;

/**
 * Created by guoyao on 2018/3/2.
 * 批处理异常handler处理器
 */
@Component
@YgyExceptionHandler(order="99")
public class AbstractBatchExceptionHandler implements ExceptionHandler {

    @Override
    public ResultBean handlerException(Exception e, ExceptionParams params, ExceptionHandlerChain chain) {

        if (e instanceof AbstractBatchException) {
            AbstractBatchException batchException =(AbstractBatchException) e;
            return ResultBean.ofError(batchException, params).setData((batchException.getData()));
        }
        return chain.doHandler(e, params);
    }
}
