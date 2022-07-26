package me.hellonayeon.poll.dao;

import java.util.List;
import me.hellonayeon.poll.dto.PollDto;
import me.hellonayeon.poll.dto.PollSubDto;
import me.hellonayeon.poll.dto.Voter;

public interface PollDao {

    List<PollDto> getPollList();
    int isVoter(Voter voter);

    void makePoll(PollDto poll); // 투표 항목
    void makePollSub(PollSubDto pollSub); // 보기

    PollDto getPoll(PollDto poll);
    List<PollSubDto> getPollSubList(PollDto poll);


    // 투표자 추가
    void pollingVoter(Voter voter);

    // 투표 주제에 카운터를 증가
    void pollingPoll(Voter voter);

    // 투표 보기에 카운터를 증가
    void pollingSub(Voter voter);
}
