<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 11:10 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<p id="demo"></p>
<br><br>
<button>버튼</button>

<script type="text/javascript">
    $('button').click(function () {
       $.ajax({
           url: "data02.jsp",
           type: "get",
           dataType: "json",
           success: function (data) {
               alert("success");

               let json = JSON.parse(data);

               $("#demo").text(json.name + " " + json.age + " " + json.birth);
           },
           error: function () {
               alert("error");
           }
       }) ;
    });

</script>
</body>
</html>
