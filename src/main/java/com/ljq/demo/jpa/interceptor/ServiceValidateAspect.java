package com.ljq.demo.jpa.interceptor;

import com.ljq.demo.jpa.common.annotation.ParamsCheck;
import com.ljq.demo.jpa.common.exception.ParamsCheckException;
import com.ljq.demo.jpa.common.utils.BeanValidateUtil;
import com.ljq.demo.jpa.model.param.BaseParam;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: 业务层参数校验切点
 * @Author: junqiang.lu
 * @Date: 2019/3/26
 */
@Aspect
@Component
public class ServiceValidateAspect {

    /**
     * service 层切点
     */
    @Pointcut("execution(* com.ljq.demo.jpa.service..*.*(..))")
    public void servicePointcut() {
    }

    /**
     * service 层入参校验
     *
     * @param joinPoint 切点
     * @return
     * @throws Throwable
     */
    @Around(value = "servicePointcut()")
    public Object serviceParamCheckAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 判断是否需要校验
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        ParamsCheck paramsCheckAnnotation = method.getAnnotation(ParamsCheck.class);
        if (paramsCheckAnnotation != null && paramsCheckAnnotation.ignore()) {
            return joinPoint.proceed();
        }
        /**
         * 参数校验
         */
        Object[] objects = joinPoint.getArgs();
        for (Object arg : objects) {
            if (arg == null) {
                break;
            }
            /**
             * 判断是否为 BaseParam.class 的子类
             */
            boolean isChildClass =  BaseParam.class.isAssignableFrom(arg.getClass());
            if (isChildClass) {
                // 参数校验
                String validResult = BeanValidateUtil.validate(arg);
                if (validResult != null && validResult.length() > 0) {
                    throw new ParamsCheckException(validResult);
                }
            }
        }

        return joinPoint.proceed();
    }
}
