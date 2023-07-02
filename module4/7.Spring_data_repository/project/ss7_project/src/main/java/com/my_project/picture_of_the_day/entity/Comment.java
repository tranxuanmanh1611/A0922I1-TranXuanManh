package com.my_project.picture_of_the_day.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;
    @Column(name = "comment_rating")
    private int rating;
    @Column(name = "comment_author")
    private String author;
    @Column(name = "comment_feed_back")
    private String feedBack;
    @Column(name = "comment_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date commentDate;
    @Column(name="comment_like" )
    private int like;

    public Comment() {
    }

    public Comment(int rating, String author, String feedBack, Date date,int like) {
        this.rating = rating;
        this.author = author;
        this.feedBack = feedBack;
        this.commentDate = date;
        this.like= like;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
