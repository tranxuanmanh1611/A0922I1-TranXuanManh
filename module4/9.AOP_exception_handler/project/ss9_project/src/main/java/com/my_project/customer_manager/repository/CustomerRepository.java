package com.my_project.customer_manager.repository;

import com.my_project.customer_manager.entity.Customer;
import com.my_project.customer_manager.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
@Transactional
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer>  findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String name, Pageable pageable);
}
