package ghost_company.picture_app.controller;

import ghost_company.picture_app.entity.Comment;
import ghost_company.picture_app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    CommentService commentService;
    @GetMapping
    public ModelAndView showImage(){
        ModelAndView modelAndView=new ModelAndView("picture/main_page");
        Date currentDate = new Date();
        modelAndView.addObject("comments",commentService.findByDate(currentDate));
        modelAndView.addObject("comment",new Comment());
        return modelAndView;
    }
    @PostMapping("/save")
    public String saveComment(@ModelAttribute("comment") Comment comment){
        commentService.addComment(comment);
        return "redirect:/picture";
    }
}
