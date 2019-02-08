package com.example.springboothibernate.demo.dao;

import com.example.springboothibernate.demo.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private EntityManager entityManager;

    @Autowired
    public CustomerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
        List<Customer> theCustomers = theQuery.getResultList();
        return theCustomers;
    }

    @Override
    public Customer findbyId(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer customer = currentSession.get(Customer.class, theId);
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();
    }
}
