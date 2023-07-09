package com.my_project.validate_form_input.controller;

import com.my_project.validate_form_input.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/validate_form_input")
public class UserController {
    @GetMapping
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("validate_form_input/index");
        modelAndView.addObject("form",new User());
        return modelAndView;
    }
    @PostMapping("/validate")
    public ModelAndView validateUser(@Validated @ModelAttribute("form") User user, BindingResult bindingResult  ){
        System.out.println("name:"+ user.getName()+"|age:"+user.getAge());
        if (bindingResult.hasErrors()){
            return new ModelAndView("validate_form_input/index");
        }
        return new ModelAndView("validate_form_input/success");
    }

}
