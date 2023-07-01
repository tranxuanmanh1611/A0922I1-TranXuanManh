package com.my_project.blog.service.blog_service;

import com.my_project.blog.entity.Blog;
import com.my_project.blog.entity.BlogForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Integer id);
    void save(BlogForm blog);
    void deleteById(Integer id);
    Page<Blog> findAllByTitle(Pageable pageable,String title);
    Page<Blog> findAllByCategory(Pageable pageable,Long id);
}
