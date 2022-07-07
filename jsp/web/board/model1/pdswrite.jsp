<%@ page import="bbs.model1.dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/07
  Time: 10:18 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Object obj = session.getAttribute("login");
    MemberDto mem = null;
    if (obj == null) {
%>
<script>
    alert('로그인 해 주십시오');
    location.href = "login.jsp";
</script>
<%
    }
    mem = (MemberDto) obj;
%>

<html>
<head>
    <title>자료 올리기</title>
</head>
<body>

<div align="center">
    <h2>자료 올리기</h2>

    <form action="pdsupload.jsp" method="post" enctype="multipart/form-data">
        <table border="1">
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
                    <input type="text" name="title" size="50">
                </td>
            </tr>
            <tr>
                <th>파일 업로드</th>
                <td>
                    <input type="file" name="fileload" style="width: 400px">
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea rows="20" cols="50" name="content"></textarea>
                </td>
            </tr>

            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="자료 올리기">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
