package me.hellonayeon.poll.dto;

import java.io.Serializable;
import java.util.Date;

// 투표 질의 (투표 주제)
public class PollDto implements Serializable {

    private int pollId; // seq
    private String id; // 투표를 만든 사람
    private String question; // 주제: 좋아하는 과일은?
    private Date sDate; // 투표 시작일
    private Date eDate; // 투표 종료일
    private Date regDate; // 투표 만든날 (등록일자)
    private int itemCount; // 보기 (2 ~ 10)

    private int pollTotal; // 이 투표에 참여한 사람 수
    private boolean vote; // 중복 투표 확인 플래그 (로그인한 멤버가 이 투표에 이미 참여를 했는지?)

    public PollDto() {}

    public PollDto(int pollId, String id, String question, Date sDate, Date eDate,
        Date regDate, int itemCount, int pollTotal, boolean vote) {
        this.pollId = pollId;
        this.id = id;
        this.question = question;
        this.sDate = sDate;
        this.eDate = eDate;
        this.regDate = regDate;
        this.itemCount = itemCount;
        this.pollTotal = pollTotal;
        this.vote = vote;
    }

    public PollDto(String id, String question, Date sDate, Date eDate, int timeCount,
        int pollTotal) {
        this.id = id;
        this.question = question;
        this.sDate = sDate;
        this.eDate = eDate;
        this.itemCount = timeCount;
        this.pollTotal = pollTotal;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getSDate() {
        return sDate;
    }

    public Date getEDate() {
        return eDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setSDate(Date sDate) {
        this.sDate = sDate;
    }


    public void setEDate(Date eDate) {
        this.eDate = eDate;
    }


    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getPollTotal() {
        return pollTotal;
    }

    public void setPollTotal(int pollTotal) {
        this.pollTotal = pollTotal;
    }

    public boolean isVote() {
        return vote;
    }

    public void setVote(boolean vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "PollDto{" +
            "pollId=" + pollId +
            ", id='" + id + '\'' +
            ", question='" + question + '\'' +
            ", sDate=" + sDate +
            ", eDate=" + eDate +
            ", regDate=" + regDate +
            ", itemCount=" + itemCount +
            ", pollTotal=" + pollTotal +
            ", vote=" + vote +
            '}';
    }
}
