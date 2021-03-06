/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboothibernate.demo.rest;

import com.example.springboothibernate.demo.dao.CustomerDao;
import com.example.springboothibernate.demo.entity.Customer;
import com.example.springboothibernate.demo.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
        
    }
    @GetMapping("/customer")
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.findbyId(customerId);
        if(customer== null){
            throw new RuntimeException("customer id not found - "+customerId);
        }
        return customer;
    }
    @PostMapping(value="/customer/add",consumes = "application/json")
    public Customer addCustomer(@RequestBody Customer theCustomer){
        System.out.println(theCustomer);
        theCustomer.setId(0);
        customerService.save(theCustomer);
        return theCustomer;
    }
    @PutMapping("/customer/update")
    public Customer updateCustomer(@RequestBody Customer theCustomer){
      
        customerService.save(theCustomer);
       
       return theCustomer;
    }
}
