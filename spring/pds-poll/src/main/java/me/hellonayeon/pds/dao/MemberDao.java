package me.hellonayeon.pds.dao;

import me.hellonayeon.pds.dto.MemberDto;

public interface MemberDao {

	int getId(String id);
	int addmember(MemberDto dto);
	MemberDto login(MemberDto dto);
}
