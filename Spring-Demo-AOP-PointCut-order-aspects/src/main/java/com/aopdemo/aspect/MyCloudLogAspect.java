package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {


    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void LogToCloud(){

        System.out.println("\n====>>> Logging to Cloud");

    }

}
