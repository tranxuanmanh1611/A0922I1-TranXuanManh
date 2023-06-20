package ghost_company.music_app.controller;

import ghost_company.music_app.entity.Music;
import ghost_company.music_app.entity.MusicForm;
import ghost_company.music_app.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("music")
public class musicController {
    @Autowired
    MusicService musicService;
    @Value("${upload_path}")
    private String upload_path;
    @GetMapping
    public ModelAndView showMusicList(){
        ModelAndView modelAndView = new ModelAndView("music/list");
        modelAndView.addObject("musics",musicService.getAllMusic());
        return modelAndView;
    }
    @GetMapping("add")
    public ModelAndView showUploadForm(){
        ModelAndView modelAndView = new ModelAndView("music/upload_form");
        modelAndView.addObject("form",new MusicForm());
        return modelAndView;
    }

    @PostMapping("add")
    public String addMusic(@ModelAttribute("uploadForm") MusicForm form){
        MultipartFile file = form.getFileSong();
        String fileName = file.getOriginalFilename();

        try{
            FileCopyUtils.copy(file.getBytes(),new File(upload_path+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(form.getName(),form.getArtist(), form.getGerne(), fileName);
        musicService.save(music);
        return "redirect:/music";
    }
    @GetMapping("**/delete/{id}")
    public String deleteMusic(@PathVariable("id") int id){
        musicService.delete(id);
        return "redirect:/music";
    }
    @GetMapping("**/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("music/update_form");
        Music musicToUpdate = musicService.findById(id);
        modelAndView.addObject("form",new MusicForm(musicToUpdate.getId(),musicToUpdate.getName(),musicToUpdate.getArtist(),musicToUpdate.getGerne()));
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String updateMusic(@PathVariable("id") int id,@ModelAttribute("form") MusicForm form){
        Music musicToUpdate = musicService.findById(id);
        musicToUpdate.setName(form.getName());
        musicToUpdate.setArtist(form.getArtist());
        musicToUpdate.setGerne(form.getGerne());
        if (form.getFileSong().isEmpty()){
            musicService.save(musicToUpdate);
        }else {
            MultipartFile file = form.getFileSong();
            String fileName = file.getOriginalFilename();

            try{
                FileCopyUtils.copy(file.getBytes(),new File(upload_path+fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                musicToUpdate.setLink(fileName);
                System.out.println(musicToUpdate.getLink());
                musicService.save(musicToUpdate);
            }

        }
        return "redirect:/music";
    }
}
