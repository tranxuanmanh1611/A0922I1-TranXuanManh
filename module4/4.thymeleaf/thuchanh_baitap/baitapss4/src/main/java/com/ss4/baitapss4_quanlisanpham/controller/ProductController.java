package com.ss4.baitapss4_quanlisanpham.controller;

import com.ss4.baitapss4_quanlisanpham.entity.Product;
import com.ss4.baitapss4_quanlisanpham.service.CategoryService;

import com.ss4.baitapss4_quanlisanpham.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product_manager")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @GetMapping()
    public ModelAndView showProductList(){
        ModelAndView modelAndView=new ModelAndView("product_manager/list");
        modelAndView.addObject("products",productService.findAll());
        return modelAndView;
    }
    @GetMapping("add")
    public ModelAndView showAddForm(){
        ModelAndView modelAndView = new ModelAndView("product_manager/add");
        modelAndView.addObject("form",new Product());
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }
    @PostMapping("**/add")
    public String addProduct(@ModelAttribute("form") Product product){
        product.setCategory(categoryService.findById(product.getCategory().getId()).get());
        productService.save(product);
        return "redirect:/product_manager";
    }
    @GetMapping("detail/{id}")
    public ModelAndView showDetail(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("product_manager/detail");
        modelAndView.addObject("product",productService.findById(id));
        return modelAndView;
    }
    @GetMapping("**/update/{id}")
    public ModelAndView showUpdate(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("product_manager/update");
        modelAndView.addObject("form",productService.findById(id));
        modelAndView.addObject("categories",categoryService.findAll());
        return modelAndView;
    }
    @GetMapping("**/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        productService.delete(productService.findById(id));
        return "redirect:/product_manager";
    }
    @GetMapping("search")
    public ModelAndView searchByName(@RequestParam String searchByName){
        ModelAndView modelAndView = new ModelAndView("product_manager/list");
        modelAndView.addObject("products",productService.findByName(searchByName));
        return modelAndView;
    }
}
