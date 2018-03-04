package com.ygy.exception.chain;


import com.ygy.exception.model.ExceptionParams;
import com.ygy.exception.model.ResultBean;

/**
 * Created by guoyao on 2018/2/25.
 * 异常处理链接口，可自己实现链路处理方式
 */
public interface HandlerChain {

    public ResultBean doHandler(Exception e, ExceptionParams exceptionParams);

}
