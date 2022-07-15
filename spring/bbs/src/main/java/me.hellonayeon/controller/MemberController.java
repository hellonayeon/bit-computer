package me.hellonayeon.controller;

import java.util.Date;
import me.hellonayeon.dto.MemberDto;
import me.hellonayeon.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class MemberController {

    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    MemberService service;

    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String login() {
        logger.info("MemberController login(): {}", new Date());
        return "login";
    }

    @RequestMapping(value = "regi.do", method = RequestMethod.GET)
    public String regi() {
        logger.info("MemberController regi(): {}", new Date());
        return "regi";
    }

    @ResponseBody
    @RequestMapping(value = "idcheck.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String idcheck(String id) {
        logger.info("MemberController idcheck(): {}", new Date());

        String str = service.getId(id);
        return str;
    }

    @RequestMapping(value = "addmember.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String addMember(Model model, MemberDto mem) {
        logger.info("MemberController addMember(): {}", new Date());

        boolean b = service.addMember(mem);

        model.addAttribute("msg", b);
        model.addAttribute("process", "login");

        return "";
    }
}
