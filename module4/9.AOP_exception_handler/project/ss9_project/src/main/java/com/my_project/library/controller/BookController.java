package com.my_project.library.controller;

import com.my_project.library.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("my_library/book_list")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public String showList(@PageableDefault(value = 3) Pageable pageable, Model model) {
        model.addAttribute("books", bookService.findAll(pageable));
        return "library/book/list";
    }
    @GetMapping("/{id}")
    public String showDetail(@PathVariable("id") Integer id,Model model){
        model.addAttribute("book",bookService.findById(id));
        return "library/book/detail";
    }
//    @GetMapping("/borrow/{id}")
//    public String showBorrowForm(@PathVariable("id") Integer id) {
//
//    }
}
