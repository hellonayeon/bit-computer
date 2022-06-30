package sample06;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sample06/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");

        pw.println("<head>");
        pw.println("<title>제목</title>");
        pw.println("</head>");

        pw.println("<body>");

        /*
        *
        * getSession(false)
        * session 이 존재하면, 현재 session 을 반환한다.
        * 존재하지 않으면, NULL 을 반환한다.
        *
        * getSession(true)
        * session 이 존재하면, 현재 session 을 반환한다.
        * 존재하지 않으면, 새로 생성한다.
        *
        * getSession() <- default 'true'
        *
        * */

        HttpSession session = req.getSession(false);

        if (session == null) {
            session = req.getSession(true);

            // 기한 설정
            session.setMaxInactiveInterval(30); // 초 단위
            session.setAttribute("visited", "1");
            pw.println("<p>첫번째 방문입니다.</p>");
        }
        else {
            String visited = (String) session.getAttribute("visited");
            int count = Integer.parseInt(visited);

            count++;

            pw.println("<p>방문 횟수는 " + count + "번째 방문입니다.");
            session.setAttribute("visited", count + "");
        }

        pw.println("</body>");

        pw.println("</html>");
        pw.close();
    }
}
