package com.example.springboothibernate.demo.service;

import com.example.springboothibernate.demo.dao.CustomerDao;
import com.example.springboothibernate.demo.entity.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    @Transactional
    public Customer findbyId(int theId) {
       return customerDao.findbyId(theId);
    }

    @Override
    @Transactional
    public void save(Customer customer) {
   
      customerDao.save(customer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
    customerDao.deleteById(theId);
    }

}
