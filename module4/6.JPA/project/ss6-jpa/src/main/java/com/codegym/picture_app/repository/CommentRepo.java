package ghost_company.picture_app.repository;

import ghost_company.picture_app.entity.Comment;

import java.util.Date;
import java.util.List;

public interface CommentRepo {
    List<Comment> findByDate(Date date);
    void saveComment(Comment comment);
    Comment findById(int id);

}
