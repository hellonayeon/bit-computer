package sample04;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("sample04.HelloServlet doGet.");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        System.out.println("sample04.HelloServlet doPost.");

        req.setCharacterEncoding("UTF-8");

        String fruit = req.getParameter("fruit");
        String[] hobbies = req.getParameterValues("hobby");
        String introduce = req.getParameter("introduce");

        System.out.println("fruit = " + fruit);
        System.out.println("hobbies = " + Arrays.toString(hobbies));
        System.out.println("introduce = " + introduce);

    }
}
