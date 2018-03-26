package com.ygy.exception.handler.listener;

import com.ygy.exception.annotation.YgyExceptionHandler;
import com.ygy.exception.handler.ExceptionHandler;
import com.ygy.exception.handler.container.ExceptionHandlerContainer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

/**
 * Created by guoyao on 2018/2/25.
 * 异常处理器监听器
 */
@Component
public class ExceptionHandlerListener implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ExceptionHandlerContainer container=ExceptionHandlerContainer.getInstance();
        try {
            ArrayList<Long> orderList=new ArrayList<Long>();
            // 获取上下文
            ApplicationContext context=event.getApplicationContext();
            // 获取所有beanNames
            String[] beanNames=context.getBeanNamesForType(Object.class);
            for (String beanName : beanNames) {

                YgyExceptionHandler ygyExceptionHandler=context.findAnnotationOnBean(beanName,
                        YgyExceptionHandler.class);
                //判断该类是否含有ErpExceptionHanler注解
                if (ygyExceptionHandler == null) {
                    continue;
                }

                int index=getIndex(ygyExceptionHandler.order(), orderList);
                if (index == -1) {
                    continue;
                }

                ExceptionHandler handler=(ExceptionHandler) context.getBean(beanName);
                //最多只能有30个执行链路
                if (container.getSize() > 30){
                    break;
                }
                container.addHandler(index, handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public  int getIndex(String order, ArrayList<Long> orderList) {
        Long orderNum = null ;
        try {
            orderNum =  Long.valueOf(order.trim());
        } catch (Exception e) {
            return -1;
        }

        int index=binarySearchNum(orderNum, orderList);
        orderList.add(index, orderNum);
        return index;
    }

    public int binarySearchNum(Long orderNum, ArrayList<Long> orderList) {
        if (CollectionUtils.isEmpty(orderList)) {
            return 0;
        }
        int max, min, mid;
        min=0;
        max=orderList.size() - 1;
        while (min <= max) {
            mid=(min + max) / 2;
            if (orderNum > orderList.get(mid)) {
                min=mid + 1;
            } else if (orderNum < orderList.get(mid)) {
                max=mid - 1;
            } else {
                return mid;
            }
        }
        return min;
    }

}
