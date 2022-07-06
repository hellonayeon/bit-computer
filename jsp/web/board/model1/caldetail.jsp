<%@ page import="bbs.model1.dto.MemberDto" %>
<%@ page import="bbs.model1.dao.CalendarDao" %>
<%@ page import="bbs.model1.dto.CalendarDto" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/06
  Time: 2:46 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String sseq = request.getParameter("seq");

    CalendarDao dao = CalendarDao.getInstance();
    CalendarDto dto = dao.getCalendar(Integer.parseInt(sseq));

    String rdate = dto.getRdate();
    String year = rdate.substring(0, 4);
    String month = rdate.substring(4, 6);
    String day = rdate.substring(6, 8);
    String hour = rdate.substring(8, 10);
    String min = rdate.substring(10, 12);
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
<html>
<head>
    <title>일정 상세</title>
</head>
<body>
<div align="center">

    <input type="date"> &nbsp; <input type="time">

    <form action="calwriteAf.jsp" method="post">

        <table class="table table-bordered" style="width: 65%">
            <col width="200"><col width="500">
            <tr>
                <th>아이디</th>
                <td>
                    <%=mem.getId()%>
                    <input type="hidden" name="id" value="<%=mem.getId()%>">
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <%=dto.getTitle()%>
                </td>
            </tr>
            <tr>
                <th>일정</th>
                <td>
                    <%=year%>년 &nbsp; <%=month%>월 &nbsp; <%=day%>일 &nbsp;
                    <%=hour%>시 &nbsp; <%=min%>분
                </td>

            <tr>
                <th>내용</th>
                <td>
                    <textarea row="20" cols="60" name="content" readonly>
                        <%=dto.getContent()%>
                    </textarea>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
