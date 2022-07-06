<%@ page import="bbs.model1.dto.MemberDto" %>
<%@ page import="bbs.model1.dao.CalendarDao" %>
<%@ page import="bbs.model1.dto.CalendarDto" %>
<%@ page import="java.util.List" %>
<%@ page import="bbs.model1.util.CalUtil" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/06
  Time: 3:25 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
%>
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
<%
    CalendarDao dao = CalendarDao.getInstance();

    List<CalendarDto> list = dao.getDayCalendarList(mem.getId(), year, month, day);
%>
<html>
<head>
    <title>일정 리스트</title>
</head>
<body>

<div align="center">
    <h3><%=String.format("%s님의 %s년 %s월 %s일", mem.getId(), year, CalUtil.two(month), CalUtil.two(day))%> 일정 리스트</h3>


    <table border="1">
        <col width="50"><col width="500"><col width="150">

        <tr>
            <th>번호</th><th>일정</th><th>시간</th>
        </tr>

        <%
            for (int i=0; i<list.size(); i++) {
                CalendarDto dto = list.get(i);

                int seq = dto.getSeq();
                String title = dto.getTitle();

                String rdate = dto.getRdate();
                String hour = rdate.substring(8, 10);
                String min = rdate.substring(10, 12);
        %>

            <tr>
                <th><%=i+1%></th>
                <td><a href="caldetail.jsp?seq=<%=seq%>"><%=title%></a></td>
                <td><%=String.format("%s시 %s분", hour, min)%></td>
            </tr>

        <%
            }
        %>
    </table>
</div>

</body>
</html>
