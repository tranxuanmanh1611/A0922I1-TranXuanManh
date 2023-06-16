package com.ss4.thuchanhss4_quanlikhachhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ss4.thuchanhss4_quanlikhachhang.entity.Customer;
import com.ss4.thuchanhss4_quanlikhachhang.service.CustomerService;

@Controller
@RequestMapping("customer_manager")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("customer_manager/cus_list");
        modelAndView.addObject("list",customerService.findAll());
        return modelAndView;
    }
    @GetMapping("update")
    public ModelAndView showForm(){
        ModelAndView modelAndView=new ModelAndView("customer_manager/add_form");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("update")
    public String addNew(@ModelAttribute Customer customer){
        customerService.add(customer);
        return "redirect:/customer_manager";
    }
}
