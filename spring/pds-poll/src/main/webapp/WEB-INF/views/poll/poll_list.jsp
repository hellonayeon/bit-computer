<%@ page import="me.hellonayeon.poll.dto.PollDto" %>
<%@ page import="java.util.List" %>
<%@ page import="me.hellonayeon.poll.util.PollUtil" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/15
  Time: 11:23 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Poll List</title>
</head>
<body>

<%
    List<PollDto> plist = (List<PollDto>) request.getAttribute("plist");
%>

<table class="list_table" style="width: 95%">
    <col width="50"><col width="50"><col width="300"><col width="100">
    <col width="100"><col width="100"><col width="50"><col width="50">
    <col width="100">

    <tr>
        <th>번호</th><th>아이디</th><th>투표제목</th><th>결과</th>
        <th>시작일</th><th>종료일</th><th>보기수</th><th>투표 횟수</th>
        <th>등록일</th>
    </tr>

    <%
        for (int i=0; i < plist.size(); i++) {
            PollDto poll = plist.get(i);
    %>
            <tr bgcolor="#AABBCC">
                <td><%=i+1%></td>
                <td><%=poll.getId()%></td>
            <%
                boolean isS = poll.isVote();

                // 투표 했음: 투표를 못하게 한다.
                if (isS || PollUtil.isEnd(poll.getEDate())) {
            %>
                    <td>[마감] <%=poll.getQuestion()%></td>
            <%
                }

                // 투표 안했음
                else {
            %>
                    <td>
                        <a href="polldetail.do?pollId=<%=poll.getPollId()%>">
                            <%=poll.getQuestion()%>
                        </a>
                    </td>
            <%
                }
            %>

                    <td>
                    <%
                        if (isS || PollUtil.isEnd(poll.getEDate())) {
                    %>
                            <a href="pollresult.do?pollId=<%=poll.getPollId()%>">
                                결과
                            </a>
                    <%
                        }
                        else {
                    %>
                            <img alt="" src="image/pen.gif">

                    <%
                        }
                    %>
                    </td>

                <td><%=poll.getSDate()%></td>
                <td><%=poll.getEDate()%></td>
                <td><%=poll.getItemCount()%></td>
                <td><%=poll.getPollTotal()%></td>
                <td><%=poll.getRegDate()%></td>


            </tr>
    <%

        }

    %>

</table>

</body>
</html>
