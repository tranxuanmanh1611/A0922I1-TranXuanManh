package com.my_project.library.repository;

import com.my_project.library.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookRepo extends PagingAndSortingRepository<Book,Integer> {
}
