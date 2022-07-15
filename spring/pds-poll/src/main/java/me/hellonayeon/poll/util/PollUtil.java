package me.hellonayeon.poll.util;

import java.util.Calendar;
import java.util.Date;

public class PollUtil {

    // 달력의 날짜를 20220715 형식으로 만들기
    // 5 -> 05
    public static String two(String msg) {
        return msg.trim().length() < 2 ? "0" + msg.trim() : msg.trim();
    }

    public static String replaceDate(Calendar dd) {
        String s = "";

        int year = dd.get(Calendar.YEAR);
        int month = dd.get(Calendar.MONTH);
        int day = dd.get(Calendar.DATE);

        return year + ""
            + PollUtil.two(Integer.toString(month))
            + PollUtil.two(Integer.toString(day));
    }

    // 년월일을 비교. 종료된 투표인지 체크
    public static boolean isEnd(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        Calendar now = Calendar.getInstance();

        return Integer.parseInt(replaceDate(now)) > Integer.parseInt(replaceDate(c));
    }

    // 투표 종료 판정
    public static String pollState(Date d) {

        String s1 = "<div style='color:RED'>[종료]</div>";
        String s2 = "<div style='color:BLUE'>[진행중]</div>";

        return isEnd(d) ? s1: s2;
    }

    public static java.sql.Date toDate(int year, int month, int day) {
        String s = year + "-" + two(month + "") + "-" + two(day + "");
        return java.sql.Date.valueOf(s);
    }
}
