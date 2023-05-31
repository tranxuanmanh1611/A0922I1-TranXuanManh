package com.example.baitap_ss3.mail_box.entity;

public class EditForm {
    private String languages;
    private int emailPerPage;
    private boolean spamFilter;
    private String signature;

    public EditForm() {
    }

    public EditForm(String languages, int emailPerPage, boolean spamFilter, String signature) {
        this.languages = languages;
        this.emailPerPage = emailPerPage;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getEmailPerPage() {
        return emailPerPage;
    }

    public void setEmailPerPage(int emailPerPage) {
        this.emailPerPage = emailPerPage;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
