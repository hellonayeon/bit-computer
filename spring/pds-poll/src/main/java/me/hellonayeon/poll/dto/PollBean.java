package me.hellonayeon.poll.dto;

import java.util.Date;
import me.hellonayeon.poll.util.PollUtil;

// 투표 생성 시에 투표에 대한 정보를 전송하는 클래스
public class PollBean {

    private String id; // 투표를 만든 사람

    private int sYear; // 시작일
    private int sMonth;
    private int sDay;

    private int eYear; // 종료일
    private int eMonth;
    private int eDay;

    private Date sDate; // 시작 종료일의 묶음
    private Date eDate;

    private String question; // 투표 '주제' (질문)
    private int itemCount; // 보기 개수

    // 보기들
    private String poll1;
    private String poll2;
    private String poll3;
    private String poll4;
    private String poll5;
    private String poll6;
    private String poll7;
    private String poll8;
    private String poll9;
    private String poll10;

    private String[] pollNum = new String[10];


    // 보기 묶음
    public String[] getPollNum() {
        pollNum[0] = poll1;
        pollNum[1] = poll2;
        pollNum[2] = poll3;
        pollNum[3] = poll4;
        pollNum[4] = poll5;
        pollNum[5] = poll6;
        pollNum[6] = poll7;
        pollNum[7] = poll8;
        pollNum[8] = poll9;
        pollNum[9] = poll10;


        return pollNum;
    }

    public PollBean() {

    }

    public String getId() {
        return id;
    }

    public int getSYear() {
        return sYear;
    }

    public int getSMonth() {
        return sMonth;
    }

    public int getSDay() {
        return sDay;
    }

    public int getEYear() {
        return eYear;
    }

    public int getEMonth() {
        return eMonth;
    }

    public int getEDay() {
        return eDay;
    }

    public Date getSDate() {
        return PollUtil.toDate(sYear, sMonth, sDay);
    }

    public Date getEDate() {
        return PollUtil.toDate(eYear, eMonth, eDay);
    }

    public String getQuestion() {
        return question;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setsYear(int sYear) {
        this.sYear = sYear;
    }

    public void setsMonth(int sMonth) {
        this.sMonth = sMonth;
    }

    public void setsDay(int sDay) {
        this.sDay = sDay;
    }

    public void seteYear(int eYear) {
        this.eYear = eYear;
    }

    public void seteMonth(int eMonth) {
        this.eMonth = eMonth;
    }

    public void seteDay(int eDay) {
        this.eDay = eDay;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public void seteDate(Date eDate) {
        this.eDate = eDate;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public void setPoll1(String poll1) {
        this.poll1 = poll1;
    }

    public void setPoll2(String poll2) {
        this.poll2 = poll2;
    }

    public void setPoll3(String poll3) {
        this.poll3 = poll3;
    }

    public void setPoll4(String poll4) {
        this.poll4 = poll4;
    }

    public void setPoll5(String poll5) {
        this.poll5 = poll5;
    }

    public void setPoll6(String poll6) {
        this.poll6 = poll6;
    }

    public void setPoll7(String poll7) {
        this.poll7 = poll7;
    }

    public void setPoll8(String poll8) {
        this.poll8 = poll8;
    }

    public void setPoll9(String poll9) {
        this.poll9 = poll9;
    }

    public void setPoll10(String poll10) {
        this.poll10 = poll10;
    }
}
