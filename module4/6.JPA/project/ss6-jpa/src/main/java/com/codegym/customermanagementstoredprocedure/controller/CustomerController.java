package com.codegym.customermanagementstoredprocedure.controller;

import com.codegym.customermanagementstoredprocedure.entity.Customer;
import com.codegym.customermanagementstoredprocedure.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping
    public ModelAndView showInput(){
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("form",new Customer());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addCustomer(@ModelAttribute("form") Customer customer){
        customerService.addCustomer(customer);
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("message","Create Success "+customer.getFirstName() +" "+customer.getLastName());
        return modelAndView;
    }
}
