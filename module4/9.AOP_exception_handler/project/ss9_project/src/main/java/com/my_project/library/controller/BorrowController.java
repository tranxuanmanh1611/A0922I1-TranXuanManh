package com.my_project.library.controller;

import com.my_project.library.entity.BorrowCard;
import com.my_project.library.exception_handler.QuantityException;
import com.my_project.library.service.book.BookService;
import com.my_project.library.service.borrow_card.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("my_library/borrow")
public class BorrowController {
    @Autowired
    BorrowCardService borrowCardService;
    @Autowired
    BookService bookService;

    @GetMapping
    public String showBorrowList(Model model) {
        model.addAttribute("borrows", borrowCardService.findAll());
        return "library/borrow_card/list";
    }

    @GetMapping("{id}")
    public String showBorrowForm(@PathVariable("id") Integer id, Model model) {
        BorrowCard newCard = new BorrowCard();
        newCard.setBook(bookService.findById(id));
        model.addAttribute("form", newCard);
        return "library/borrow_card/new";
    }

    @GetMapping("/return")
    public String showAuthentication(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("borrowCardId",id);
        return "library/borrow_card/return";
    }

    @PostMapping("/return/{id}")
    public String returnBook(@PathVariable("id") Integer id, @RequestParam("borrowCode") String borrowCode,Model model) {
        BorrowCard borrowCardToReturn = borrowCardService.findById(id)   ;
        boolean match = borrowCardService.checkBorrowCode(id,borrowCode);
        if (match) {
            borrowCardService.returnBook(borrowCardToReturn);
        } else {
            model.addAttribute("borrowCardId",id);
            return "library/borrow_card/wrong_return_code";
        }
        return "redirect:/my_library/borrow";
    }

    @PostMapping
    public String saveBorrowCard(@ModelAttribute("form") BorrowCard borrowCard) throws QuantityException {
        borrowCardService.borrowBook(borrowCard);
        return "redirect:/my_library/borrow";
    }
}
