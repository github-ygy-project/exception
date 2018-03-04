package com.ygy.exception.model;

import com.google.common.collect.Lists;
import com.ygy.exception.enums.ExceptionSubCodeEnum;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by guoyao on 2018/3/2.
 * 批处理异常
 */
public abstract class AbstractBatchException extends AbstractException {

    private List success;

    private List fails;

    public AbstractBatchException(String msg) {
        super(msg);
    }

    public AbstractBatchException(String msg, List success, List fails) {
        super(msg);
        this.success=success;
        this.fails=fails;
    }

    public List getData() {
        List data = Lists.newArrayList();

        if (CollectionUtils.isNotEmpty(success)) {
            data.addAll(success);
        }

        if (CollectionUtils.isNotEmpty(fails)) {
            data.addAll(fails);
        }

        return data;
    }


    @Override
    protected String getSubCode(){
        return ExceptionSubCodeEnum.BATCH_EXCEPTION.getCode();
    }






}
