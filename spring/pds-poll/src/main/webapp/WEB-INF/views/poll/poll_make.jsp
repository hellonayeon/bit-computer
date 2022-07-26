<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/15
  Time: 12:06 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
//    String id = (String) request.getAttribute("id");
    String id = (String) request.getSession().getAttribute("loginId");
%>

<%
    Calendar cal = Calendar.getInstance();
    int tYear = cal.get(Calendar.YEAR);
    int tMonth = cal.get(Calendar.MONTH) + 1;
    int tDay = cal.get(Calendar.DATE);
%>

<form action="pollmakeAf.do" method="GET">

    <table class="list_table" style="width: 85%">
    <col width="200px"><col width="500px">

        <tr>
            <th>아이디</th>
            <td style="text-align: left">
                <%=id%><input type="hidden" name="id" value="<%=id%>">
            </td>
        </tr>
        <tr>
            <th>투표 기한</th>
            <td style="text-align: left">
                <select name="sYear">
                <%
                    for (int i=tYear; i < tYear + 5; i++) {
                %>
                    <option <%=(tYear + "").equals(i + "") ? "selected='selected'": ""%> value="<%=i%>">
                        <%=i%>
                    </option>
                <%
                    }
                %>
                </select>년 &nbsp;&nbsp;

                <select name="sMonth">
                    <%
                        for (int i=1; i <= 12; i++) {
                    %>
                    <option <%=(tMonth + "").equals(i + "") ? "selected='selected'": ""%> value="<%=i%>">
                        <%=i%>
                    </option>
                    <%
                        }
                    %>
                </select>월 &nbsp;&nbsp;

                <!-- FIXME -->
                <select name="sDay">
                    <%
                        for (int i=1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                    %>
                    <option <%=(tDay + "").equals(i + "") ? "selected='selected'": ""%> value="<%=i%>">
                        <%=i%>
                    </option>
                    <%
                        }
                    %>
                </select>일 &nbsp;&nbsp;

                ~

                <select name="eYear">
                    <%
                        for (int i=tYear; i < tYear + 5; i++) {
                    %>
                    <option <%=(tYear + "").equals(i + "") ? "selected='selected'": ""%> value="<%=i%>">
                        <%=i%>
                    </option>
                    <%
                        }
                    %>
                </select>년 &nbsp;&nbsp;

                <select name="eMonth">
                    <%
                        for (int i=1; i <= 12; i++) {
                    %>
                    <option <%=(tMonth + "").equals(i + "") ? "selected='selected'": ""%> value="<%=i%>">
                        <%=i%>
                    </option>
                    <%
                        }
                    %>
                </select>월 &nbsp;&nbsp;

                <!-- FIXME -->
                <select name="eDay">
                    <%
                        for (int i=1; i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
                    %>
                    <option <%=(tDay + "").equals(i + "") ? "selected='selected'": ""%> value="<%=i%>">
                        <%=i%>
                    </option>
                    <%
                        }
                    %>
                </select>일 &nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <th>투표 내용</th>
            <td style="text-align: left;">
                <textarea rows="10" cols="50" name="question"></textarea>
            </td>
        </tr>
        <tr>
            <th>투표 문항수</th>
            <td style="text-align: left;">
                <select name="itemCount" onchange="changePoll(this)">
                <%
                    for (int i=2; i<=10; i++) {
                %>
                        <option <%=(4 + "").equals(i + "") ? "selected='selected'" : ""%>
                            value="<%=i%>">
                            <%=i%>
                        </option>
                <%
                    }
                %>
                </select>
            </td>
        </tr>
        <tr>
            <th>투표 상세 문항</th>
            <td style="text-align: left;">
            <%
                for (int i=1; i<=10; i++) {
            %>
                    <div id="poll<%=i%>">
                        <%=(i + "")%>번: <input type="text" name="poll<%=i%>" size="60">
                    </div><br>
            <%
                }
            %>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="투표 생성하기">
            </td>
        </tr>
    </table>

</form>

<script type="text/javascript">

    $(document).ready(function() {
        // 보기 항목을 초기화
        for (let i=5; i<=10; i++) {
          $("#poll" + i).hide();
        }
    });

    function changePoll( sel ) {
      let val = sel.options[sel.selectedIndex].value;

      // <select> 초기화 (<div> 태그 모두 제거)
      for (let i=1; i<=10; i++) {
        $("#poll" + i).val("");
        $("#poll" + i).hide();
      }

      // 설정한 값 만큼 보여주기
      for (let i=1; i<=val; i++) {
        $("#poll" + i).show();
      }
    }
</script>
