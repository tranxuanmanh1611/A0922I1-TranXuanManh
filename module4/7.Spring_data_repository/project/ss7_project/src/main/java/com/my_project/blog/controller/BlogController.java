package com.my_project.blog.controller;

import com.my_project.blog.entity.Blog;
import com.my_project.blog.entity.BlogForm;
import com.my_project.blog.service.blog_service.BlogService;
import com.my_project.blog.service.category_service.CategoryService;
import com.my_project.customer_manager.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @GetMapping
    public ModelAndView showBlogs(@PageableDefault(value = 5,sort = "postDate",direction = Sort.Direction.DESC) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("blog/blog_view/list");
        Page<Blog> blogs =blogService.findAll(pageable);
      modelAndView.addObject("blogs",blogs);
      modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("/by_category/{id}")
    public ModelAndView showBlogsByCategory(@PageableDefault(value = 5,sort = "postDate",direction = Sort.Direction.DESC) Pageable pageable,
                                            @PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("blog/blog_view/list");
        modelAndView.addObject("blogs",blogService.findAllByCategory(pageable,id))  ;
        return modelAndView;
    }

   @GetMapping("{id}")
    public ModelAndView showInfo(@ModelAttribute("id") int id){
        ModelAndView modelAndView = new ModelAndView("blog/blog_view/info");
        modelAndView.addObject("blog",blogService.findById(id));
        return modelAndView;
    }

    @GetMapping("save")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("blog/blog_view/save");
        modelAndView.addObject("form",new BlogForm());
        modelAndView.addObject("categories",categoryService.findAll()   );
        return modelAndView;
    }
    @PostMapping("**/save")
    public String saveBlog(@ModelAttribute("form")BlogForm blogForm){
        blogService.save(blogForm);
        return "redirect:/blogs";
    }

    @GetMapping("update/{id}")
    public ModelAndView showEditForm(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("blog/blog_view/save");
        Blog blogToUpdate = blogService.findById(id);
        BlogForm formToUpdate = new BlogForm();
        formToUpdate.setId(blogToUpdate.getId());
        formToUpdate.setTitle(blogToUpdate.getTitle());
        formToUpdate.setContent(blogToUpdate.getContent());
        formToUpdate.setCategory(blogToUpdate.getCategory());
        modelAndView.addObject("form",formToUpdate);
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") int id){
        blogService.deleteById(id);
        return "redirect:/blogs";
    }

    @GetMapping("search")
    public ModelAndView showSearchByTitle(@PageableDefault(value = 5,sort = "postDate",direction = Sort.Direction.DESC) Pageable pageable
                                        , @RequestParam("title") String title){
        ModelAndView modelAndView = new ModelAndView("blog/blog_view/list");
        Page<Blog> blogs;
        if (!title.equals("")){
            blogs=blogService.findAllByTitle(pageable,title);
            modelAndView.addObject("blogs",blogs);
        }else {
            modelAndView=new ModelAndView("redirect:/blogs");
        }

        return modelAndView;
    }
}
