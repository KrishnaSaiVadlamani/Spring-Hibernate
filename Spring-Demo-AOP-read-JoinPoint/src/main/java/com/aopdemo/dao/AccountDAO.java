package com.aopdemo.dao;


import com.aopdemo.Main.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

  private String name;
  private String serviceCode;

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
