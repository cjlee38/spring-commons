package org.cjlee.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        log.info("home controller invocated");
        model.addAttribute("greetings", "hello spring");

        return "home";
    }
}
