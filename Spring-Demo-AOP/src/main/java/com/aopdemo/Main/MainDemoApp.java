package com.aopdemo.Main;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO=context.getBean("membershipDAO",MembershipDAO.class);

        // call the business method
        Account account=new Account();
        theAccountDAO.addAccount(account,true);
        theAccountDAO.doWork();
        // call the membership business method
        membershipDAO.addMember();
        membershipDAO.goToSleep();
        // close the context
        context.close();
    }

}
