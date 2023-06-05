package com.example.baitap_ss3.mail_box.repo;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    boolean save(T t);
    T findById(int id);
}
