package com.codegym.blog.repository;

import com.codegym.blog.entity.Blog;

import java.util.List;

public interface BlogRepository {
    List<Blog> findAll();
    Blog findById(int id);
    void save(Blog blog);
    void update(Blog blog);
    void delete(int id);

}
