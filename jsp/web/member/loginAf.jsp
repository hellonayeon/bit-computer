<%@ page import="login.dao.MemberDao" %>
<%@ page import="login.dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 5:18 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String id = request.getParameter("id");
  String pwd = request.getParameter("pwd");

  MemberDao dao = MemberDao.getInstance();
  MemberDto dto = dao.findById(id);

  if (dto == null) {
%>
  <script type="text/javascript">
      alert("아이디를 확인해주세요 :<");
  </script>
<%
  }
  else {
      // 아이디에 해당되는 멤버 찾았고,
      // 비밀번호도 일치하는 경우
      if (dto.getPwd().equals(pwd)) {
%>

          <script type="text/javascript">
              alert("로그인 성공 !!");
          </script>

<%
      }
      else {
%>
          <script type="text/javascript">
            alert("비밀번호를 확인해주세요 :<");
          </script>
<%
      }
  }
%>
