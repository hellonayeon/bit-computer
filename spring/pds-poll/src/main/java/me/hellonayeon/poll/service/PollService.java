package me.hellonayeon.poll.service;

import java.util.List;
import me.hellonayeon.poll.dto.PollBean;
import me.hellonayeon.poll.dto.PollDto;
import me.hellonayeon.poll.dto.PollSubDto;
import me.hellonayeon.poll.dto.Voter;

public interface PollService {

    List<PollDto> getPollList(String id);
    void makePoll(PollBean bean);

    PollDto getPoll(PollDto poll);
    List<PollSubDto> getPollSubList(PollDto poll);

    void polling(Voter voter);

}
