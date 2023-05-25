package com.example.email_validate_gradle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Controller
public class EmailValidate {
    String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+\\.[A-Za-z0-9]+";
    Pattern pattern;
    Matcher matcher;
    public EmailValidate(){
        pattern=Pattern.compile(regex);
    }


    @GetMapping("")
    public String home(){
        return "home";
    }

    @PostMapping("validate")
    public String validate(@RequestParam String email,ModelMap modelMap){
        boolean isValid = validateEmail(email);
        if (!isValid){
            modelMap.addAttribute("error","email is invalid");
            return "home";
        }
        modelMap.addAttribute("email",email);
        return "success";
    }
    private boolean validateEmail(String regex){
        matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
