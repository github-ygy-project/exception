package com.ygy.exception.model;


import com.ygy.exception.enums.ExceptionCodeEnum;
import com.ygy.exception.enums.ModuleCodeEnum;
import com.ygy.exception.helper.ExceptionCodeHelper;

/**
 * Created by guoyao on 2018/2/23.
 * 自定义基础异常
 */
public abstract class AbstractException extends RuntimeException {


    public AbstractException(String msg) {
        super(msg);
        this.msg=msg;
    }

    public String getExceptionCode() {
        //异常code码
        ExceptionCodeEnum exceptionCodeEnum=getCodeEnum();

        //模块code码
        ModuleCodeEnum moduleEnum=getModuleCodeEnum();

        //错误子码
        String subCode=getSubCode();

        return ExceptionCodeHelper.getExceptionCode(exceptionCodeEnum,moduleEnum,subCode);
    }

    //模块码
    protected abstract ModuleCodeEnum getModuleCodeEnum();

    //异常类型
    protected abstract ExceptionCodeEnum getCodeEnum();

    //子错误码
    protected abstract String getSubCode();

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code=code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg=msg;
    }
}
