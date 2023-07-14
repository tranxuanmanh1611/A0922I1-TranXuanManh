package com.my_project.customer_manager.service.customer;

import com.my_project.customer_manager.entity.Customer;
import com.my_project.customer_manager.entity.Province;
import com.my_project.customer_manager.service.GeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends GeneralService<Customer> {
    Iterable<Customer>  findAllByProvince(Province province);
    Page<Customer> findAll(Pageable pageable) throws Exception;
    Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable);
}
