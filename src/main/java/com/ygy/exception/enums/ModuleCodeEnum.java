package com.ygy.exception.enums;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Created by guoyao on 2018/2/24.
 * 模块异常码
 */
public enum ModuleCodeEnum {

    UNKNOWN_MODULE("00","unknown_module", "未知模块");



    private ModuleCodeEnum(String code, String module, String msg ) {
        this.code=code;
        this.module=module;
        this.msg=msg;
    }

    public static final HashMap<String, ModuleCodeEnum> initMap =Maps.newHashMap();

    public static ModuleCodeEnum getEnumByValue(String module){
        if(initMap == null || initMap.isEmpty()){
            for (ModuleCodeEnum moduleCodeEnum : ModuleCodeEnum.values()) {
                initMap.put(moduleCodeEnum.getModule(), moduleCodeEnum);
            }
        }
        return  initMap.get(module);
    }

    private String module ;

    private String code;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public String getModule() {
        return module;
    }

}
