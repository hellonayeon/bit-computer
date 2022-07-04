<%@ page import="login.dto.MemberDto" %>
<%@ page import="login.dto.BbsDto" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/04
  Time: 10:42 오전
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
    <title>게시판</title>
</head>
<body>
<div align="center">
    <h2>게시판 글쓰기</h2>

    <table border="1">
            <tr>
                <td>회원 ID</td>
                <td><%=mem.getId()%></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" id="input-title"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea cols="20" rows="10" id="textarea-content"></textarea></td>
            </tr>
    </table>
    <button onclick="writeBbs()">글쓰기</button>


</div>

<script type="text/javascript">
    function writeBbs() {
        let title = document.getElementById("input-title").value;
        let content = document.getElementById("textarea-content").value;

        console.log(title + " " + content);

        if (isTitleBlank(title)) {
            alert("제목을 입력해주세요 :<");
            return;
        }

        if (isContentBlank(content)) {
            alert("내용을 입력해주세요 :<");
            return;
        }

        location.href = "bbswriteAf.jsp?id=<%=mem.getId()%>" + "&title=" + title + "&content=" + content;
    }

    function isTitleBlank(title) {
        return title.trim() == "";
    }

    function isContentBlank(content) {
        return content.trim() == "";
    }
</script>

</body>
</html>