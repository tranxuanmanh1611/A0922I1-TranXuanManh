package com.my_project.library.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BorrowCard {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String borrower;
    private String borrowCode;
@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date borrowDate;
    @Column(columnDefinition = "BOOLEAN default '1'")
    private boolean borrowed;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public BorrowCard() {
    }

    public BorrowCard(String borrower, String borrowCode, Date borrowDate, boolean borrowed, Book book) {
        this.borrower = borrower;
        this.borrowCode = borrowCode;
        this.borrowDate = borrowDate;
        this.borrowed = borrowed;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
