package com.codegym.blog.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "blog_title")
    private String title;
    @Column(name = "blog_content")
    private String content;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name="post_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private Date postDate;
    public Blog() {
    }

    public Blog(String title, String content, String imagePath,Date postDate) {
        this.title = title;
        this.content = content;
        this.imagePath = imagePath;
        this.postDate=postDate;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
