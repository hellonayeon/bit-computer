package me.hellonayeon.backend.hellosample.service;

import java.util.List;
import me.hellonayeon.backend.hellosample.dao.MemberDao;
import me.hellonayeon.backend.hellosample.dto.response.MemberResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
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
