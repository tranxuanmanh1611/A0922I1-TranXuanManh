package com.codegym.blog.service;

import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.BlogForm;

import java.util.List;

public interface BlogService {
    void save (BlogForm blogForm);
    List<Blog> findAll();
    Blog findById(int id);
    void delete(Integer id);
}
