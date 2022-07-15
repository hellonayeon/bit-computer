package me.hellonayeon.poll.dto;

public class PollSubDto {

    private int pollSubId; // seq

    private int pollId; // 투표 주제 (외래키)

    private String answer; // 보기명 (사과 배 바나나)

    private int aCount; // 이 보기를 선택한 사람 수


    public PollSubDto() { }

    public PollSubDto(int pollSubId, int pollId, String answer, int aCount) {
        this.pollSubId = pollSubId;
        this.pollId = pollId;
        this.answer = answer;
        this.aCount = aCount;
    }

    public int getPollSubId() {
        return pollSubId;
    }

    public void setPollSubId(int pollSubId) {
        this.pollSubId = pollSubId;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getaCount() {
        return aCount;
    }

    public void setaCount(int aCount) {
        this.aCount = aCount;
    }
}
