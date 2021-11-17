package com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addMember(){

        System.out.println(getClass()+": Adding a Membership Account");

    }

    public void goToSleep(){

        System.out.println(getClass()+": I'm Going to Sleep...");
    }

}
