package me.hellonayeon.backend.bbs.dao;

import me.hellonayeon.backend.bbs.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao {

	int getId(MemberDto dto);
	int account(MemberDto dto);
	MemberDto login(MemberDto dto);
}
