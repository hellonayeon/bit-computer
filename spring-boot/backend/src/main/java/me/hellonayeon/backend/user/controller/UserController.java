package me.hellonayeon.backend.user.controller;

import java.util.Date;


import me.hellonayeon.backend.user.domain.User;
import me.hellonayeon.backend.user.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@RequestMapping(value = "/getId", method = RequestMethod.POST)
	public String getId(User dto) {
		System.out.println("MemberController getId " + new Date());
		boolean b = service.getId(dto);
		if(b) {
			return "NO";
		}else {
			return "OK";
		}
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String account(User dto) {
		System.out.println("MemberController account " + new Date());
		boolean b = service.account(dto);
		if(!b) {
			return "NO";
		}
		
		return "OK";		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(User dto) {
		System.out.println("MemberController login " + new Date());
		
		User mem = service.login(dto);
		return mem;
	}
}


