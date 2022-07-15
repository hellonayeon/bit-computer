package me.hellonayeon.service;

import me.hellonayeon.dto.MemberDto;

public interface MemberService {

    String getId(String id);

    boolean addMember(MemberDto dto);

}
