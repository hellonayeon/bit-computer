package me.hellonayeon.backend.bbs.service;

import me.hellonayeon.backend.bbs.dao.MemberDao;
import me.hellonayeon.backend.bbs.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

	@Autowired
	MemberDao dao;
	
	public boolean getId(Member dto) {
		int n = dao.getId(dto);
		return n>0?true:false;
	}
	
	public boolean account(Member dto) {
		int n = dao.account(dto);
		return n>0?true:false;
	}
	
	public Member login(Member dto) {
		return dao.login(dto);
	}
}




