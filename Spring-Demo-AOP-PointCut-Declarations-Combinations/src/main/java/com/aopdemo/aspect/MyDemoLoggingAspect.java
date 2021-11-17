package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

     // this is where we add all our related advices for logging
     // let's start with an @Before advice

    // point cut declaration
    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}


    // create point cut for getter methods
    @Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
    private void getter(){}

    // create a point cut for setter methods
    @Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
    private void setter(){}

    // create point: include package...exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter(){}


    @Before("forDaoPackageNoGetterSetter()")
    // point cut expression
    public void beforeAddAccountAdvice(){

        System.out.println("\n=====>>> Executing @Before advice on method");

    }

    @Before("forDaoPackageNoGetterSetter()")
    public void perfromApiAnalytics(){

        System.out.println("\n====>>> Performing API Analytics");
    }


}
