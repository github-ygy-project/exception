package com.ygy.exception.model;

import com.ygy.exception.enums.ModuleCodeEnum;

/**
 * Created by guoyao on 2018/3/1.
 * 异常处理传递可选参数，可扩展
 */
public class ExceptionParams {


    private Object extraParam;

    private ModuleCodeEnum moduleCodeEnum;


    public Object getExtraParam() {
        return extraParam;
    }

    public ExceptionParams setExtraParam(Object extraParam) {
        this.extraParam=extraParam;
        return this;
    }

    public ModuleCodeEnum getModuleCodeEnum() {
        return moduleCodeEnum;
    }

    public ExceptionParams setModuleCodeEnum(ModuleCodeEnum moduleCodeEnum) {
        this.moduleCodeEnum=moduleCodeEnum;
        if (moduleCodeEnum == null) {
            this.moduleCodeEnum=ModuleCodeEnum.UNKNOWN_MODULE;
        }
        return this;
    }

}
