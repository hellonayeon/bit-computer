<%@ page import="bbs.model1.dto.MemberDto" %>
<%@ page import="bbs.model1.dto.CalendarDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="bbs.model1.dao.CalendarDao" %>
<%@ page import="bbs.model1.util.CalUtil" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/06
  Time: 10:16 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = session.getAttribute("login");
    MemberDto mem = null;
    if(obj == null){
%>
<script>
    alert('로그인 해 주십시오');
    location.href = "login.jsp";
</script>
<%
    }
    mem = (MemberDto)obj;
%>
<%--
<%!
public boolean nvl(String msg) {
    return msg == null || msg.trim().equals("") ? true : false;
}

public String two(String msg) {
    return msg.trim().length() < 2 ? "0" + msg.trim() : msg.trim();
}

public String callist(int year, int month, int day) {
    String str = "";

    str += String.format("&nbsp;<a href='callist.jsp?year=%d&month=%d&day=%d'>",
                                                            year, month, day);
    str += String.format("%2d", day);
    str += "</a>";

    return str;
}

public String showPen(int year, int month, int day) {
    String str = "";

    String image = "<img src='image/pen2.png' width='18px' height='18px'>";
    str = String.format("<a href='calwrite.jsp?year=%d&month=%d&day=%d'>%s</a>",
                                                    year, month, day, image);

    return str;
}

public String dot3(String msg) {
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

public String makeTable(int year, int month, int day, List<CalendarDto> list) {
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

    return str;
}
%>
--%>
<html>
<head>
    <title>캘린더</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

<h2>일정 관리</h2>

<%
    Calendar cal = Calendar.getInstance();

    cal.set(Calendar.DATE, 1);

    String syear = request.getParameter("year");
    String smonth = request.getParameter("month");

    int year = cal.get(Calendar.YEAR);
    if ( CalUtil.nvl(syear) == false ) { // 파라미터로 넘어온 데이터가 있는 경우
        year = Integer.parseInt(syear);
    }

    int month = cal.get(Calendar.MONTH) + 1;
    if (CalUtil.nvl(smonth) == false) {
        month = Integer.parseInt(smonth);
    }

    if (month < 1) {
        month = 12;
        year--;
    }
    if (month > 12) {
        month = 1;
        year++;
    }

    cal.set(year, month - 1, 1);

    int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

    String pp = String.format("<a href='%s?year=%d&month=%d'>" +
            "                       <img src='image/left.gif' width='20px' height='20px'>" +
            "                  </a>", "calendar.jsp", year - 1, month);

    // month --
    String p = String.format("<a href='%s?year=%d&month=%d'>" +
            "                       <img src='image/prec.gif' width='20px' height='20px'>" +
            "                  </a>", "calendar.jsp", year, month - 1);

    // month ++
    String n = String.format("<a href='%s?year=%d&month=%d'>" +
            "                       <img src='image/next.gif' width='20px' height='20px'>" +
            "                  </a>", "calendar.jsp", year, month + 1);

    String nn = String.format("<a href='%s?year=%d&month=%d'>" +
            "                       <img src='image/last.gif' width='20px' height='20px'>" +
            "                  </a>", "calendar.jsp", year + 1, month);

    CalendarDao dao = CalendarDao.getInstance();

    List<CalendarDto> list = dao.getCalendarList(mem.getId(), year + CalUtil.two(month + ""));
%>

<div align="center">
    <table class="table table-bordered" style="width: 65%">
        <col width="100"><col width="100"><col width="100"><col width="100">
        <col width="100"><col width="100"><col width="100">

        <tr>
            <td colspan="7" align="center">
                <%=pp%>&nbsp;&nbsp;<%=p%>&nbsp;&nbsp;
                &nbsp;&nbsp;
                <font color="black" style="font-size: 50px; font-family: fantasy">
                    <%=String.format("%d년&nbsp;&nbsp;%d월", year, month)%>
                </font>
                &nbsp;&nbsp;
                <%=n%>&nbsp;&nbsp;<%=nn%>&nbsp;&nbsp;
            </td>
        </tr>

        <tr height="50" style="background-color: #F0F0F0; color: white;">
            <th class="text-center">일</th>
            <th class="text-center">월</th>
            <th class="text-center">화</th>
            <th class="text-center">수</th>
            <th class="text-center">목</th>
            <th class="text-center">금</th>
            <th class="text-center">토</th>
        </tr>

        <tr height="100" align="left" valign="top">
            <%
                for (int i=1; i<dayOfWeek; i++) {
            %>
                    <td style="background-color: #CECECE">&nbsp;</td>
            <%
                }
            %>

            <%

                int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                for (int i = 1; i<= lastday; i++) {
            %>
                    <td>
                        <%=CalUtil.callist(year, month, i)%>&nbsp;&nbsp;<%=CalUtil.showPen(year, month, i)%>
                        <%=CalUtil.makeTable(year, month, i, list)%>
                    </td>
            <%
                    if ((i + dayOfWeek - 1) % 7 == 0 && i != lastday) {
            %>
                    </tr>
                    <tr height="100px" align="left" >
            <%
                    }
                }

                // 밑쪽 빈칸
            cal.set(Calendar.DATE, lastday);
                int weekday = cal.get(Calendar.DAY_OF_WEEK);
                for (int i=0; i < 7 - weekday; i++) {
        %>
                    <td style="background-color: #CECECE">&nbsp;</td>
        <%
                }
            %>
        </tr>
    </table>
</div>

</body>
</html>
