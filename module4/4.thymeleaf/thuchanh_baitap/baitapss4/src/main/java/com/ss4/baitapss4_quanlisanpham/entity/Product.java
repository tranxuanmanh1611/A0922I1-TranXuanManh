package com.ss4.baitapss4_quanlisanpham.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private int id;
    @Column(name = "pro_name")
    private String name;
    @Column(name = "pro_quantity")
    private int quantity;
    @Column(name = "pro_dateRelease")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRelease;
    @Column(name = "pro_price")
    private int price;
    @ManyToOne
    @JoinColumn(name = "cate_id",referencedColumnName = "cate_id")
    private Category category;

    public Product() {
    }

    public Product(String name, int quantity, Date dateRelease, int price, Category category) {
        this.name = name;
        this.quantity = quantity;
        this.dateRelease = dateRelease;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
