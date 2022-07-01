<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 9:40 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Default JSP</title>
</head>
<body>

<h2>Default JSP</h2>

<%
    String animal = (String) request.getAttribute("animal");
    String human = (String) session.getAttribute("human");
%>

<p><%=animal%></p>
<p><%=human%></p>

</body>
</html>
