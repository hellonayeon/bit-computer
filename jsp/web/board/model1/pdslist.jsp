<%@ page import="bbs.model1.dao.PdsDao" %>
<%@ page import="bbs.model1.dto.PdsDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/07
  Time: 9:47 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PdsDao dao = PdsDao.getInstance();
    List<PdsDto> list = dao.getPdsList();

%>
<html>
<head>
    <title>자료실</title>
</head>
<body>

<div align="center">
<h2>자료실</h2>

<table border="1">
    <col width="50"><col width="100"><col width="400"><col width="50">
    <col width="50"><col width="50"><col width="100">

    <tr>
        <th>번호</th><th>작성자</th><th>제목</th><th>다운로드</th>
        <th>조회수</th><th>다운수</th><th>작성일</th>
    </tr>

    <%
        for (int i=0; i<list.size(); i++) {
            PdsDto pds = list.get(i);
    %>
    <tr>
        <th><%=i+1%></th>
        <td><%=pds.getId()%></td>
        <td>
            <a href="pdsdetail.jsp?seq=<%=pds.getSeq()%>">
                <%=pds.getTitle()%>
            </a>
        </td>
        <td>
            <input type="button" name="btndown" value="다운로드"
                   onclick="filedownload('<%=pds.getNewFilename()%>', <%=pds.getSeq()%>)">
        </td>
        <td><%=pds.getReadCount()%></td>
        <td><%=pds.getDownCount()%></td>
        <td><%=pds.getRegDate()%></td>
    </tr>
    <%
        }
    %>

</table>
    <br><br>
    <a href="pdswrite.jsp">자료 올리기</a>

</div>

<script type="text/javascript" src="js/file-download.js"></script>
</body>
</html>
