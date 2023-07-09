package com.my_project.validate_music.controller;

import com.my_project.validate_music.entity.Song;
import com.my_project.validate_music.service.SongService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("validate_music")
public class SongController {

    @Autowired
    SongService songService;
    @GetMapping
    public String showList(Model model){
        model.addAttribute("songs",songService.findAll());
        return "validate_music/list";
    }
    @GetMapping("/{id}")
    public String showInfo(@PathVariable("id") Integer id, Model model){
        model.addAttribute("song",songService.findById(id));
        return "validate_music/info";
    }
    @GetMapping("/save")
    public String showCreateForm(Model model){
        model.addAttribute("form",new Song());
        return "validate_music/add_or_update";
    }
    @GetMapping("/save/{id}")
    public String showEditForm(Model model,@PathVariable("id") int id){
        model.addAttribute("form",songService.findById(id));
        return "validate_music/add_or_update";
    }
    @PostMapping("**/save")
    public String saveSong(@Validated @ModelAttribute("form") Song song, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "validate_music/add_or_update";
        }
        songService.save(song);
        return "redirect:/validate_music";
    }
    @GetMapping("delete/{id}")
    public String deleteSong(@PathVariable("id") int id){
        songService.deleteById(id);
        return "redirect:/validate_music";
    }
}
