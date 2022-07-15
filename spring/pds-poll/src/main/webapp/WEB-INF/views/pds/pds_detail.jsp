<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/14
  Time: 5:05 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="me.hellonayeon.pds.dto.PdsDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    PdsDto pds = (PdsDto) request.getAttribute("pds");
%>
<html>
<head>
    <title>PDS Detail</title>
</head>
<body>


<table class="list_table" style="width: 85%">
    <col width="200"><col width="500">

    <tr>
        <th>아이디</th>
        <td style="text-align: left;">
            <input type="text" name="id" value="<%=pds.getId()%>" size="50" readonly>
        </td>
    </tr>
    <tr>
        <th>제목</th>
        <td style="text-align: left;">
            <input type="text" name="title" value="<%=pds.getTitle()%>" size="50" readonly>
        </td>
    </tr>
    <tr>
        <th>파일 다운로드</th>
        <td style="text-align: left;">
            <span><%=pds.getFilename()%></span> &nbsp; &nbsp;
            <input type="button" name="btndown" value="다운로드"
                   onclick="filedownload('<%=pds.getNewfilename()%>', <%=pds.getSeq() %>, '<<%=pds.getFilename()%>')">
        </td>
    </tr>
    <tr>
        <th>내용</th>
        <td style="text-align: left;">
            <textarea rows="10" cols="50" name="content" readonly>
                <%=pds.getContent()%>
            </textarea>
        </td>
    </tr>

    <tr align="center">
        <td colspan="2">
            <button type="button">자료 리스트로 돌아가기</button>
        </td>
    </tr>
</table>


<script>

  $("button").click(function (){
    location.href="pdslist.do";
  });

  function filedownload(newfilename, seq, filename) {
    location.href = "filedownload.do?newfilename=" + newfilename + "&seq=" + seq + "&filename=" + filename;

  }
</script>

</body>
</html>

