package com.example.springboothibernate.demo.dao;

import com.example.springboothibernate.demo.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
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
        currentSession.clear();
        return theCustomers;
    }

    @Override
    public Customer findbyId(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Customer customer = currentSession.get(Customer.class, theId);
          currentSession.clear();
        return customer;
    }

    @Override
    public void save(Customer customer) {
        System.out.println("inside save");
        System.out.println(customer);
        Session currentSession = entityManager.unwrap(Session.class);
        System.out.println("after session");
       currentSession.saveOrUpdate(customer);
       currentSession.flush();
        System.out.println("after save and update");
          currentSession.clear();
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        theQuery.setParameter("customerId", theId);
        theQuery.executeUpdate();
        currentSession.clear();
    }
}
