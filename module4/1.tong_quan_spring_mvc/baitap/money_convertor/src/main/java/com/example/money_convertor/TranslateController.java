package com.example.money_convertor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.DictDB;

import java.util.HashMap;

@Controller
public class TranslateController {
    DictDB dictDB = new DictDB();
    @GetMapping("/dictionary")
    public String show(){
        return "translate";
    }

    @GetMapping("/translate")
    public ModelAndView translate(@RequestParam String word){
        ModelAndView modelAndView = new ModelAndView("translate");
        String result = dictDB.dictionary.get(word);
        if (result==null){
            result ="Not found";
        }
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
