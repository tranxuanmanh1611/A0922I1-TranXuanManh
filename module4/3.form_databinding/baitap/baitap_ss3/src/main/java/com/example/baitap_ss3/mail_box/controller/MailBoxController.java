package com.example.baitap_ss3.mail_box.controller;

import com.example.baitap_ss3.mail_box.entity.EditForm;
import com.example.baitap_ss3.mail_box.entity.MailBox;
import com.example.baitap_ss3.mail_box.repo.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mail_box")
public class MailBoxController {
    @Autowired
    private Languages languages;

    @GetMapping
    public String showForm(Model model){
        model.addAttribute("languages",languages.getLanguages());
        model.addAttribute("form",new EditForm());
        model.addAttribute("pages",new int[] {5,10,15,20});
        return "mail_box/mail_form";
    }
    @PostMapping("save")
    public String saveAndShow(@ModelAttribute("form") EditForm editForm,Model model){
        MailBox mailBox = new MailBox(editForm.getLanguages(),editForm.getEmailPerPage(),editForm.isSpamFilter(),editForm.getSignature());
        model.addAttribute("mailbox",mailBox);
        return "mail_box/mail_info";
    }
}
