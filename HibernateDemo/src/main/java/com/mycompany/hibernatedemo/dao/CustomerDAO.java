/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatedemo.dao;

import com.mycompany.hibernatedemo.entity.Customer;
import java.util.List;


public interface CustomerDAO {
    public List<Customer> getCustomers();
}
