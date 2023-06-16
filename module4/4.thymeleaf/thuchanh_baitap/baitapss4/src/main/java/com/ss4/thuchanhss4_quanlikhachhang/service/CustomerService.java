package com.ss4.thuchanhss4_quanlikhachhang.service;

import com.ss4.thuchanhss4_quanlikhachhang.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss4.thuchanhss4_quanlikhachhang.entity.Customer;
import com.ss4.thuchanhss4_quanlikhachhang.repository.CustomerRepoImpl;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> findAll(){
     return customerRepo.findAll();
    }
    public void add(Customer customer){
        customerRepo.add(customer);
    }
}
