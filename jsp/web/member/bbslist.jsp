<%@ page import="login.dto.MemberDto" %>
<%@ page import="login.dto.BbsDto" %>
<%@ page import="java.util.List" %>
<%@ page import="login.dao.BbsDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

   // 페이지 번호, 리스트 가져올 때 페이지에 해당되는 내용을 가져오기 위해
    String sPageNumber = request.getParameter("pageNumber");
    int pageNumber = 0;
    if (sPageNumber != null && !sPageNumber.equals("")) {
        pageNumber = Integer.parseInt(sPageNumber);
    }

//    List<BbsDto> list = dao.getBbslist();
//    List<BbsDto> list = dao.getBbsSearchlist(choice, search);
    List<BbsDto> list = dao.getBbsPagelist(choice, search, pageNumber);

    int len = dao.getAllBbs(choice, search);

    int bbsPage = len / 10;
    if ((len % 10) > 0) {
        bbsPage += 1;
    }
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
        <col width="70">
        <col width="600">
        <col width="100">
        <col width="150">
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>조회수</th>
            <th>작성자</th>
        </tr>

        <%
            if (list == null || list.size() == 0) {
        %>
        <tr>
            <td colspan="4">작성된 글이 없습니다.</td>
        </tr>
        <%
        } else {

            for (int i = 0; i < list.size(); i++) {
                BbsDto bbs = list.get(i);
        %>
        <tr>
            <th><%=i + 1%>
            </th>
            <td><a href="bbsdetail.jsp?seq=<%=bbs.getSeq()%>"><%=bbs.getTitle()%>
            </a></td>
            <td><%=bbs.getReadcount()%>
            </td>
            <td><%=bbs.getId()%>
            </td>
        </tr>
        <%
                }
            }
        %>

    </table>

    <br><br>

    <%
        for (int i=0; i< bbsPage; i++) {
            // 현재 페이지
            if (pageNumber == i) {
    %>
                <span style="font-size: 15pt; color: #0000ff; font-weight: bold;">
                    <%=i+1%>
                </span>
    <%
            }
            // 그 밖의 페이지
            else {
    %>
                <a href="#none" title="<%=i+1%> 페이지" onclick="goPage(<%=i%>) "
                    style="font-size: 15pt; color: #000; font-weight: bold; text-decoration: none;">
                    [<%=i + 1%>]
                </a>
    <%
            }
        }
    %>

    <br><br>

    <select id="choice">
        <option>검색</option>
        <option value="title">제목</option>
        <option value="content">내용</option>
        <option value="writer">작성자</option>
    </select>

    <input type="text" id="search" value="<%=search%>">
    <button type="button" onclick="searchBtn()">검색</button>


</div>

<a href="bbswrite.jsp">글쓰기</a>

<script type="text/javascript">
    let search = "<%=search%>";
    if (search != "") {
        let obj = document.getElementById("choice");
        obj.value = "<%=choice%>";
        obj.setAttribute("selected", "selected");
    }
</script>

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

    function goPage( pageNumber ) {
        let choice = document.getElementById("choice").value;
        let search = document.getElementById("search").value;

        location.href = "bbslist.jsp?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNumber;


    }
</script>
</body>
</html>