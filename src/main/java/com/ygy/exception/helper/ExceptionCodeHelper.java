package com.ygy.exception.helper;

import com.ygy.exception.enums.ExceptionCodeEnum;
import com.ygy.exception.enums.ExceptionSubCodeEnum;
import com.ygy.exception.enums.ModuleCodeEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by guoyao on 2018/2/28.
 * 异常组合工具类
 */
public class ExceptionCodeHelper {


    /**
     * 获取默认异常码
     * @return
     */
    public static String getExceptionCode() {

        return getUnknownCode(ModuleCodeEnum.UNKNOWN_MODULE);
    }

    /**
     * 根据enum获取未知异常码
     * @return
     */
    public static String getUnknownCode(ModuleCodeEnum moduleCodeEnum) {
        return getExceptionCode(ExceptionCodeEnum.UNKNOWN_CDOE, moduleCodeEnum, ExceptionSubCodeEnum.ERP_UNKNOWN_EXCEPTION.getCode());
    }

    /**
     * 根据enum获取基础异常码
     *
     * @return
     */
    public static String getNormalCode(ModuleCodeEnum moduleCodeEnum, ExceptionSubCodeEnum exceptionSubCodeEnum) {

        return getExceptionCode(ExceptionCodeEnum.NORMAL_CDOE, moduleCodeEnum, exceptionSubCodeEnum.getCode());
    }

    /**
     * 根据enum获取业务异常码
     *
     * @return
     */
    public static String getBizCode(ModuleCodeEnum moduleCodeEnum, String subCode) {

        return getExceptionCode(ExceptionCodeEnum.BIZ_CDOE, moduleCodeEnum, subCode);
    }

    /**
     * 根据enum获取异常码
     * @param exceptionCodeEnum
     * @param moduleCodeEnum
     * @param subCode
     * @return
     */
    public static String getExceptionCode(ExceptionCodeEnum exceptionCodeEnum, ModuleCodeEnum moduleCodeEnum, String subCode) {
        if (exceptionCodeEnum == null) {
            exceptionCodeEnum=ExceptionCodeEnum.UNKNOWN_CDOE;
        }

        if (moduleCodeEnum == null) {
            moduleCodeEnum=ModuleCodeEnum.UNKNOWN_MODULE;
        }

        if (StringUtils.isEmpty(subCode)) {
            subCode=ExceptionSubCodeEnum.ERP_UNKNOWN_EXCEPTION.getCode();
        }
        return new StringBuilder().append(exceptionCodeEnum.getCode()).append(moduleCodeEnum.getCode()).append(subCode).toString();

    }
}
