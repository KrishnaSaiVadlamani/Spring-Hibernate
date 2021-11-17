package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

    // point cut declaration
    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    public void forDaoPackage(){}


    // create point cut for getter methods
    @Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
    public void getter(){}

    // create a point cut for setter methods
    @Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
    public void setter(){}

    // create point: include package...exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}


}
