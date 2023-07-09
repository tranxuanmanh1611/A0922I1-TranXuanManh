package com.my_project.validate_signup_form.controller;

import com.my_project.validate_signup_form.account_service.AccountService;
import com.my_project.validate_signup_form.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("signup_form")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping
    public String showForm(Model model){
        model.addAttribute("form",new Account());
        return "signup_form/form";
    }
    @PostMapping
    public String addAccount(@Validated @ModelAttribute("form") Account account, BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "signup_form/form";
        }
        Account addedAccount = accountService.save(account);
       model.addAttribute("account",addedAccount);
       return "signup_form/success";
    }
}
