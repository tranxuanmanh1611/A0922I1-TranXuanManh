package com.my_project.blog.formater;

import com.my_project.blog.entity.Category;
import com.my_project.blog.service.category_service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
@Component
public class CategoryFormater implements Formatter<Category> {
    @Autowired
    CategoryService categoryService;
    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return categoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return String.valueOf(object.getId());
    }
}
