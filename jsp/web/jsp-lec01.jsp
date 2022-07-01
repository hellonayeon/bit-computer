<%@ page import="human.HumanTwo" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/06/30
  Time: 4:07 오후
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
  // Java 영역 -> Scriptlet
%>
<head>
  <title>JSP</title>
</head>
<body>
<h3>Hello Servlet</h3>

<!-- 선언부 -->
<%!
  // global 변수, function, class
  int gl_var = 0; // global 변수는 마치 static 변수

  public void func() {
    System.out.println("func() called.");
  }

  public class HumanOne {
    private int number;
    private String name;

    public HumanOne() {
      this.number = 1;
      this.name = "홍길동";
    }

    public String print() {
      return number + " " + name;
    }
  }
%>

<!-- 코드부 -->
<%
  gl_var++;
  System.out.println("global variable: " + gl_var);

  int lc_val = 0;
  lc_val++;
  System.out.println("local variable: " + lc_val);

  func();

  HumanOne ho = new HumanOne();
  HumanTwo ht = new HumanTwo(2, "성춘향");
%>


<!-- 값 -->
<%=gl_var %>
<br>

<%=ho.print()%>
<br>

<%=ht.toString()%>
<br>

<input type="text" value="<%=gl_var %>">
<br>

<h2><%=gl_var%></h2>

<%-- 내장 객체(생성하지 않고 바로 사용가능한 객체) --%>
<%
  out.println("out printing");
%>

<%
  for (int i=0; i<10; i++) {
%>
<h3>hello <%=i + 1%></h3>
<%
  }
%>

<%
  for (int i=0; i<10; i++) {
    out.println("<h3>" + (i+1) + "</h3>");
  }
%>

</body>
</html>
