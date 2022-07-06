package bbs.model1.util;

import bbs.model1.dto.CalendarDto;

import java.util.List;

public class CalUtil {

    public static boolean nvl(String msg) {
        return msg == null || msg.trim().equals("") ? true : false;
    }

    public static String two(String msg) {
        return msg.trim().length() < 2 ? "0" + msg.trim() : msg.trim();
    }

    public static String callist(int year, int month, int day) {
        String str = "";

        str += String.format("&nbsp;<a href='callist.jsp?year=%d&month=%d&day=%d'>",
                year, month, day);
        str += String.format("%2d", day);
        str += "</a>";

        return str;
    }

    public static String showPen(int year, int month, int day) {
        String str = "";

        String image = "<img src='image/pen2.png' width='18px' height='18px'>";
        str = String.format("<a href='calwrite.jsp?year=%d&month=%d&day=%d'>%s</a>",
                year, month, day, image);

        return str;
    }

    public static String dot3(String msg) {
        String str = "";

        if (msg.length() >= 10) {
            str = msg.substring(0, 10);
            str += "...";
        }
        else {
            str = msg.trim();
        }

        return str;
    }

    public static String makeTable(int year, int month, int day, List<CalendarDto> list) {
        String str = "";

        String dates = (year + "") + two(month + "") + two(day + "");

        str += "<table>";
        for (CalendarDto dto : list) {
            if (dto.getRdate().substring(0, 8).equals(dates)) {
                str += "<tr>";
                str += "    <td style='padding:0px; border:1; background-color:white; border-color:blue; radius: 3'>";
                str += "        <a href='caldetail.jsp?seq=" + dto.getSeq() +  "'>";
                str += "            <font style='font-size:10px'>";
                str +=                  dot3(dto.getTitle());
                str += "            </font>";
                str += "    </td>";
                str += "</tr>";
            }
        }
        str += "</table>";


        return str;
    }

}
