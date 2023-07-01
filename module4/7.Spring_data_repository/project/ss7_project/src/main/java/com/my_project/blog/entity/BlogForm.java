package com.my_project.blog.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;


public class BlogForm {
    private Integer id;

    private String title;

    private String content;

    private MultipartFile imageFile;
    private Date postDate;
    private Category category;
    public BlogForm() {
    }

    public BlogForm(String title, String content, MultipartFile imageFile, Date postDate) {
        this.title = title;
        this.content = content;
        this.imageFile = imageFile;
        this.postDate = postDate;
    }

    public BlogForm(int id, String title, String content, MultipartFile imageFile, Date postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageFile = imageFile;
        this.postDate = postDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public MultipartFile getImageFile() {
        return imageFile;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
