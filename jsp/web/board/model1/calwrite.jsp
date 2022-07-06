<%@ page import="bbs.model1.dto.MemberDto" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/06
  Time: 12:19 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String year = request.getParameter("year");
    String month = request.getParameter("month");
    String day = request.getParameter("day");
%>
<%
    Object obj = session.getAttribute("login");
    MemberDto mem = null;
    if(obj == null){
%>
<script>
    alert('로그인 해 주십시오');
    location.href = "login.jsp";
</script>
<%
    }
    mem = (MemberDto)obj;
%>
<html>
<head>
    <title>일정 작성</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<%
    Calendar cal = Calendar.getInstance();
    int tyear = cal.get(Calendar.YEAR);
    int tmonth = cal.get(Calendar.MONTH) + 1;
    int tday = cal.get(Calendar.DATE);
    int thour = cal.get(Calendar.HOUR_OF_DAY);
    int tmin = cal.get(Calendar.MINUTE);

    cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
%>

<h2>일정 추가</h2>

<div align="center">

    <input type="date"> &nbsp; <input type="time">

    <form action="calwriteAf.jsp" method="post">

        <table class="table table-bordered" style="width: 65%">
            <col width="200"><col width="500">
            <tr>
                <th>아이디</th>
                <td>
                    <%=mem.getId()%>
                    <input type="hidden" name="id" value="<%=mem.getId()%>">
                </td>
            </tr>
            <tr>
                <th>제목</th>
                <td>
                    <input type="text" size="60" name="title">
                </td>
            </tr>
            <tr>
                <th>일정</th>
                <td>
                    <select name="year">
                        <%
                            // 5년 전  ~  5년 후
                            for (int i=tyear - 5; i <= tyear + 5; i++) {
                        %>
                                <option <%= year.equals(i + "")?"selected='selected'":"" %> value="<%=i%>" >
                                    <%=i%>
                                </option>
                        <%
                            }
                        %>
                    </select>년

                    <select name="month">
                        <%
                            // 5년 전  ~  5년 후
                            for (int i=1; i <= 12; i++) {
                        %>
                        <option <%= month.equals(i + "")?"selected='selected'":"" %> value="<%=i%>" >
                            <%=i%>
                        </option>
                        <%
                            }
                        %>
                    </select>월

                    <select name="day">
                        <%
                            // 5년 전  ~  5년 후
                            for (int i=1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                        %>
                        <option <%= day.equals(i + "")?"selected='selected'":"" %> value="<%=i%>" >
                            <%=i%>
                        </option>
                        <%
                            }
                        %>
                    </select>일

                    <select name="hour">
                        <%
                            // 5년 전  ~  5년 후
                            for (int i=0; i < 24; i++) {
                        %>
                        <option <%= (thour + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>" >
                            <%=i%>
                        </option>
                        <%
                            }
                        %>
                    </select>시

                    <select name="min">
                        <%
                            // 5년 전  ~  5년 후
                            for (int i=0; i < 60; i++) {
                        %>
                        <option <%= (tmin + "").equals(i + "")?"selected='selected'":"" %> value="<%=i%>" >
                            <%=i%>
                        </option>
                        <%
                            }
                        %>
                    </select>분
                </td>
            </tr>

            <tr>
                <th>내용</th>
                <td>
                    <textarea row="20" cols="60" name="content"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="일정 추가">
                </td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>
