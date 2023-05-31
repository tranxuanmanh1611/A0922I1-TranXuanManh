package thuchanh.controller;

import thuchanh.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @GetMapping
    public String showCreateForm(Model model){
        model.addAttribute("employee",new Employee());
        return "employee/create";
    }


    @PostMapping
    public String create(@ModelAttribute("employee") Employee employee, ModelMap modelMap){
    modelMap.addAttribute("employee",employee);
        return "employee/employee_info";
    }
}
