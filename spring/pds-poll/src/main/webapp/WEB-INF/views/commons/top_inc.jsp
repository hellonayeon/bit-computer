<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/14
  Time: 11:14 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 포맷 테그 -->

<%
Date nows = new Date();
request.setAttribute("_nows", nows);
%>

<div style="width: 100%; height: 53px; border-bottom: 1px solid #5E5E5E">
    <div style="width: 100%; height: 100%; clear:both; display: inline-block">
        <div id="_title_image" style="width: 30%; float: left; display: inline">
            <img alt="" src="<%=request.getContextPath()%>/image/titleimage.jpeg" style="height: 53px">
        </div>

        <div id="_title_today" style="width: 70%; float: left; text-align: right;">
            <div style="position: relative; top: 27px">
                <fmt:formatDate value="${_nows}" var="now" pattern="yyyy/MM/dd" />
                ${now}
            </div>
        </div>
    </div>

</div>
