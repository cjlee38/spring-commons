package org.zerock.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

    @RequestMapping("/basic")
    public void basic() {
        log.info("basic method called");
    }
}
