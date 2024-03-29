package com.codegym.picture_app.service;

import com.codegym.picture_app.entity.Comment;


import java.util.Date;
import java.util.List;

public interface CommentService {
    List<Comment> findByDate(Date date);
    Comment findById(int id);
    void addComment(Comment comment);
    void addLike(int id);
    void updateComment(Comment comment);
}
