package com.ygy.exception.model;


import com.ygy.exception.enums.ExceptionSubCodeEnum;
import com.ygy.exception.helper.ExceptionCodeHelper;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * Created by guoyao on 2018/2/24.
 * 统一返回数据格式类
 */
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = -2361820086956983473L;

    private Boolean suc;

    private String code;

    private T data;

    private String message;

    public static <T> ResultBean<T> ofSuccess(T data) {
        //success code码与msg可自行定义
        return of(data, true, "200", "执行成功");
    }

    public static ResultBean ofError(AbstractException e, ExceptionParams exceptionParams) {
        if (e == null) {
            return ofError(exceptionParams);
        }
        return ofError(exceptionParams,e.getExceptionCode(),e.getMsg());
    }

    public static ResultBean ofNormalError(Exception e, ExceptionParams exceptionParams, ExceptionSubCodeEnum exceptionSubCodeEnum) {
        if (e == null) {
            return ofError(exceptionParams);
        }
        return ofError(exceptionParams, ExceptionCodeHelper.getNormalCode(exceptionParams.getModuleCodeEnum(), exceptionSubCodeEnum), e.getMessage());
    }


    public static ResultBean ofError(ExceptionParams exceptionParams, String code, String msg) {
        if (exceptionParams == null) {
           return ofError();
        }
        return ofError(code,msg);
    }

    public static ResultBean ofError(ExceptionParams exceptionParams) {

        return ofError(exceptionParams, ExceptionSubCodeEnum.ERP_UNKNOWN_EXCEPTION.getMsg());
    }

    public static ResultBean ofError(ExceptionParams exceptionParams, String msg) {
        if (exceptionParams == null) {
           return ofError();
        }
        return of(null,false, ExceptionCodeHelper.getUnknownCode(exceptionParams.getModuleCodeEnum()),msg);
    }

    public static ResultBean ofError( String code, String msg) {

        return of( null, false, code, msg);
    }


    public static ResultBean ofError() {
        return of(null,false, ExceptionCodeHelper.getExceptionCode(), ExceptionSubCodeEnum.ERP_UNKNOWN_EXCEPTION.getMsg());
    }

    public static <T> ResultBean of( T data, boolean success, String code, String msg) {
        if (StringUtils.isEmpty(msg)) {
            msg=ExceptionSubCodeEnum.ERP_UNKNOWN_EXCEPTION.getMsg();
        }
        if (StringUtils.isEmpty(code)) {
            code=ExceptionCodeHelper.getExceptionCode();
        }
        ResultBean resultBean = new ResultBean();
        resultBean.setData(data);
        resultBean.setSuc(success);
        resultBean.setCode(code);
        resultBean.setMessage(msg);
        return resultBean;
    }



    public String getMessage() {
        return message;
    }

    public ResultBean<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultBean<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Boolean getSuc() {
        return suc;
    }

    public ResultBean<T> setSuc(Boolean suc) {
        this.suc=suc;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ResultBean<T> setCode(String code) {
        this.code=code;
        return this;
    }

}

