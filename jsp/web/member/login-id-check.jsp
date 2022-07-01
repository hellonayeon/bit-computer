<%@ page import="login.dao.MemberDao" %>
<%@ page import="java.sql.SQLException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /* 아이디 확인 */
    String id = request.getParameter("id");
    if (id != null) {
        MemberDao dao = MemberDao.getInstance();

        try {
            if (dao.isExistId(id)) {
%>
<script type="text/javascript">
    alert("이미 사용중인 아이디 입니다 :(");
    history.back();
</script>
<%
}
else {
%>
<script type="text/javascript">
    alert("사용 가능한 아이디입니다 :)");
    history.back();
</script>
<%
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
