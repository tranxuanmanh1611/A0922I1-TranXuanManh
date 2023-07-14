package com.my_project.library.service.book;

import com.my_project.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface BookService {
    Page<Book> findAll(Pageable pageable);
    Book findById(Integer id);
}
