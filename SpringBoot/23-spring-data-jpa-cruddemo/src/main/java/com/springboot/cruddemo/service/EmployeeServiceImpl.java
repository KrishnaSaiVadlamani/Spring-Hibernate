package com.springboot.cruddemo.service;

import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result=employeeRepository.findById(theId);
        Employee employee=null;
        if(result.isPresent()){
            employee= result.get();
        }else{
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id: "+theId);
        }
        return employee;
    }

    @Override
    public void save(Employee theEmployee) {
            employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
         employeeRepository.deleteById(theId);
    }
}
