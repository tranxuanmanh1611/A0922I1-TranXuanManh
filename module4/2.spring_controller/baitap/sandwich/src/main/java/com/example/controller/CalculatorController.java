package com.example.controller;

import com.example.entities.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("calculator")
public class CalculatorController {
    @Autowired
    Calculator calculator;
    @GetMapping
    public String showCalculator(ModelMap modelMap){
        modelMap.addAttribute("calculator",calculator);
        return "calculator/calculator_main";
    }
    @PostMapping
    public String showResult(@ModelAttribute("calculator") Calculator calculator, @RequestParam("operation") String operation, RedirectAttributes redirectAttributes){

        switch (operation){
            case "plus":
                redirectAttributes.addFlashAttribute("result","the result of this "+operation+" is: "+ calculator.plus());
                break;
            case "minus":
                redirectAttributes.addFlashAttribute("result","the result of this "+operation+" is: "+ calculator.minus());
                break;
            case "multiple":
                redirectAttributes.addFlashAttribute("result","the result of this "+operation+" is: "+ calculator.multiple());
                break;
            case "divide":
                redirectAttributes.addFlashAttribute("result","the result of this "+operation+" is: "+ calculator.divide());
                break;
        }
        this.calculator.setFirstOperand(calculator.getFirstOperand());
        this.calculator.setSecondOperand(calculator.getSecondOperand());
        return "redirect:/calculator";
    }
}
