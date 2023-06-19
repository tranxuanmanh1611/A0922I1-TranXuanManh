package ghost_company;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class welcomePage {
    @RequestMapping
    public String showWelcomePage(){
        return "welcome";
    }
}
