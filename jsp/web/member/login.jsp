<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 2:15 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

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

<h2>Login Page</h2>

<div class="center">
<form action="loginAf,jsp" method="post"></form>
<table border="1">
    <tr>
        <th>아이디</th>
        <td>
            <input type="text" id="id" name="id" size="20">
            <input type="checkbox" id="chk-save-id">Save Id
        </td>
    </tr>
    <tr>
        <th>패스워드</th>
        <td>
            <input type="password" name="pwd" size="20">
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="로그인">
            <a href="regi.jsp">회원가입</a>
        </td>
    </tr>
</table>
</div>

<script type="text/javascript">
    let user_id = $.cookie("user_id");
    if (user_id != null) {
        $("#id").val(user_id);
        $("#chk-save-id").prop("checked", true);
    }

    $("#chk-save-id").click(function () {
        if ($("#chk-save-id").is(":checked")) {

            if ($("#id").val().trim() == "") {
                alert("ID를 입력해 주십시오");
                $("#chk-save-id").prop("checked", false)
            }
            else {
                $.cookie("user_id", $("#id").val().trim(), {express:7, path:'./'});
            }
        }
        else {
            $.removeCookie("user_Id", {path: "./"})
        }
    })
</script>

</body>
</html>
