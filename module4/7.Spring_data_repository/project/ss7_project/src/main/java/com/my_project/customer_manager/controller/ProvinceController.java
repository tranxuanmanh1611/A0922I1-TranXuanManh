package com.my_project.customer_manager.controller;

import com.my_project.customer_manager.entity.Province;
import com.my_project.customer_manager.service.province.ProvinceService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/provinces")
public class ProvinceController {
    @Autowired
    ProvinceService provinceService;
    @GetMapping
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("customer_manager/province/list");
        modelAndView.addObject("provinces",provinceService.findAll());
        return modelAndView;
    }
    @GetMapping("/{id}")
    public ModelAndView showDetail(@PathVariable Long id){
        ModelAndView modelAndView =new ModelAndView("customer_manager/province/detail");
        modelAndView.addObject("province",provinceService.findById(id));
        return modelAndView;
    }
    @GetMapping("/save")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("customer_manager/province/save");
        modelAndView.addObject("form",new Province());
        return modelAndView;
    }
    @GetMapping("/save/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        ModelAndView modelAndView=new ModelAndView("customer_manager/province/save");
        modelAndView.addObject("form",provinceService.findById(id));
        return modelAndView;
    }
    @PostMapping("/save/**")
    public String saveProvince(@ModelAttribute Province province){
        provinceService.save(province);
        return "redirect:/provinces";
    }
    @GetMapping("delete/{id}")
    public String deleteProvince(@PathVariable("id") Province province ){
        provinceService.remove(province);
        return "redirect:/provinces";
    }

}
