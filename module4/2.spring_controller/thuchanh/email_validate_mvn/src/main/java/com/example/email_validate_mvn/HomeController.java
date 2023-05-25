package com.example.email_validate_mvn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static final String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+\\.[A-Za-z0-9]+$";
    private static Pattern pattern;
    private static Matcher matcher;

    public HomeController(){
        pattern = Pattern.compile(regex);
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @PostMapping("/validate")
    public String user(@RequestParam String email, ModelMap modelMap){
        boolean isValid = validate(email);
        if(!isValid){
            modelMap.addAttribute("message","Email ko hop le");
            return "home";
        }
        modelMap.addAttribute("email",email);
        return "success";
    }

    private boolean validate(String regex){
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
