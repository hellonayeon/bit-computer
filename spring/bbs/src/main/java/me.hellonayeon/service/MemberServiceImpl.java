package me.hellonayeon.service;

import me.hellonayeon.dao.MemberDao;
import me.hellonayeon.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberDao dao;

    @Override
    public String getId(String id) {
        int count = dao.getId(id);

        return count > 0 ? "YES" : "NO";
    }

    public boolean addMember(MemberDto dto) {
        int n = dao.addMember(dto);
        return n > 0;
    }
}
