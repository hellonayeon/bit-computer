<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 2:36 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%


%>
<html>
<head>
    <title>Register</title>
</head>
<body>
<div class="center">
    <form action="regiAf.jsp" method="post">
        <table border="1">
            <tr>
                <th>아이디</th>
                <td>
                    <input type="text" id="id" name="id" size="20"><br>
                    <p id="id-check" style="font-size: 8px"></p>
                    <input type="button" id="id-btn" value="아이디 확인">
                </td>
            </tr>
            <tr>
                <th>패스워드</th>
                <td>
                    <input type="text" name="pwd" size="20">
                </td>
            </tr>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="name" size="20">
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                    <input type="text" name="email" size="20">
                </td>
            </tr>
            <tr>
                <th>버튼</th>
                <td colspan="2">
                    <input type="submit" value="회원가입">
                </td>
            </tr>
        </table>

    </form>
</div>

<script>

</script>
</body>
</html>
