package com.my_project.blog.repository.blog_repository;

import com.my_project.blog.entity.Blog;
import com.my_project.blog.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Integer> {
    Page<Blog> findAllByTitleContaining(Pageable pageable, String title);
    Page<Blog> findAllByCategory(Pageable pageable, Category category);
}
