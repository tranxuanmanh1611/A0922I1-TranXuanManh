package com.codegym.customermanagementstoredprocedure.repository.Impl;

import com.codegym.customermanagementstoredprocedure.entity.Customer;
import com.codegym.customermanagementstoredprocedure.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void addCustomer(Customer customer) {
        String sql = "CALL Insert_Customer(:firstName,:lastName)";
        Query query= entityManager.createNativeQuery(sql);
        query.setParameter("firstName",customer.getFirstName());
        query.setParameter("lastName",customer.getLastName());
        query.executeUpdate();
    }
}
