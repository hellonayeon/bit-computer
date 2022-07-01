<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 11:05 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data</title>
</head>
<body>

<%
String name = "홍길동";
int age = 24;
String birth = "09/03/12";
String str = "{ \"name\":\"" + name + "\", \"age\":" + age + ", \"birth\":\"" + birth + "\"}";

out.println(str);

%>

</body>
</html>
