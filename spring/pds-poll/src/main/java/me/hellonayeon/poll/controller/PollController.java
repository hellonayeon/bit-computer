package me.hellonayeon.poll.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import me.hellonayeon.poll.dto.PollBean;
import me.hellonayeon.poll.dto.PollDto;
import me.hellonayeon.poll.dto.PollSubDto;
import me.hellonayeon.poll.dto.Voter;
import me.hellonayeon.poll.service.PollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PollController {
    Logger logger = LoggerFactory.getLogger(PollController.class);

    @Autowired
    PollService service;

    @RequestMapping(value = "polllist.do", method = RequestMethod.GET)
    public String getPollList(Model model, HttpServletRequest req) {
        logger.info("PollController getPollList(): {}", new Date());

        String id = (String) req.getSession().getAttribute("loginId");
        model.addAttribute("plist", service.getPollList(id));

        return "polllist.tiles";
    }

    @RequestMapping(value = "pollmake.do", method = RequestMethod.GET)
    public String makePoll(Model model, HttpServletRequest req) {
        logger.info("PollController makePoll(): {}", new Date());

        String id = (String) req.getSession().getAttribute("loginId");
        model.addAttribute("id", id);

        return "pollmake.tiles";
    }

    @RequestMapping(value = "pollmakeAf.do", method = RequestMethod.GET)
    public String makeAfter(Model model, PollBean bean) {
        logger.info("PollController makeAfter(): {}", new Date());

        service.makePoll(bean);

        model.addAttribute("doc_title", "투표 목록");
        return "redirect:polllist.do";
    }

    @RequestMapping(value = "polldetail.do", method = RequestMethod.GET)
    public String getPoll(Model model, PollDto poll) {
        logger.info("PollController getPoll(): {}", new Date());

        // 투표 주제
        PollDto dto = service.getPoll(poll);

        // 투표 보기들
        List<PollSubDto> list = service.getPollSubList(poll);

        model.addAttribute("poll", dto); // 투표 항목(제목)
        model.addAttribute("pollSubList", list);

        return "polldetail.tiles";
    }

    @RequestMapping(value = "polling.do", method = RequestMethod.GET)
    public String polling(Voter voter) {
        logger.info("PollController polling(): {}", new Date());

        service.polling(voter);

        return "redirect:polllist.do";
    }

    @RequestMapping(value = "pollresult.do", method = RequestMethod.GET)
    public String getPollResult(PollDto poll, Model model) {
        logger.info("PollController getPollResult(): {}", new Date());

        // Poll (투표 주제)
        PollDto dto = service.getPoll(poll);

        // PollSub (보기들)
        List<PollSubDto> list = service.getPollSubList(poll);

        model.addAttribute("poll", dto);
        model.addAttribute("pollSubList", list);

        return "pollresult.tiles";
    }
}
