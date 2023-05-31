package com.example.baitap_ss3.mail_box.repo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Languages {
    private List<String> languages;
    public Languages() {
        languages = new ArrayList<>();
        languages.add("Vietnamese");
        languages.add("English");
        languages.add("Japanese");
        languages.add("Chinese");
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
