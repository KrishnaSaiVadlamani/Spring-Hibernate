package com.aopdemo.aspect;

import com.aopdemo.Main.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger= Logger.getLogger(getClass().getName());

    @Around("execution(* com.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint proceedingJoinPoint
    )throws Throwable{

        // print out method we are advising on
        String method=proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n=====>>>> Executing @Around on method: "
                +method);

        // get begin timestamp
        long begin=System.currentTimeMillis();

        // now, let's execute the method
        Object result=null;
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            // log the exception
            logger.warning(e.getMessage());
            //give user a custom message
            result="Major accident! But no worries,"+
                   "your private AOP helicopter is on the way!";
             // rethrow exception

//            throw e;
        }
        // get end timestamp
        long end=System.currentTimeMillis();

        // compute duration and display it
        long duration=end-begin;
        logger.info("\n====>>> Duration: "+duration/1000.0+"seconds");

        return result;
    }








    @After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){

        // print out which method we are advising on
        String method=joinPoint.getSignature().toShortString();
        logger.info("\n=====>>>> Executing @After(finally) on method: "
                +method);

    }





    @AfterThrowing(
        pointcut="execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
        throwing="Exc"
    )
   public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable Exc){

        // print out which method we are advising on
       String method=joinPoint.getSignature().toShortString();
       logger.info("\n=====>>>> Executing @AfterThrowing on method: "+method);

       // log the exception
       logger.info("\n====>>> The Exception is: "+Exc);
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
        logger.info("\n=====>>>> Executing @AfterReturning on method: "+method);

        // print out results of method call
        logger.info("\n====>>> result is: "+result);

        // let's post-process the data...let's modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        logger.info("\n====>>> result is: "+result);

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

        logger.info("\n=====>>> Executing @Before advice on method");

        // display method signature

        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
        logger.info("Method: "+methodSignature);

        // display method arguments

        // get args
        Object[] args=theJoinPoint.getArgs();
        // loop thru args
        for(Object tempArgs : args){
            logger.info(tempArgs.toString());

            if(tempArgs instanceof Account){
                // downcast and print account specific stuff

                Account account=(Account) tempArgs;
                logger.info("Account Name: "+account.getName());
                logger.info("Account Level: "+account.getLevel());

            }


        }

    }



}
