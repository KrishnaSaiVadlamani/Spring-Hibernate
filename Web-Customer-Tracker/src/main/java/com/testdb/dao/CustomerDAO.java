package com.testdb.dao;

import com.testdb.entity.Customer;

import java.util.List;


public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
}