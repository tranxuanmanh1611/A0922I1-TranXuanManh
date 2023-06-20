package ghost_company.picture_app.service;

import ghost_company.picture_app.entity.Comment;

import java.util.Date;
import java.util.List;

public interface CommentService {
    List<Comment> findByDate(Date date);
    void addComment(Comment comment);
}
