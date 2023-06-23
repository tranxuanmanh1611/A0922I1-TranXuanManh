package com.codegym.blog.controller;

import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.BlogForm;
import com.codegym.blog.service.BlogService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping
    public ModelAndView showBlogs(){
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("blogs",blogService.findAll());
        return modelAndView;
    }
    @GetMapping("{id}")
    public ModelAndView showInfo(@ModelAttribute("id") int id){
        ModelAndView modelAndView = new ModelAndView("blog/info");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }

    @GetMapping("save")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("blog/save");
        modelAndView.addObject("form",new BlogForm());
        return modelAndView;
    }
    @PostMapping("**/save")
    public String saveBlog(@ModelAttribute("form")BlogForm blogForm){
        blogService.save(blogForm);
        return "redirect:/blogs";
    }

    @GetMapping("update/{id}")
    public ModelAndView showEditForm(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("blog/save");
        Blog blogToUpdate = blogService.findById(id);
        BlogForm formToUpdate = new BlogForm();
        formToUpdate.setId(blogToUpdate.getId());
        formToUpdate.setTitle(blogToUpdate.getTitle());
        formToUpdate.setContent(blogToUpdate.getContent());
        modelAndView.addObject("form",formToUpdate);
        return modelAndView;
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        blogService.delete(id);
        return "redirect:/blogs";
    }
}
