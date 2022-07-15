<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/13
  Time: 2:13 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    String process = (String) request.getAttribute("process");

%>

<%
    if (process.equals("login")) {
        boolean b = (Boolean) request.getAttribute("msg");
        if (b) {
%>
            <script type="text/javascript">
                alert("회원 가입을 축하합니다 !");
                location.href = "login.do";
            </script>
<%
        }
        else {
%>
            <script type="text/javascript">
              alert("다시 가입해 주십시오 !");
              location.href = "regi.do";
            </script>
<%
        }
    }
%>

</body>
</html>
