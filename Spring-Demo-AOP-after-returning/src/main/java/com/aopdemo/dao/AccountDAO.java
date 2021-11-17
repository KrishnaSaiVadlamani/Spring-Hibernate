package com.aopdemo.dao;


import com.aopdemo.Main.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

  private String name;
  private String serviceCode;

  // add a new method: findAccounts()

    public List<Account> findAccounts(){

        List<Account> accounts=new ArrayList<>();

        // create sample accounts
        Account temp1=new Account("Rakesh","Silver");
        Account temp2=new Account("Sahithi","Platinum");
        Account temp3=new Account("Ravi","Gold");

        // add them to our accounts list

        accounts.add(temp1);
        accounts.add(temp2);
        accounts.add(temp3);

        return accounts;
    }

  public void addAccount(Account theAccount,boolean flag){

      System.out.println(getClass()+": Doing My DB Work: Adding an Account");
      
  }

  public boolean doWork(){

      System.out.println(getClass()+": doWork()");
      return false;
  }

    public String getName() {
        System.out.println(getClass()+": In GetName()");
        return this.name;
    }

    public void setName(final String name) {
        System.out.println(getClass()+": In SetName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+": In GetserviceCode()");
        return this.serviceCode;
    }

    public void setServiceCode(final String serviceCode) {
        System.out.println(getClass()+": In SetserviceCode()");
        this.serviceCode = serviceCode;
    }

}
