package com.my_project.library.service.book;

import com.my_project.library.entity.Book;
import com.my_project.library.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService{
    @Autowired
    BookRepo bookRepo;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepo.findById(id).get();
    }
}
