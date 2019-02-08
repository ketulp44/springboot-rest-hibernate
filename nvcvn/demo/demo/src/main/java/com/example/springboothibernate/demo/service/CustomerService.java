/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboothibernate.demo.service;

import com.example.springboothibernate.demo.entity.Customer;
import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findbyId(int theId);

    public void save(Customer customer);

    public void deleteById(int theId);
}
