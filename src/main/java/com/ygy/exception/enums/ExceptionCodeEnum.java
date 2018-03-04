package com.ygy.exception.enums;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Created by guoyao on 2018/2/28.
 * 系统异常码分类
 */
public enum ExceptionCodeEnum {

    UNKNOWN_CDOE("00","未知异常码","无法预见的异常或可预见但未被处理的异常"),
    BIZ_CDOE("10","业务异常码","由于业务操作不当导致执行失败，或者其他原因导致业务失败的"),
    NORMAL_CDOE("20","系统异常码","Assert或Preconditions参数传递校验异常、空指针异常、索引越界等服务端异常"),
    CHECK_CDOE("30","检查异常码","前后端约定参数校验异常,只用于在controller层校验抛出");

    public static final HashMap<String, ExceptionCodeEnum> initMap =Maps.newHashMap();

    public static ExceptionCodeEnum getEnumByValue(String code){
        if(initMap == null || initMap.isEmpty()){
            for (ExceptionCodeEnum exceptionCodeEnum : ExceptionCodeEnum.values()) {
                initMap.put(exceptionCodeEnum.getCode(), exceptionCodeEnum);
            }
        }
        return  initMap.get(code);
    }


    private ExceptionCodeEnum(String code, String msg, String detailMsg) {
        this.code  = code;
        this.msg = msg;
        this.detailMsg=detailMsg;
    }

    private String code ;

    private String msg ;

    private String detailMsg;

    public String getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

}
