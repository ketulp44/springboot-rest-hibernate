/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernatedemo.dao;

import com.mycompany.hibernatedemo.entity.Customer;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.hibernatedemo.entity.Customer;
import org.springframework.stereotype.Repository;
@Repository
public class CustomerDAOimpl implements CustomerDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer",Customer.class);
        List<Customer> customers = theQuery.getResultList();
        return customers;
    }
    
}
