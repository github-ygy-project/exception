package com.ygy.exception.handler.container;


import com.ygy.exception.handler.ExceptionHandler;

import java.util.ArrayList;

/**
 * Created by guoyao on 2018/2/25.
 * 异常处理器容器，用于存储异常处理器
 */
public final class ExceptionHandlerContainer {

    /**
     * handler存储
     */
    private final ArrayList<ExceptionHandler> handlers=new ArrayList();

    private ExceptionHandlerContainer() {

    }

    /**
     * 单例初始化
     */
    private static class Singleton {
        private static ExceptionHandlerContainer exceptionHandlerContainer;

        static {
            exceptionHandlerContainer=new ExceptionHandlerContainer();
        }

        public static ExceptionHandlerContainer getInstance() {
            return exceptionHandlerContainer;
        }
    }

    public static ExceptionHandlerContainer getInstance() {
        return Singleton.getInstance();
    }

    public ArrayList<ExceptionHandler> getHandlers() {
        return handlers;
    }

    public ArrayList<ExceptionHandler> addHandler(int index, ExceptionHandler exceptionHandler) {
        this.handlers.add(index, exceptionHandler);
        return handlers;
    }

    public int getSize() {
        return handlers.size();
    }


}
