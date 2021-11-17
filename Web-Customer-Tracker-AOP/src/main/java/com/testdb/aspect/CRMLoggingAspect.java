package com.testdb.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {

    private Logger logger = LoggerFactory.getLogger(CRMLoggingAspect.class);
//    private Logger logger = LoggerFactory.getLogger(CRMLoggingAspect.class);

    //pointcut declarations
    @Pointcut("execution(* com.springdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.springdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("execution(* com.springdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppflow(){}


    //    @Before Advice
    @Before("forAppflow()")
    public void before(JoinPoint joinPoint){
        String methodSignature = joinPoint.getSignature().toShortString();
        logger.info("=====>> in @Before : calling method: "+methodSignature);

        Object args[] = joinPoint.getArgs();
        for (Object arg : args){
            logger.info("Arguments===>> " +arg);
        }
    }


    //    @AfterReturing Advice
    @AfterReturning(pointcut = "forAppflow()",returning = "result")
    private void afterReturning(JoinPoint joinPoint,Object result){
        String methodSignature = joinPoint.getSignature().toShortString();
        logger.info("====>> in @AfterReturning : from method "+methodSignature);

        logger.info("====>> result : "+result);
    }
}