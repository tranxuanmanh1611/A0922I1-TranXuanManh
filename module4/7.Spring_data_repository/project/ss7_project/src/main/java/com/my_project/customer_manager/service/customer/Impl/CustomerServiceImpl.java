package com.my_project.customer_manager.service.customer.Impl;

import com.my_project.customer_manager.entity.Customer;
import com.my_project.customer_manager.entity.Province;
import com.my_project.customer_manager.repository.CustomerRepository;
import com.my_project.customer_manager.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Customer findById(Long id) {
        Customer customerToFind = null  ;
        Optional<Customer> customerToFindOptional =customerRepository.findById(id);
        if (customerToFindOptional.isPresent()){
            customerToFind = customerToFindOptional.get();
            return customerToFind;
        }
        return null;
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable) {
        return customerRepository.findAllByFirstNameContaining(name,pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Customer customer) {
        customerRepository.delete(customer);
    }
}
