package com.codegym.picture_app.controller;

import com.codegym.picture_app.entity.Comment;
import com.codegym.picture_app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    CommentService commentService;
    @GetMapping
    public ModelAndView showImage(){
        ModelAndView modelAndView=new ModelAndView("picture/main_page");
        Date currentDate = new Date();
        modelAndView.addObject("comments",commentService.findByDate(currentDate));
        modelAndView.addObject("comment",new Comment());
        return modelAndView;
    }
    @PostMapping("/save")
    public String saveComment(@ModelAttribute("comment") Comment comment){
        commentService.addComment(comment);
        return "redirect:/picture";
    }
    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") int id){
        commentService.addLike(id);
        return "redirect:/picture";
    }
}
