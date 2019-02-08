/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.springboothibernate.demo.dao;

import com.example.springboothibernate.demo.entity.Customer;
import java.util.List;

/**
 *
 * @author ketul
 */
public interface CustomerDao {

    public List<Customer> findAll();
    public Customer findbyId(int theId);
    public void save(Customer customer);
    public void deleteById(int theId);
}
