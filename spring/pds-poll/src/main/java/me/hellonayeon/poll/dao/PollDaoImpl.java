package me.hellonayeon.poll.dao;

import java.util.List;
import me.hellonayeon.poll.dto.PollDto;
import me.hellonayeon.poll.dto.PollSubDto;
import me.hellonayeon.poll.dto.Voter;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PollDaoImpl implements PollDao {

    @Autowired
    SqlSession session;

    String namespace = "Poll.";


    @Override
    public List<PollDto> getPollList() {
        return session.selectList(namespace + "getPollList");
    }

    @Override
    public int isVoter(Voter voter) {
        return session.selectOne(namespace + "isVoter", voter);
    }

    @Override
    public void makePoll(PollDto poll) {
        session.insert(namespace + "makePoll", poll);
    }

    @Override
    public void makePollSub(PollSubDto pollSub) {
        session.insert(namespace + "makePollSub", pollSub);
    }

    @Override
    public PollDto getPoll(PollDto poll) {
        return session.selectOne(namespace + "getPoll", poll);
    }

    @Override
    public List<PollSubDto> getPollSubList(PollDto poll) {
        return session.selectList(namespace + "getPollSubList", poll);
    }

    @Override
    public void pollingVoter(Voter voter) {
        session.insert(namespace + "pollingVoter", voter);
    }

    // 투표 주제 늘리기, 투표자 추가
    @Override
    public void pollingPoll(Voter voter) {
        session.update(namespace + "pollingPoll", voter);
    }

    @Override
    public void pollingSub(Voter voter) {
        session.update(namespace + "pollingSub", voter);
    }
}
