package me.hellonayeon.poll.service;

import java.util.ArrayList;
import java.util.List;
import me.hellonayeon.poll.dao.PollDao;
import me.hellonayeon.poll.dto.PollBean;
import me.hellonayeon.poll.dto.PollDto;
import me.hellonayeon.poll.dto.PollSubDto;
import me.hellonayeon.poll.dto.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {

    @Autowired
    PollDao dao;

    @Override
    public List<PollDto> getPollList(String id) {
        // 모든 투표 목록 취득
        List<PollDto> list = dao.getPollList();

        // 편집을 통해서 투펴가 가능한지 설정해서 목록을 제작
        List<PollDto> plist = new ArrayList<>();

        for (PollDto poll : list) {
            int pollId = poll.getPollId();

            // 1: 이미 투표 했음  0: 아직 투표 안했음
            int count = dao.isVoter(new Voter(pollId, id));
            if (count == 1) {
                poll.setVote(true);
            }
            else {
                poll.setVote(false);
            }

            plist.add(poll);
        }
        return plist;
    }

    @Override
    public void makePoll(PollBean bean) {

        // 투표 주제
        PollDto poll = new PollDto(bean.getId(), bean.getQuestion(), bean.getSDate(), bean.getEDate(), bean.getItemCount(), 0);
        dao.makePoll(poll);

        // 투표 보기들
        String[] answer = bean.getPollNum();

        for (int i=0; i<bean.getItemCount(); i++) {
            PollSubDto pollSub = new PollSubDto();
            pollSub.setAnswer(answer[i]);

            dao.makePollSub(pollSub);
        }
    }

    @Override
    public PollDto getPoll(PollDto poll) {
        return dao.getPoll(poll);
    }

    @Override
    public List<PollSubDto> getPollSubList(PollDto poll) {
        return dao.getPollSubList(poll);
    }

    @Override
    public void polling(Voter voter) {
        dao.pollingVoter(voter);
        dao.pollingPoll(voter);
        dao.pollingSub(voter);
    }
}
