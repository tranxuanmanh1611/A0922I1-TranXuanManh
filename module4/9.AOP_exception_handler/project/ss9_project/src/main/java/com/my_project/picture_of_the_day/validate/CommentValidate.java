package com.my_project.picture_of_the_day.validate;

import com.my_project.picture_of_the_day.entity.BadWord;
import com.my_project.picture_of_the_day.entity.Comment;
import com.my_project.picture_of_the_day.service.badword.BadWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
@Component
public class CommentValidate implements Validator {
    @Autowired
    BadWordService badWordService;
    public CommentValidate() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Comment.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors){
        Iterable<BadWord> badWordList =  badWordService.findAll();
        Comment comment = (Comment) target;
        for (BadWord badWord : badWordList){
            if (comment.getFeedBack().contains(badWord.getWord())){
                errors.rejectValue("feedBack","comment.bad");
                return;
            }
        }
    }
}
