package com.ss4.baitapss4_quanlisanpham.service;

import com.ss4.baitapss4_quanlisanpham.Repository.CategoryRepository;
import com.ss4.baitapss4_quanlisanpham.entity.Category;
import com.ss4.baitapss4_quanlisanpham.entity.Product;

import java.util.Optional;

public interface CategoryService {
    Iterable<Category> findAll();
    Optional<Category> findById(int id);
}
