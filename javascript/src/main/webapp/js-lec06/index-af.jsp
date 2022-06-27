<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/06/27
  Time: 10:26 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String name = (String) request.getParameter("name");
    Integer age = Integer.parseInt(request.getParameter("age"));

    System.out.println("name:" + name + " age:" + age);
%>


</body>
</html>
