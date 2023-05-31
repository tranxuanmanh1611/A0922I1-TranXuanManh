package thuchanh.controller;

import thuchanh.dao.UserDao;
import thuchanh.entities.login.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import thuchanh.entities.login.User;

@Controller
@RequestMapping("home")
public class UserController {


    @GetMapping
    public String showLogin(Model model){
        model.addAttribute("loginForm",new Login());
        return "login/home";
    }

@PostMapping
    public String showInfo(@ModelAttribute("loginForm") Login login,Model model){
       User userToLogin = UserDao.checkLogin(login);
       if (userToLogin==null){
            return "login/error";
       }
       model.addAttribute("user",userToLogin);
       return "login/info";
}
}
