<%@ page import="login.bbs.model1.dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/05
  Time: 10:26 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = session.getAttribute("login");
    MemberDto mem = null;

    if (obj == null) {
%>

<script>
    alert("로그인 해주세요 :<");
    location.href = "login.jsp";
</script>
<%
    }
    mem = (MemberDto) obj;
%>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
    <table border="1">
        <tr>
            <th>아이디</th>
            <td>
                <input type="text" name="id" size="50px"
                       value="<%=mem.getId()%>" readonly="readonly">
            </td>
        </tr>
        <tr>
            <th>제목</th>
            <td>
                <input type="text" name="title" size="50px">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
                <textarea rows="20" cols="50px" name="content"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input typ>

            </td>
        </tr>
    </table>
</div>

</body>
</html>
