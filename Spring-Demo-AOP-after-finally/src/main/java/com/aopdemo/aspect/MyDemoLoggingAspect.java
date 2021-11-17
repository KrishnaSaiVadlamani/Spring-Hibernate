package com.aopdemo.aspect;

import com.aopdemo.Main.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        // print out which method we are advising on
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @After(finally) on method: "
                +method);

    }





    @AfterThrowing(
        pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
        throwing="Exc"
    )
   public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable Exc){

        // print out which method we are advising on
       String method=joinPoint.getSignature().toShortString();
       System.out.println("\n=====>>>> Executing @AfterThrowing on method: "+method);

       // log the exception
       System.out.println("\n====>>> The Exception is: "+Exc);
   }
    @AfterReturning(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )

    public void afterReturningFindAccountsAdvice(
            JoinPoint joinPoint, List<Account> result
    ){
        // print out which method we are advising on
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>>> Executing @AfterReturning on method: "+method);

        // print out results of method call
        System.out.println("\n====>>> result is: "+result);

        // let's post-process the data...let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n====>>> result is: "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

       // loop through accounts
        for(Account tempAccount : result) {


            // get uppercase version of name
            String theUpperName=tempAccount.getName().toUpperCase();
            // update the name on the account
            tempAccount.setName(theUpperName);
        }




    }


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
