package me.hellonayeon.backend.user.service;

import me.hellonayeon.backend.user.dao.UserDao;
import me.hellonayeon.backend.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao dao;
	
	public boolean getId(User dto) {
		int n = dao.getId(dto);
		return n>0?true:false;
	}
	
	public boolean account(User dto) {
		int n = dao.account(dto);
		return n>0?true:false;
	}
	
	public User login(User dto) {
		return dao.login(dto);
	}
}




