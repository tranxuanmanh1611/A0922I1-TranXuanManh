package com.my_project.library.service.borrow_card;

import com.my_project.library.entity.Book;
import com.my_project.library.entity.BorrowCard;
import com.my_project.library.exception_handler.QuantityException;
import com.my_project.library.repository.BookRepo;
import com.my_project.library.repository.BorrowCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BorrowCardServiceImpl implements BorrowCardService {
    @Autowired
    BorrowCardRepo borrowCardRepo;
    @Autowired
    BookRepo bookRepo;

    @Override
    public void borrowBook(BorrowCard borrowCard) throws QuantityException {
        Book bookToBorrow = bookRepo.findById(borrowCard.getBook().getId()).get();
            SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = pattern.parse(pattern.format(new Date()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            try {
                bookToBorrow.setQuantity(bookToBorrow.getQuantity() - 1);
                bookRepo.save(bookToBorrow);
            } catch (TransactionSystemException exception){
                throw new QuantityException();
            }
            borrowCard.setBorrowDate(date);
            borrowCard.setBorrowed(true);
            borrowCardRepo.save(borrowCard);
    }

    @Override
    public void returnBook(BorrowCard borrowCard) {
        borrowCard.setBorrowed(false);

        Book bookToUpdate = bookRepo.findById(borrowCard.getBook().getId()).get();
        bookToUpdate.setQuantity(bookToUpdate.getQuantity() + 1);
        bookRepo.save(bookToUpdate);
        borrowCardRepo.save(borrowCard);
    }

    @Override
    public List<BorrowCard> findAll() {
        return (List<BorrowCard>) borrowCardRepo.findByBorrowedIsTrue();
    }

    @Override
    public BorrowCard findById(Integer id) {
        return borrowCardRepo.findById(id).get();
    }

    @Override
    public boolean checkBorrowCode(Integer borrowCardId ,String code) {
        BorrowCard borrowCardToCheck = borrowCardRepo.findById(borrowCardId).get();
        if (borrowCardToCheck.getBorrowCode().equals(code)){
            return true;
        }
        return false;
    }
}
