package com.ygy.exception.aspect;

import com.ygy.exception.chain.ExceptionHandlerChain;
import com.ygy.exception.enums.ModuleCodeEnum;
import com.ygy.exception.model.ExceptionParams;
import com.ygy.exception.model.ResultBean;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 *aspect 全局结果切面
 */
@Component
@Aspect
public class ResultAspect  implements BeanFactoryAware {


    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory=beanFactory;
    }


    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void aspect() {
    }


    @Around("aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        
        try {
            result = joinPoint.proceed(joinPoint.getArgs());
            if (result instanceof String)
                return result;
            
            if (result instanceof ResultBean){
        		return result;
            }
            return ResultBean.ofSuccess(result);
        } catch (Exception e) {
            ExceptionParams exceptionParams=new ExceptionParams();
            exceptionParams.setModuleCodeEnum(ModuleCodeEnum.UNKNOWN_MODULE);
            ExceptionHandlerChain chain=beanFactory.getBean(ExceptionHandlerChain.class);
            ResultBean resultBean=chain.doHandler(e, exceptionParams);
            if (resultBean == null) {
                resultBean =  ResultBean.ofError(exceptionParams);
            }
            return resultBean;
        }
    }

}
