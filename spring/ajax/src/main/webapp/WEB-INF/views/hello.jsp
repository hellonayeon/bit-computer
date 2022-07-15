<%@ page import="me.hellonayeon.dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/13
  Time: 9:34 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello JSP</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<h2>/views/hello.jsp</h2>

<!-- Model 에 담는 경우 request attribute 에서 꺼내오지 않아도 돼 ! -->
<%--<%--%>
<%--    MemberDto mem = (MemberDto) request.getAttribute("mem");--%>
<%--%>--%>

<%--member: <%=mem.getNumber()%><br>--%>
<%--name: <%=mem.getName()%><br>--%>
<%--<br>--%>

<!-- EL tag, Core tag -->
number: ${mem.number}<br>
name: ${mem.name}<br>
<br>

<!-- FE to BE -->
<form action="move.do" method="post">
    번호: <input type="text" name="number" size="20"><br>
    이름: <input type="text" name="name" size="20"><br><br>

    <input type="submit" value="확인"><br>
</form>

ID: <input type="text" id="checkid"><br> &nbsp;
<button type="button" onclick="idCheckFunc()">아이디 체크</button>

<script>
    function idCheckFunc() {

      $.ajax({
        url: "idcheck.do",
        type: "GET",
        data: { id:$('#checkid').val() },
        success: function(data) {
          alert('success');
        },
        error: function() {
          alert('error');
        }
      })

    }
</script>

<br><br>

<!-- -->

name: <input type="text" id="name" value="나연"><br>
phone: <input type="text" id="phone" value="010-0000-0000"><br>
email: <input type="text" id="email" value="abc@xyz.com"><br>
birth: <input type="text" id="birth" value="9999-09-09"><br>

<button type="button" id="account">회원가입</button>

<script type="text/javascript">
    $('#account').click(function() {

      let human = {
        name:$('#name').val(),
        phone:$('#phone').val(),
        email:$('#email').val(),
        birth:$('#birth').val()
      }

      $.ajax({
        url: "account.do",
        type: "POST",
        dataType: "json",
        data: human,
        async: true,
        success: function(obj) {
          alert('success');
          alert( JSON.stringify(obj) );
        },
        error: function(err) {
          alert(err);
        }

      })
    });
</script>

</body>
</html>
