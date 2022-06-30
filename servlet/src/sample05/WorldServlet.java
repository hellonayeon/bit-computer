package sample05;

import sample05.dto.StudentDto;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/world")
public class WorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");

        StudentDto st = (StudentDto) req.getAttribute("student");

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");

        pw.println("<head>");
        pw.println("<title>제목</title>");
        pw.println("</head>");

        pw.println("<body>");

        pw.println("<p>name: " + st.getName() + "</p>");
        pw.println("<p>age: " + st.getAge() + "</p>");
        pw.println("<p>address: " + st.getAddress() + "</p>");

        pw.println("</body>");

        pw.println("</html>");
        pw.close();
    }
}
