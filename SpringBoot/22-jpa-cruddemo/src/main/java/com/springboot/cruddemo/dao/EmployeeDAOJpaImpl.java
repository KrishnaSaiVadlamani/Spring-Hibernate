package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {

        // create a query
        Query query=entityManager.createQuery("from Employee");
        // execute query and get result list
       List<Employee> employees=query.getResultList();
        // return the results

        return employees;
    }

    @Override
    public Employee findById(int theId) {

       // get employee
        Employee employee=entityManager.find(Employee.class,theId);

        // return employee


        return employee;
    }

    @Override
    public void save(Employee theEmployee) {

        // save or update the employee
        Employee employee=entityManager.merge(theEmployee);

        // update with id from db...so we can get generated id for save/insert
        theEmployee.setId(employee.getId());

    }

    @Override
    public void deleteById(int theId) {

        // delete object with primary key
        Query query=entityManager.createQuery(
                "delete from Employee where id=: employeeId"
        );

        query.setParameter("employeeId",theId);

        query.executeUpdate();

    }
}
