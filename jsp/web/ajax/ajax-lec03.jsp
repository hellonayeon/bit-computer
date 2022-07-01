<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 10:04 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<%--
    Asynchronous Javascript And Xml
    비동기
 --%>

<p id="demo"></p>
<br>
<button type="button">버튼</button>

<script type="text/javascript">
    $(function () {
        $("button").click(function () {
            // $("demo").load("data.html");

           // $("#demo").load("data.html #data1");

            // $("#demo").load("data01.jsp", "t1=abc&t2=123");

            // $("#demo").load("data01.jsp", {t1: "ABC", t2:"가나다"});

            $("#demo").load(
                "data01.jsp",
                {t1: "ABC", t2: "가나다"},
                function(data, status, xhr) {
                    alert("success");
                    alert(JSON.stringify(data));
                }
            )
        });
    });
</script>
</body>
</html>
