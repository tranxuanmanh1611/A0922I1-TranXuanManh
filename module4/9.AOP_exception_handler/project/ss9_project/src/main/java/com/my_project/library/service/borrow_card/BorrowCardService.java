package com.my_project.library.service.borrow_card;

import com.my_project.library.entity.BorrowCard;
import com.my_project.library.exception_handler.QuantityException;

import java.util.List;

public interface BorrowCardService {
    void borrowBook(BorrowCard borrowCard) throws QuantityException;
    List<BorrowCard> findAll();
    BorrowCard findById(Integer id);
    boolean checkBorrowCode(Integer borrowCardId,String code);
    void returnBook(BorrowCard borrowCard);
}
