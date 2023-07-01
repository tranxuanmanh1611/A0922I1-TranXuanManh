package com.my_project.customer_manager.service;

import com.my_project.customer_manager.entity.Customer;
import com.my_project.customer_manager.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface GeneralService<T> {
    Iterable<T> findAll();
    T findById(Long id);
    void save(T t);
    void remove(T t);

}
