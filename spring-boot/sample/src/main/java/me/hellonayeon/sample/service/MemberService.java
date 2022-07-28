package me.hellonayeon.sample.service;

import java.util.List;
import me.hellonayeon.sample.dao.MemberDao;
import me.hellonayeon.sample.dto.response.MemberResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

    private final MemberDao memberDao;

    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public List<MemberResponse> getAllMember() {
        return memberDao.selectAllMember();
    }
}
