package me.hellonayeon.sample.controller;

import java.util.Date;
import java.util.List;
import me.hellonayeon.sample.dto.request.MemberRequest;
import me.hellonayeon.sample.dto.response.MemberResponse;
import me.hellonayeon.sample.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);
    private final MemberService memberService;

    public HelloController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/base", method = RequestMethod.GET)
    public String base() {
        logger.info("HelloController base(): {}", new Date());
        return "base";
    }

    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public MemberResponse getMember() {
        logger.info("HelloController getMember(): {}", new Date());

        MemberResponse response = new MemberResponse("abc", "123", "홍길동", "gildong@naver.com", 3);
        return response;
    }

    @RequestMapping(value = "/conn-param", method = RequestMethod.GET)
    public String connParam(String title, int num) {
        logger.info("HelloController connParam(): {}", new Date());

        logger.info("title: {}\t num: {}", title, num);
        return "conn success :D";
    }

    @RequestMapping(value = "/conn-param-obj", method = RequestMethod.POST)
    public String connParamObject(MemberRequest dto) {
        logger.info("HelloController connParamObj(): {}", new Date());

        logger.info("MemberRequest DTO: {}", dto);
        return "OK";
    }

    @RequestMapping(value = "/db-test", method = RequestMethod.GET)
    public List<MemberResponse> dbTest() {
        logger.info("HelloController dbTest(): {}", new Date());

        return memberService.getAllMember();
    }
}
