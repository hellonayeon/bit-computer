package me.hellonayeon.dao;

import me.hellonayeon.dto.MemberDto;

public interface MemberDao {

    int getId(String id);

    int addMember(MemberDto dto);
}
