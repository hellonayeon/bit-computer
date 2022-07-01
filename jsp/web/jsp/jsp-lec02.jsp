<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 9:13 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    // 내장객체 (암시): 동적으로 생성하지 않고 (언제든지 바로) 사용할 수 있는 객체
    // JSP
    // out            : java 코드 -> web 으로 반영 =
    String title = "제목입니다.";

    out.println("<h2>" + title + "</h2>");
%>

<%

    // request (요청)  : parameter 취득. session 취득. Object 전송, 취득, encoding 설정
    // HttpServletRequest
    request.setCharacterEncoding("utf-8");

    request.getSession().setAttribute("member", "hello");
    Object obj = request.getSession().getAttribute("member");
    String str = (String) obj;


    String name = request.getParameter("name");
    String age = request.getParameter("age");

    String[] hobby = request.getParameterValues("hobby");
%>

<h3>name: <%=name%></h3>
<h3>age: <%=age%></h3>

<%--<%--%>
<%--    for (int i=0; i<hobby.length; i++) {--%>
<%--%>--%>
<%--        <h3>취미(<%=i+1%>): <%=hobby[i]%></h3>--%>
<%--<%--%>
<%--    }--%>
<%--%>--%>

<%

    request.setAttribute("animal", "dog");

    // session        : server 저장
    // HttpSession
    session.setAttribute("human", "홍길동");

    // response (응답) : 이동
    // HttpServletResponse
//    response.sendRedirect("default.jsp");
    pageContext.forward("default.jsp"); // "forward" 는 pageContext 소속 ! 단발성으로 짐을 갖고 가고싶은 경우

%>

</body>
</html>