package com.springboot.demo.thymeleafdemo.dao;

import com.springboot.demo.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // no code needed

    // add a method to sort by lastname
    public List<Employee> findAllByOrderByLastNameAsc();

}

