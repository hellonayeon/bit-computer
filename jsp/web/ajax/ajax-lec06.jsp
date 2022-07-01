<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 11:21 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AJAX</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>

<p id="demo"></p>
<br><br>
<button>버튼</button>

<script type="text/javascript">
    $('button').click(function () {
        $.ajax({
            url: "./hello",
            type: "get",
            data: {"id":"abc", "pwd":"123"},
            success: function (data) {
                alert('success');
                // alert(JSON.stringify(data));
                // alert(data.str);

                // alert(data.map.title);
                // alert(data.map.content);

                alert(data.list[0].name);
            },
            error: function (err) {
                alert('error');
                console.log(err);
            }
        });
    });
</script>
</body>
</html>
