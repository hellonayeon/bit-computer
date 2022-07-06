<%@ page import="bbs.model1.util.CalUtil" %>
<%@ page import="bbs.model1.dao.CalendarDao" %>
<%@ page import="bbs.model1.dto.CalendarDto" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/06
  Time: 2:08 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");

    String id = request.getParameter("id");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
    String hour = request.getParameter("hour");
    String min = request.getParameter("min");

    // 202207061230
    String rdate = year + CalUtil.two(month) + CalUtil.two(day) + CalUtil.two(hour) + CalUtil.two(min);
%>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<%
    CalendarDao dao = CalendarDao.getInstance();

    boolean isS = dao.addCalendar(new CalendarDto(id, title, content, rdate));
    if (isS) {
%>
        <script type="text/javascript">
            alert('일정이 추가되었습니다');
            location.href = "calendar.jsp";
        </script>
<%
    }
    else {
%>
        <script type="text/javascript">
            alert("일정이 추가되지 않았습니다");
            location.href = "calendar.jsp";
        </script>
<%
    }
%>

</body>
</html>