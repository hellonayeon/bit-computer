<%@ page import="login.dao.MemberDao" %>
<%@ page import="login.dto.MemberDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String name = request.getParameter("name");
    String email = request.getParameter("email");
%>

<%
MemberDao dao = MemberDao.getInstance();

MemberDto dto = new MemberDto(id, pwd, name, email, 0);

boolean isS = dao.addMember(dto);
if (isS) {
%>
<script type="text/javascript">
    alert("성공적으로 가입되었습니다 :D");
    location.href = "login.jsp";
</script>
<%
} else {
%>
    <script type="text/javascript">
        alert("다시 기입해주십시오 :<");
        location.href = "regi.jsp";
    </script>
<%
}
%>
