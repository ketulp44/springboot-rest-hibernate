
package com.mycompany.hibernatedemo.controller;

import com.mycompany.hibernatedemo.dao.CustomerDAO;
import com.mycompany.hibernatedemo.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO; 
    @RequestMapping("/list")
    public String listCustomer(Model theModel){
        List <Customer>  theCustomers = customerDAO.getCustomers();
        theModel.addAttribute("customers",theCustomers);
        return "list-customers";
    }
    
}
