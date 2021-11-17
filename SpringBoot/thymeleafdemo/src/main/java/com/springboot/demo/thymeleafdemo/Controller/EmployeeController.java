package com.springboot.demo.thymeleafdemo.Controller;

import com.springboot.demo.thymeleafdemo.Model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // load employee data

    private List<Employee> employeeList;

    @PostConstruct
    private void loadData(){
        // create employees
        Employee emp1=new Employee(1,"Krishna","Sai","KrishnaSai@gmail.com");
        Employee emp2=new Employee(2,"Sahithi","Sai","Sahithi@gmail.com");
        Employee emp3=new Employee(3,"Ravi","Kalyan","Ravi.K@gmail.com");
        // create list
        employeeList=new ArrayList<>();
        // add to list
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
    }


    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel){
        // add to the spring model
        theModel.addAttribute("employees",employeeList);
        return "list-employees";
    }


}
