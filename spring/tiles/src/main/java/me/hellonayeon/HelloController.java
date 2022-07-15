package me.hellonayeon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("login.do")
    public String login() {
        logger.info("HelloController.class login.do");
        return "login.tiles";
    }

    @RequestMapping("bbslist.do")
    public String bbs() {
        logger.info("HelloController.class bbslist.do");
        return "bbslist.tiles";
    }
}