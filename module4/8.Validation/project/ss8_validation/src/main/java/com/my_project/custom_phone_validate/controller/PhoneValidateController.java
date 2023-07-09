package com.my_project.custom_phone_validate.controller;

import com.my_project.custom_phone_validate.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/phone_validate")
public class PhoneValidateController {
    @GetMapping
    public String showForm(Model model){
        model.addAttribute("phone",new PhoneNumber());
        return "custom_phone_validate/index";
    }
    @PostMapping
    public String showResult(@Validated @ModelAttribute("phone") PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
       new PhoneNumber().validate(phoneNumber,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "custom_phone_validate/index";
        }else {
            model.addAttribute("phone",phoneNumber);
            return "custom_phone_validate/welcome";
        }

    }
}
