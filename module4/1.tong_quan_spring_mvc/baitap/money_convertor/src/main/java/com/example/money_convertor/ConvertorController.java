package com.example.money_convertor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ConvertorController {


    @GetMapping("/convertor")
    public String show(){
        return "convertor";
    }
    @PostMapping("/convert")
   public ModelAndView convertMoney(@RequestParam double usd){
       ModelAndView modelAndView = new ModelAndView("convertor");
       modelAndView.addObject("result",usd*22000);
       return modelAndView;
    }
}
