package com.my_project.customer_manager.handler;

import com.my_project.customer_manager.exception.DuplicateEmailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DuplicateHandler {
    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputIsWrong(){
        return new ModelAndView("customer_manager/customer/input_error");
    }
}
