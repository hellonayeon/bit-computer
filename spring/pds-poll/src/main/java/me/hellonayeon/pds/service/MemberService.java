package me.hellonayeon.pds.service;

import me.hellonayeon.pds.dto.MemberDto;

public interface MemberService {

	String getId(String id);
	boolean addmember(MemberDto dto);
	MemberDto login(MemberDto dto);
}
