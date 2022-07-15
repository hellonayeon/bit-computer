<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/14
  Time: 9:38 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<head>
    <title>Apache Tiles (layouts-titles)</title>
</head>
<body>

<table width="100%" height="100%" bordercolor="gray">

<!-- header -->
<tr align="center" style="background-color: black; color: white;">
    <td height="10%" colspan="3">
        <tiles:insertAttribute name="header"/> <!-- 헤더에 접근할 때 필요한 이름 -->
    </td>
</tr>

<!-- menu main -->
<tr>
    <td width="20%" align="left" valign="top" style="background-color: rgb(204, 204, 204)">
        <tiles:insertAttribute name="menu"/>
    </td>
    <td>
        <tiles:insertAttribute name="content"/>
    </td>
    <td width="15%" align="center">
        <tiles:insertAttribute name="empty"/>
    </td>
</tr>

<!-- footer -->
<tr align="center" style="background-color: black; color: white;">
    <td height="10%" colspan="3">
        <tiles:insertAttribute name="footer"/>
    </td>
</tr>

</table>

</body>
</html>
