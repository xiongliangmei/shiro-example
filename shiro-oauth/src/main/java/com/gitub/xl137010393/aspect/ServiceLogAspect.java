package com.gitub.xl137010393.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Slf4j
@Aspect
@Component
public class ServiceLogAspect {

    /**
     * 方法执行前打印参数（仅log.debug=true时记录）
     * @param joinPoint
     */
    @Before("execution(* com.gitub.xl137010393.service.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
       // 如果日志未开启debug模式则跳过
        if(!log.isDebugEnabled()) {
            return;
        }
        Object[] args = joinPoint.getArgs();
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();

        log.debug("调用{}.{}参数:", className, methodName);
        if(args.length > 0) {
            for(int i = 0; i < args.length; i++) {
                log.debug("第{}个参数: {}", i, args[i]);
            }
        }
    }

    /****
     * 记录方法执行的时间(仅log.debug= true 时记录)
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.gitub.xl137010393.service.*.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        //如果日志未开启debug 模式则跳过
        if (!log.isDebugEnabled()){
            return joinPoint.proceed();
        }
        long time = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        time = System.currentTimeMillis() -time;

        String className = joinPoint.getTarget().getClass().getName(); //获取类名
        String methodName = joinPoint.getSignature().getName(); //获取方法名

        log.debug("调用了{}.{}()耗时{}ms",className,methodName,time);
        return result;

    }
}
