package com.my_project.blog.repository.category_repository;

import com.my_project.blog.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
