package controllers.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
    @GetMapping("/home-page")
    public String hello() {
        return "web/home";
    }
    @GetMapping("/about")
    public String about() {
        return "web/about";
    }
}

