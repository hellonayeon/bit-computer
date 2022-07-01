<%@ page import="login.dao.MemberDao" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <style type="text/css">
        .center {
            margin: auto;
            width: 60%;
            border: 3px solid #00FF00;
            padding: 10px;
        }
    </style>
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


<script type="text/javascript">
    $("#id-btn").click(function () {
        let id = $("#id").val().trim();
        if (id == "") {
            alert("아이디를 입력해주세요 !");
            return;
        }
        window.location.replace("login-id-check.jsp?id=" + id);
    });
</script>



</body>
</html>
