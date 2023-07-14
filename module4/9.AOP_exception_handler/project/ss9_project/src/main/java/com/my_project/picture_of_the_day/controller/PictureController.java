package com.my_project.picture_of_the_day.controller;

import com.my_project.picture_of_the_day.entity.Comment;
import com.my_project.picture_of_the_day.service.comment.CommentService;
import com.my_project.picture_of_the_day.validate.CommentValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    CommentService commentService;
    @Autowired
    CommentValidate commentValidate;

    @GetMapping
    public ModelAndView showImage(@PageableDefault(value = 3,sort = "commentDate",direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("picture_of_the_day/main_page");
        modelAndView.addObject("comments", commentService.findByDate(pageable));
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveComment(@Validated @ModelAttribute("comment") Comment comment, BindingResult bindingResult) {
        commentValidate.validate(comment,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "picture_of_the_day/warning";
        }else {
            commentService.saveComment(comment);
        }
        return "redirect:/picture";

    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") int id) {
        commentService.addLike(id);
        return "redirect:/picture";
    }
}
