package com.example.baitap_ss3.mail_box.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Language {
    @Id
    @GeneratedValue
    @Column(name = "language_id")
    private int id;

    private String language;

    public Language() {
    }

    public Language(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
