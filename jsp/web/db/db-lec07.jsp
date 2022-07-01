<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 12:14 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Database Connect</title>
</head>
<body>

<h1>mydb Tables</h1>

<pre>
모든 테이블 목록을 출력한다.
</pre>

<%
  Class.forName("com.mysql.cj.jdbc.Driver");

  String url = "jdbc:mysql://localhost:3306/mydb";
  String user = "root";
  String password = "hellonayeon";

  Connection conn = DriverManager.getConnection(url, user, password);

  String sql = "show table status";

  PreparedStatement psmt = conn.prepareStatement(sql);
  ResultSet rs = psmt.executeQuery();

  ResultSetMetaData rsmd = rs.getMetaData();  // 컬럼의 정보
  int count = rsmd.getColumnCount();          // 컬럼의 수

%>

<table border="1">
  <tr>
    <%
        for (int i=0; i<count + 1; i++) {
    %>
            <td><%=rsmd.getColumnName(i)%></td>
    <%
        }
    %>
  </tr>

  <%
    while (rs.next()) {
  %>
    <tr>
      <%
          for (int i=1; i<count + 1; i++) {
              String  cols = rs.getString(i);
      %>
            <td><%=cols%></td>
      <%
          }
      %>
    </tr>
  <%
  }
  %>
</table>

<%
    if (rs != null)
        rs.close();
    if (psmt != null)
        psmt.close(); if (conn != null) conn.close();
%>

</body>
</html>
