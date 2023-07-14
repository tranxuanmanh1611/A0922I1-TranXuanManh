package com.my_project.picture_of_the_day.aspect;

import com.my_project.picture_of_the_day.entity.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class BadContentLog {
    @After("saveCommentPointCut()")
    public void afterAddComment(JoinPoint joinPoint) throws ParseException {
       Object[] argumentArray = joinPoint.getArgs();
       Comment badComment = null;
       BindingResult bindingResult = null;
       for (Object o : argumentArray){
           if (o instanceof BindingResult){
               bindingResult = (BindingResult) o;
           }
           if (o instanceof Comment){
               badComment= (Comment) o;
           }
       }
       if (bindingResult.hasErrors()){
           SimpleDateFormat pattern = new SimpleDateFormat("hh:mm:ss dd-MM-yyyy");
           String user = badComment.getAuthor();
           String comment = badComment.getFeedBack();
           System.out.println("User: "+user+" had a bad comment: "+comment+", on: "+pattern.parse(pattern.format(new Date())));
       }

    }

    @Pointcut(value = "execution(public * com.my_project.picture_of_the_day.controller.PictureController.saveComment(..))")
    public void saveCommentPointCut(){}

}
