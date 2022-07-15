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
}
