package com.example.controller;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("list")
    public String displayList(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "list";
    }
}
