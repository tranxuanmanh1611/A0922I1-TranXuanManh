package com.my_project.blog.service.category_service;

import com.my_project.blog.entity.Category;

public interface CategoryService {
    Iterable<Category> findAll();
    void save(Category category);
    Category findById(Long id);
    void deleteById(Long id);
}
