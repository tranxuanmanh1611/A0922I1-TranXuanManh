package com.my_project.picture_of_the_day.service;

import com.my_project.picture_of_the_day.entity.Comment;
import com.my_project.picture_of_the_day.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    CommentRepo commentRepo;

    @Override
    public Page<Comment> findByDate( Pageable pageable) {
        Date date = new Date();
        SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        try {
            date = pattern.parse(pattern.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return commentRepo.findByCommentDateIsGreaterThanEqual(pageable,date);
    }

    @Override
    public void saveComment(Comment comment) {
        Date date = new Date();
        comment.setCommentDate(date);
        commentRepo.save(comment)   ;
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void addLike(int id) {
        Comment commentToAddLike = commentRepo.findById(id).get();
        commentToAddLike.setLike(commentToAddLike.getLike()+1);
        updateComment(commentToAddLike);
    }
}
