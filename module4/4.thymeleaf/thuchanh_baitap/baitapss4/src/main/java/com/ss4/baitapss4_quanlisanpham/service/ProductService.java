package com.ss4.baitapss4_quanlisanpham.service;

import com.ss4.baitapss4_quanlisanpham.entity.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void delete(Product product);
    Iterable<Product> findByName(String name);
}
