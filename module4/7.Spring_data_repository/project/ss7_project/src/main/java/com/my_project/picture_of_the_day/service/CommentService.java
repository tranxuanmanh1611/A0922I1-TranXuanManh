package com.my_project.picture_of_the_day.service;

import com.my_project.picture_of_the_day.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Date;
import java.util.List;

public interface CommentService {
    Page<Comment> findByDate(Pageable pageable);
//    Comment findById(int id);
    void saveComment(Comment comment);
    void addLike(int id);
    void updateComment(Comment comment);
}
