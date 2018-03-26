package com.ygy.exception.chain;


import com.ygy.exception.enums.ExceptionSubCodeEnum;
import com.ygy.exception.handler.ExceptionHandler;
import com.ygy.exception.handler.container.ExceptionHandlerContainer;
import com.ygy.exception.handler.listener.ExceptionHandlerListener;
import com.ygy.exception.model.ExceptionParams;
import com.ygy.exception.model.ResultBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by guoyao on 2018/2/25.
 * 异常处理链路
 */
@Component
@Scope("prototype")
public class ExceptionHandlerChain implements HandlerChain {

    private int cursor=0;

    @Resource
    ExceptionHandlerListener exceptionHandlerListener;


    public ResultBean doHandler(Exception e, ExceptionParams exceptionParams) {


        ArrayList<ExceptionHandler> handlers=ExceptionHandlerContainer.getInstance().getHandlers();

        if (CollectionUtils.isEmpty(handlers)) {
            return ResultBean.ofError(exceptionParams);
        }

        if (cursor >= handlers.size()) {
            return ResultBean.ofError(exceptionParams, ExceptionSubCodeEnum.UNKNOWN_EXCEPTION.getMsg());
        }


        ResultBean resultBean=handlers.get(cursor++).handlerException(e, exceptionParams, this);

        if (resultBean == null) {
            resultBean = ResultBean.ofError(exceptionParams);
        }

        return resultBean;
    }
}
