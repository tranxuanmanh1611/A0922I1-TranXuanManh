package com.my_project.customer_manager.service;

import com.my_project.customer_manager.exception.DuplicateEmailException;

public interface GeneralService<T> {
    Iterable<T> findAll() throws Exception;
    T findById(Long id) throws Exception;
    void save(T t) throws DuplicateEmailException;
    void remove(T t);

}
