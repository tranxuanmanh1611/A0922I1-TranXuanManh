package com.example.controller;

import com.example.entities.Condiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.example.entities.CurrentTime;
import java.util.Date;


@Controller
@RequestMapping("sandwich")
public class SandwichController {
    @GetMapping
    public ModelAndView showSandwichCondiments() {

        ModelAndView modelAndView = new ModelAndView("sandwich/sandwich_choose");
        modelAndView.addObject("condiment",new Condiment());
        modelAndView.addObject("condimentList", new String[]{"Lettuce", "Tomato", "Mustard", "Sprouts"});
        return modelAndView;
    }

    @PostMapping
    public ModelAndView showCondimentsResult(@ModelAttribute("condiment") Condiment chosenCondiments) {
        ModelAndView modelAndView = new ModelAndView("sandwich/chosen_condiments");
        modelAndView.addObject("chosenCondiments",chosenCondiments);
        return modelAndView;
    }
}


