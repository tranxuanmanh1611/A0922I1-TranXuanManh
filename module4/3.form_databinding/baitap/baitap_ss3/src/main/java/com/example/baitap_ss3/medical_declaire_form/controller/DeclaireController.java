package com.example.baitap_ss3.medical_declaire_form.controller;

import com.example.baitap_ss3.medical_declaire_form.entity.DeclaireForm;
import com.example.baitap_ss3.medical_declaire_form.service.DeclairFormService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping("declaire_form")
public class DeclaireController{
    @Autowired
    DeclairFormService declairFormService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("medical_declaire_form/list");
        modelAndView.addObject("formList", declairFormService.getAll());
        return modelAndView;
    }

    @GetMapping("new")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("medical_declaire_form/form");
        DeclaireForm declaireForm = new DeclaireForm();
        Date currentDate = new Date();
        declaireForm.setDeclaireDate(currentDate);
        modelAndView.addObject("form", declaireForm);
        modelAndView.addObject("genderList", new String[]{"male", "female", "others"});
        modelAndView.addObject("vehicles", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác"});
        return modelAndView;
    }

    @PostMapping("**/new")
    public String addForm(@ModelAttribute("form") DeclaireForm form) {
        if (declairFormService.findById(form.getId()) != null) {
            declairFormService.editForm(form);
            return "redirect:/declaire_form";
        }
        declairFormService.addForm(form);
        return "redirect:/declaire_form";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable int id){
        ModelAndView modelAndView =new ModelAndView("medical_declaire_form/form");
        modelAndView.addObject("form",declairFormService.findById(id));
        modelAndView.addObject("genderList", new String[]{"male", "female", "others"});
        modelAndView.addObject("vehicles", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác"});
        return modelAndView;
    }



}
