package com.aopdemo.aspect;

import com.aopdemo.Main.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

     // this is where we add all our related advices for logging
     // let's start with an @Before advice



    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    // point cut expression
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){

        System.out.println("\n=====>>> Executing @Before advice on method");

        // display method signature

        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

        // display method arguments

        // get args
        Object[] args=theJoinPoint.getArgs();
        // loop thru args
        for(Object tempArgs : args){
            System.out.println(tempArgs);

            if(tempArgs instanceof Account){
                // downcast and print account specific stuff

                Account account=(Account) tempArgs;
                System.out.println("Account Name: "+account.getName());
                System.out.println("Account Level: "+account.getLevel());

            }


        }

    }



}
