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

    <tiles:insertAttribute name="header"/> <!-- link 파일 (bootstrap, jquery) 모음으로 활용 가능 -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<div id="body_wrap">
    <div id="main_wrap">
        <tiles:insertAttribute name="top_inc"/>
        <tiles:insertAttribute name="top_menu"/>
    </div>
    <div id="middle_wrap">
        <div id="sidebar_wrap">
            <tiles:insertAttribute name="left_menu"/>
        </div>
        <div id="content_wrap">
            <div id="content_title_wrap">
                <div class="title">${doc_title}</div>
            </div>
            <tiles:insertAttribute name="main"/>
        </div>
    </div>
    <div id="footer_wrap">
        <tiles:insertAttribute name="bottom_inc"/>
    </div>
</div>

</body>
</html>
