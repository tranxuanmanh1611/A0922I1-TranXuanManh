package com.example.baitap_ss3.mail_box.controller;


import com.example.baitap_ss3.mail_box.entity.MailBox;
import com.example.baitap_ss3.mail_box.repo.LanguageRepository;
import com.example.baitap_ss3.mail_box.repo.MailboxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("mail_box")
public class MailBoxController {
    @Autowired
    private MailboxRepository mailBoxRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @GetMapping
    public String showList(Model model){
        model.addAttribute("mail_boxes",mailBoxRepository.findAll());
        return "mail_box/mail_list";
    }

    @GetMapping("*/{id}/update")
    public String showForm(Model model,@PathVariable int id){
        model.addAttribute("languages",languageRepository.findAll());
        model.addAttribute("form",mailBoxRepository.findById(id));
        model.addAttribute("pages",new int[] {5,10,15,20});
        return "mail_box/mail_form";
    }
    @GetMapping("info/{id}")
    public String showInfo(@PathVariable int id,Model model){
        model.addAttribute("mailbox",mailBoxRepository.findById(id));
        return "mail_box/mail_info";
    }
    @PostMapping("**/update")
    public String save(@ModelAttribute("form") MailBox mailBox,Model model){
        mailBox.setLanguage(languageRepository.findById(mailBox.getLanguage().getId()));
       mailBoxRepository.save(mailBox);
       model.addAttribute("mailbox",mailBox);
        return "mail_box/mail_info";
    }
}
