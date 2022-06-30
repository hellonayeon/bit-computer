package sample03;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("sample03.HelloServlet doGet.");

        resp.setContentType("text/html; charset=UTF-8");

        String name = req.getParameter("name");
        String age = req.getParameter("age");

        String[] food = req.getParameterValues("food");

        System.out.println(name);
        System.out.println(age);
        System.out.println(Arrays.toString(food));

        PrintWriter pw = resp.getWriter();

        pw.println("<html>");

        pw.println("<head>");
        pw.println("<title>제목</title>");
        pw.println("</head>");

        pw.println("<body>");

        pw.println("<h3>이름: " + name + "</h3>");
        pw.println("<p>나이:" + age + "</p>");

        if (food != null) {
            for (String f : food) {
                pw.println("<p>좋아하는 음식: " + f + "</p>");
            }
        }

        pw.println("</body>");

        pw.println("</html>");
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("sample03.HelloServlet doPost.");
    }
}
