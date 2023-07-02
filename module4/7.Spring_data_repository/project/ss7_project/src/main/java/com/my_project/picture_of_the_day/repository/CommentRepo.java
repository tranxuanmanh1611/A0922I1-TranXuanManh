package com.my_project.picture_of_the_day.repository;



import com.my_project.picture_of_the_day.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Date;

public interface CommentRepo extends PagingAndSortingRepository<Comment,Integer> {
    Page<Comment> findByCommentDateIsGreaterThanEqual(Pageable pageable, Date date);


}
