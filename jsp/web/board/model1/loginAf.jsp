<%@ page import="bbs.model1.dao.MemberDao" %>
<%@ page import="bbs.model1.dto.MemberDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
MemberDao dao = MemberDao.getInstance();

MemberDto mem = dao.login(new MemberDto(id, pwd, null, null, 0));

if(mem != null && !mem.getId().equals("")){
	
	session.setAttribute("login", mem);
	session.setMaxInactiveInterval(60 * 60 * 2);
	%>
	<script type="text/javascript">
	alert("안녕하세요. <%=mem.getName() %>님");
	location.href = "bbslist.jsp";
	//location.href = "bbslistCSS.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("아이디나 패스워드를 찾을 수 없습니다");
	location.href = "login.jsp";
	</script>
	<%
}
%>


</body>
</html>








