<%@ page import="me.hellonayeon.poll.dto.PollDto" %>
<%@ page import="me.hellonayeon.poll.dto.PollSubDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/15
  Time: 3:21 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Poll Detail</title>
</head>
<body>

<%
    String id = (String) request.getSession().getAttribute("loginId");

    PollDto poll = (PollDto) request.getAttribute("poll");
    List<PollSubDto> pollSubList = (List<PollSubDto>) request.getAttribute("pollSubList");
%>

<form action="polling" method="GET">
    <table class="list_table">
        <col width="200"><col width="200">

        <tr>
            <th>투표 번호</th>
            <td style="text-align: left;">
                <%=poll.getPollId()%>
                <input type="hidden" name="pollId" value="<%=poll.getPollId()%>">
            </td>
        </tr>
        <tr>
            <th>아이디</th>
            <td style="text-align: left;">
                <%=id%>
                <input type="hidden" name="id" value="<%=id%>">
            </td>
        </tr>
        <tr>
            <th>투표 기한</th>
            <td style="text-align: left;">
                <%=poll.getSDate()%> ~ <%=poll.getEDate()%>
            </td>
        </tr>
        <tr>
            <th>투표 내용</th>
            <td style="text-align: left;">
                <textarea rows="10" cols="50" name="question"><%=poll.getQuestion()%></textarea>
            </td>
        </tr>
        <tr>
            <th>보기 수</th>
            <td style="text-align: left;"><%=poll.getItemCount()%></td>
        </tr>
        <tr>
            <th>투표 항목</th>
            <td style="text-align: left;">
            <%
                for (int i=0; i<pollSubList.size(); i++) {
                    PollSubDto pollSub = pollSubList.get(i);
            %>
                    <%=i + 1%>번 &nbsp;
                    <input type="radio" name="pollSubId" <%= (i == 0) ? "checked='checked'" : "" %>
                            value="<%=pollSub.getPollSubId()%>">
                    <input type="text" name="answer" size="60" value="<%=pollSub.getAnswer()%>" readonly><br><br>
            <%
                }
            %>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="투표하기">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
