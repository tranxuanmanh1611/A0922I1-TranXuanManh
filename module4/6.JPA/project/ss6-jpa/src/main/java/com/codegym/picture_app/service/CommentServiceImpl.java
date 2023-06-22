package ghost_company.picture_app.service;

import ghost_company.picture_app.entity.Comment;
import ghost_company.picture_app.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Comment> findByDate(Date date) {
        //change the default date pattern match with SQL pattern
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateToParam = null;
        try {
            dateToParam = simpleDateFormat.parse(simpleDateFormat.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //reverse the comment to see the last comment in first line
        Stack<Comment> commentStack =new Stack<>();
        commentStack.addAll(commentRepo.findByDate(dateToParam));
        List<Comment> comments = new ArrayList<>();
        while (!commentStack.isEmpty()){
            comments.add(commentStack.pop());
        }
        return comments;
    }

    @Override
    public Comment findById(int id) {
       return commentRepo.findById(id);
    }

    @Override
    public void addComment(Comment comment) {
        Date date = new Date();
        comment.setCommentDate(date);
        commentRepo.saveComment(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepo.saveComment(comment);
    }

    @Override
    public void addLike(int id) {
        Comment commentToAddLike = findById(id);
        commentToAddLike.setLike(commentToAddLike.getLike()+1);
        updateComment(commentToAddLike);
    }
}
