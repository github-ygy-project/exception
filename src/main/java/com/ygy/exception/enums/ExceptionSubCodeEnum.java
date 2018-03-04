package com.ygy.exception.enums;

/**
 * Created by guoyao on 2018/2/24.
 * 基础异常子码
 */
public enum ExceptionSubCodeEnum {

    ERP_UNKNOWN_EXCEPTION("1000", "系统异常","unKnownException"),
    NULL_POINT_EXCEPTION("0001", "空指针异常","nullPointerException"),
    ILLEGAL_ARGUMENT_EXCEPTION("0002", "参数异常","illegalArgumentException"),
    BATCH_EXCEPTION("0003", "批处理时抛出异常","abstractBatchException");



    private ExceptionSubCodeEnum(String code, String msg, String name) {
        this.code=code;
        this.msg=msg;
        this.name=name;
    }

    private String code ;

    private String msg;

    private String name;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
