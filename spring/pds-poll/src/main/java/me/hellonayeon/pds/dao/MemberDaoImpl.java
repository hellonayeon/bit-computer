package me.hellonayeon.pds.dao;

import me.hellonayeon.pds.dto.MemberDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession session;
	
	String ns = "Member.";

	@Override
	public int getId(String id) {
		int count = session.selectOne(ns + "getId", id);
		return count;
	}

	@Override
	public int addmember(MemberDto dto) {
		return session.insert(ns + "addmember", dto);
	}

	@Override
	public MemberDto login(MemberDto dto) {		
		return session.selectOne(ns + "login", dto);		
	}	
	
	
	
}




