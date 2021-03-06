package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // autowire the CustomerService
    @Autowired
    private CustomerService customerService;

    // add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();

    }
    // add mapping for Get/customers/{customerId}

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){

        Customer theCustomer= customerService.getCustomer(customerId);

        if(theCustomer==null){
            throw new CustomerNotFoundException("Customer Not Found : "+customerId);
        }

        return theCustomer;
    }

    // add mapping for POST /customers - add new customer

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){

        // also just in case they pass an id in JSON.. set id to 0
        // this is force a save of new item..instead of update
        theCustomer.setId(0);
        customerService.saveCustomer(theCustomer);
        return theCustomer;

    }

    // add mapping for PUT /customers -update existing customer

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){

        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    // add mapping for DELETE /customers/{customerId} - delete customer

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer=customerService.getCustomer(customerId);

        // throw exception if null

        if(customer==null){
            throw new CustomerNotFoundException("Customer Not Found : "+customerId);
        }

        customerService.deleteCustomer(customerId);

        return "Deleted customer id : "+customerId;
    }


}
