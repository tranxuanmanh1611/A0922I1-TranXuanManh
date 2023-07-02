package com.my_project.picture_of_the_day.controller;

import com.my_project.picture_of_the_day.entity.Comment;
import com.my_project.picture_of_the_day.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    CommentService commentService;

    @GetMapping
    public ModelAndView showImage(@PageableDefault(value = 3,sort = "commentDate",direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("picture_of_the_day/main_page");
        modelAndView.addObject("comments", commentService.findByDate(pageable));
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveComment(@ModelAttribute("comment") Comment comment) {
        commentService.saveComment(comment);
        return "redirect:/picture";
    }

    @GetMapping("/like/{id}")
    public String like(@PathVariable("id") int id) {
        commentService.addLike(id);
        return "redirect:/picture";
    }
}
