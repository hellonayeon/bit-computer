package me.hellonayeon.poll.dto;

import java.util.Date;

// 투표자
public class Voter {

    private int voterId; // seq

    private int pollId; // 질문

    private int pollSubId; // 보기

    private String id; // 누가

    private Date regDate; // 언제


    public Voter() {}

    public Voter(int voterId, int pollId, int pollSubId, String id, Date regDate) {
        this.voterId = voterId;
        this.pollId = pollId;
        this.pollSubId = pollSubId;
        this.id = id;
        this.regDate = regDate;
    }

    public Voter(int pollId, String id) {
        this.pollId = pollId;
        this.id = id;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public int getPollSubId() {
        return pollSubId;
    }

    public void setPollSubId(int pollSubId) {
        this.pollSubId = pollSubId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
