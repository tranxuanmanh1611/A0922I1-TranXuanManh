package com.my_project.blog.controller;

import com.my_project.blog.entity.Category;
import com.my_project.blog.service.category_service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("blogs/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public ModelAndView showCategoryList(){
        ModelAndView modelAndView = new ModelAndView("blog/category_view/list");
        modelAndView.addObject("categories",categoryService.findAll()   );
        return modelAndView;
    }
    @GetMapping("{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("blog/category_view/info");
        modelAndView.addObject("category",categoryService.findById(id)) ;
        return modelAndView;
    }
    @GetMapping("/save")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("blog/category_view/save");
        modelAndView.addObject("form",new Category());
        return modelAndView;
    }
    @GetMapping("/save/{id}")
    public ModelAndView showEditForm(@PathVariable("id") Long id){
        ModelAndView modelAndView=new ModelAndView("blog/category_view/save");
        modelAndView.addObject("form",categoryService.findById(id));
        return modelAndView;
    }
    @PostMapping("/save/**")
    public String saveCategory(@ModelAttribute("form") Category category){
        categoryService.save(category);
        return "redirect:/blogs/categories/";
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteById(id);
        return "redirect:/blogs/categories/";
    }
}
