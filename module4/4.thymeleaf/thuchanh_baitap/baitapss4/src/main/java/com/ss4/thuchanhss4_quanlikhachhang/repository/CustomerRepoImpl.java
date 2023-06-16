package com.ss4.thuchanhss4_quanlikhachhang.repository;

import com.ss4.thuchanhss4_quanlikhachhang.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CustomerRepoImpl implements CustomerRepo{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("select c from Customer c").getResultList();
    }

    @Override
    public void add(Customer customer) {
        entityManager.persist(customer);
    }
}
