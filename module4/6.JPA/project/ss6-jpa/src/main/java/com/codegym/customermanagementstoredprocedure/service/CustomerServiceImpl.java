package com.codegym.customermanagementstoredprocedure.service;

import com.codegym.customermanagementstoredprocedure.entity.Customer;
import com.codegym.customermanagementstoredprocedure.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }
}
