package com.aopdemo.dao;


import com.aopdemo.Main.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

  public void addAccount(Account theAccount,boolean flag){

      System.out.println(getClass()+": Doing My DB Work: Adding an Account");
      
  }

  public boolean doWork(){

      System.out.println(getClass()+": Hey I'm Writing Code");
      return false;
  }

}
