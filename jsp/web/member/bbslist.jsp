<%@ page import="login.dto.MemberDto" %>
<%@ page import="login.dto.BbsDto" %>
<%@ page import="java.util.List" %>
<%@ page import="login.dao.BbsDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
Object obj = session.getAttribute("login");
MemberDto mem = null;

if (obj == null) {
%>

    <script>
        alert("로그인 해주세요 :<");
        location.href = "login.jsp";
    </script>
<%
}
mem = (MemberDto) obj;

    String choice = request.getParameter("choice");
    String search = request.getParameter("search");

    if (choice == null) {
        choice = "";
    }
    if (search == null) {
        search = "";
    }

BbsDao dao = BbsDao.getInstance();
List<BbsDto> list = dao.getBbsSearchlist(choice, search);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h2>게시판</h2>

<div align="center">

<table border="1">
    <col width="70"><col width="600"><col width="100"><col width="150">
    <tr>
        <th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
    </tr>

<%
    if (list == null || list.size() == 0) {
%>
    <tr>
        <td colspan="4">작성된 글이 없습니다.</td>
    </tr>
<%
    } else {

        for (int i=0; i<list.size(); i++) {
            BbsDto bbs = list.get(i);
%>
            <tr>
                <th><%=i + 1%></th>
                <td><a href="bbsdetail.jsp?seq=<%=bbs.getSeq()%>"><%=bbs.getTitle()%></a></td>
                <td><%=bbs.getReadcount()%></td>
                <td><%=bbs.getId()%></td>
            </tr>
<%
        }
    }
%>

</table>

<br><br>

    <select id="choice">
        <option>검색</option>
        <option value="title">제목</option>
        <option value="content">내용</option>
        <option value="writer">작성자</option>
    </select>

    <input type="text" id="search" value="">
    <button type="button" onclick="searchBtn()">검색</button>
</div>

<a href="bbswrite.jsp">글쓰기</a>

<script type="text/javascript">
    function searchBtn() {
        let choice = document.getElementById("choice").value;
        let search = document.getElementById("search").value;

        // if (search.trim() == '') {
        //     alert("검색어를 입력해 주십시오");
        //     return;
        // }

        location.href = "bbslist.jsp?choice=" + choice + "&search=" + search;
    }
</script>
</body>
</html>