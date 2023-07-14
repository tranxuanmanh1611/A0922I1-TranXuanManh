package com.my_project.library.exception_handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class QuantityExceptionHandler {
    @ExceptionHandler(QuantityException.class)
    public ModelAndView showQuantityError(){
        return new ModelAndView( "library/book/no_book");
    }
}
