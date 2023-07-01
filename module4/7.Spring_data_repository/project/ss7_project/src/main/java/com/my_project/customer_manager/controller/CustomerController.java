package com.my_project.customer_manager.controller;

import com.my_project.customer_manager.entity.Customer;
import com.my_project.customer_manager.entity.Province;
import com.my_project.customer_manager.service.customer.CustomerService;
import com.my_project.customer_manager.service.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    ProvinceService provinceService;



    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        Page<Customer> customers =customerService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer_manager/customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

  /*  @GetMapping("/province/{id}")
    public ModelAndView showListByProvince(@PathVariable("id") Province province){
        ModelAndView modelAndView = new ModelAndView("customer_manager/customer/list");
        modelAndView.addObject("customers",customerService.findAllByProvince(province));
        return modelAndView;
    }*/

    @GetMapping("/{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customer_manager/customer/detail");
        if (customer != null) {
            modelAndView.addObject("customer", customer);
        } else {
            modelAndView.addObject("error", "NOT FOUND");
        }

        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView showSearchList(@RequestParam("keyword") String keyword,@PageableDefault(value = 3)Pageable pageable){
       Page<Customer> customers;
        ModelAndView modelAndView= new ModelAndView("customer_manager/customer/list");
        if (keyword!= null){
            customers = customerService.findAllByFirstNameContaining(keyword,pageable);
        }else {
            customers=customerService.findAll(pageable);
        }
        modelAndView.addObject("customers", customers );
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Long id) {
        customerService.remove(customerService.findById(id));
        return "redirect:/customers";
    }

    @GetMapping("/save/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customer_manager/customer/save");
        modelAndView.addObject("customer", customerService.findById(id));
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @GetMapping("/save")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer_manager/customer/save");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("provinces", provinceService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

}
