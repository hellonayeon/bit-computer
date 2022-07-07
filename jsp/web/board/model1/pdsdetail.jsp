<%@ page import="bbs.model1.dao.PdsDao" %>
<%@ page import="bbs.model1.dto.PdsDto" %>
<%@ page import="bbs.model1.dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/07
  Time: 2:20 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object obj = session.getAttribute("login");
    if(obj == null){
%>
<script>
    alert('로그인 해 주십시오');
    location.href = "login.jsp";
</script>
<%
    }
    MemberDto mem = (MemberDto)obj;
%>

<html>
<head>
    <title>자료 상세 정보</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
</head>
<body>

<%
    int seq = Integer.parseInt(request.getParameter("seq"));

    PdsDao dao = PdsDao.getInstance();
    dao.upReadCount(seq);
    PdsDto pds = dao.getPds(seq);
%>
<%
    // 조회 수 증가
    // 쿠키 확인 (이미 글을 조회한 경우)

%>


<div align="center">
    <h2>자료 올리기</h2>

        <table border="1">
            <col width="200"><col width="500">

            <tr>
                <th>아이디</th>
                <td>
                    <%=mem.getId()%>
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <%=pds.getTitle()%>
                </td>
            </tr>
            <tr>
                <th>조회수</th>
                <td><%=pds.getReadCount()%></td>
            </tr>
            <tr>
                <th>다운수</th>
                <td><%=pds.getDownCount()%></td>
            </tr>
            <tr>
                <th>파일</th>
                <td>
                    <span><%=pds.getFilename()%></span> &nbsp;&nbsp;
                    <input type="button" name="btndown" value="다운로드"
                           onclick="filedownload('<%=pds.getNewFilename()%>', <%=pds.getSeq()%>)">
                </td>
            </tr>
            <tr>
                <th>등록일</th>
                <td>
                    <%=pds.getRegDate()%>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea rows="20" cols="50" name="content" readonly>
                        <%=pds.getContent()%>
                    </textarea>
                </td>
            </tr>

            <tr align="center">
                <td colspan="2">
                    <input type="submit" value="자료 올리기">
                </td>
            </tr>
        </table>
</div>

<script type="text/javascript" src="js/file-download.js"></script>
</body>
</html>
