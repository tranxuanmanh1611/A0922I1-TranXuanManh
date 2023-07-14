package com.my_project.library.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private String summary;
    @Min(0)
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<BorrowCard> borrowCards;

    public Book() {
    }

    public Book(String name, String author, String summary, int quantity, boolean isBorrow) {
        this.name = name;
        this.author = author;
        this.summary = summary;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<BorrowCard> getBorrowCards() {
        return borrowCards;
    }

    public void setBorrowCards(List<BorrowCard> borrowCards) {
        this.borrowCards = borrowCards;
    }
}
