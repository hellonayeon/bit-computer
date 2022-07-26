<%@ page import="me.hellonayeon.poll.dto.PollDto" %>
<%@ page import="java.util.List" %>
<%@ page import="me.hellonayeon.poll.dto.PollSubDto" %><%--
  Created by IntelliJ IDEA.
  User: nayeon
  Date: 2022/07/16
  Time: 9:43 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

<%
    PollDto poll = (PollDto) request.getAttribute("poll");
    List<PollSubDto> pollSubs = (List<PollSubDto>) request.getAttribute("pollSubList");

    String json = "[";
    for (PollSubDto p : pollSubs) {
        json += "{ name:'" + p.getAnswer() + "', y:" + p.getACount() + "}, ";
    }
    json = json.substring(0, json.lastIndexOf(",")) + "]";
    System.out.println(json);

    request.setAttribute("jsonData", json);
%>

<table class="list_table" style="width: 95%">
    <col width="200">
    <col width="500">

    <tr>
        <th>투표번호</th>
        <td style="text-align: left;">
            <input type="text" value="<%=poll.getPollId()%>" size="50" readonly>
        </td>
    </tr>

    <tr>
        <th>아이디</th>
        <td style="text-align: left;">
            <input type="text" value="<%=poll.getId()%>" size="50" readonly>
        </td>
    </tr>

    <tr>
        <th>투표 기한</th>
        <td style="text-align: left;">
            <%=poll.getSDate()%> ~ <%=poll.getEDate()%>
        </td>
    </tr>

    <tr>
        <th>투표 내용</th>
        <td style="text-align: left;">
            <textarea rows="5" cols="30" readonly><%=poll.getQuestion()%></textarea>
        </td>
    </tr>

    <tr>
        <th>통계</th>
        <td><div id="container"></div></td>
    </tr>
</table>

<script type="text/javascript">
  Highcharts.chart('container', {
    chart: {
      plotBackgroundColor: null,
      plotBorderWidth: null,
      plotShadow: false,
      type: 'pie'
    },
    title: {
      text: "<%=poll.getQuestion()%>"
    },
    tooltip: {
      pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
    },
    accessibility: {
      point: {
        valueSuffix: '%'
      }
    },
    plotOptions: {
      pie: {
        allowPointSelect: true,
        cursor: 'pointer',
        dataLabels: {
          enabled: true,
          format: '<b>{point.name}</b>: {point.percentage:.1f} %'
        }
      }
    },
    series: [{
      name: 'Brands',
      colorByPoint: true,
      data: <%=json%>
    }]
  });
</script>