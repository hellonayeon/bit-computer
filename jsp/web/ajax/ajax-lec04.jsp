<%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/01
  Time: 10:29 오전
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
<button type="button">버튼</button>

<script type="text/javascript">
    $(document).ready(function () {
        $(button).click(function () {

            $.ajax({
               url: "data.json",
               type: "get",
                dataType: 'json',
                success: function (data) {
                    alert(JSON.stringify(data));

                    for (let i=0; i<data.length; i++) {
                        $("#demo").append(data[i].name + " ");
                        $("#demo").append(data[i].age + " ");
                        $("#demo").append(data[i].address + " ");
                        $("#demo").append(data[i].phone + "<br>");
                    }

                    $.each(data, function(inde)
                },
                error: function () {

                }
            });
        });
    });
</script>
</body>
</html>
