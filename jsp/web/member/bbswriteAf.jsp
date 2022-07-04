<%@ page import="login.dto.BbsDto" %>
<%@ page import="login.dao.BbsDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    String title = request.getParameter("title");
    String content = request.getParameter("content");

    BbsDto dto = new BbsDto(id, title, content);

    BbsDao dao = BbsDao.getInstance();
    boolean isSuccess = dao.writeBbs(dto);

    if (isSuccess) {
%>
        <script type="text/javascript">
            alert("성공적으로 글이 등록됐습니다 :>");
            location.href = "bbslist.jsp";
        </script>
<%
    }
    else {
%>
        <script type="text/javascript">
            alert("글 등록을 실패했습니다 :<");
            location.href = "bbswrite.jsp";
        </script>
<%
    }
%>
<html>
<head>
    <title>게시판</title>
</head>
<body>

</body>
</html>
