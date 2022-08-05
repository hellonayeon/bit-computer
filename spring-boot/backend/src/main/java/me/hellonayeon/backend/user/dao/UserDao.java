package me.hellonayeon.backend.member.dao;

import me.hellonayeon.backend.member.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao {

	int getId(Member dto);
	int account(Member dto);
	Member login(Member dto);
}
