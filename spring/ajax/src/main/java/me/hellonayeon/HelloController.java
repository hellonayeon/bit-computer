package me.hellonayeon;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.hellonayeon.dto.Human;
import me.hellonayeon.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello.do", method = RequestMethod.GET)
    public String hello(Model model) {
        logger.info("HelloController hello(): {}", new Date());

        MemberDto mem = new MemberDto(1001, "홍길동");
        model.addAttribute("mem", mem);

        return "hello";
    }

    // FE to BE
    @RequestMapping(value = "/move.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String move(MemberDto dto) { // MemberDto IoC
        logger.info("HelloController movie(): {}", new Date());

        System.out.println("number: " + dto.getNumber() + " name: " + dto.getName());

        return "hello";
    }

    // Ajax
    @ResponseBody
    @RequestMapping(value = "/idcheck.do", method = {RequestMethod.GET, RequestMethod.POST},
                    produces = "application/String; charset=utf-8")
    public String idcheck(String id) {
        logger.info("HelloController idcheck(): {}", new Date());

        // 받은 데이터
        System.out.println("id: " + id);

        // 보낼 데이터
        String str = "오케이 :D";

        return str;
    }

    @ResponseBody
    @RequestMapping(value = "/account.do", method = {RequestMethod.GET, RequestMethod.POST},
        produces = "application/String; charset=utf-8")
    public Map<String, Object> account(Human h) {
        logger.info("HelloController account(): {}" + new Date());

        System.out.println(h.toString());

        // DB

        // list
        List<MemberDto> list = new ArrayList<MemberDto>();
        list.add(new MemberDto(1, "홍길동"));
        list.add(new MemberDto(2, "성춘향"));

        // string
        String message = "안녕하세요";


        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("msg", message);

        return map;
    }

}
