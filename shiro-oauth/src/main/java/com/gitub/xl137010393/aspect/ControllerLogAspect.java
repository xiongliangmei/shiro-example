package com.gitub.xl137010393.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/***
 * controller  日志切面
 */
@Slf4j
@Aspect
@Component
public class ControllerLogAspect {

    /**
     * 方法执行前打印参数（仅log.debug=true时记录）
     * @param joinPoint
     */
    @Before("execution(* com.gitub.xl137010393.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        if (log.isDebugEnabled()){
            return;
        }
        Object[] arg = joinPoint.getArgs(); //获取参数
        String className = joinPoint.getTarget().getClass().getName(); //获取类名
        String methoName = joinPoint.getSignature().getName();  //方法名
        log.debug("调用了{}.{}()方法",className,methoName);

        if (arg.length > 0 ){
            for (int i = 0; i <arg.length ; i++) {
                log.debug("第{}个参数:{}",i,arg[i]);
            }
        }
    }
}
