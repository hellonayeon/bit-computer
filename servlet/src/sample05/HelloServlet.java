package sample05;

import sample05.dto.StudentDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/helloWorldServlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");

        System.out.println(name + " " + age + " " + address);

        StudentDto dto = new StudentDto(name, age, address);

        req.setAttribute("student", dto);

//        RequestDispatcher rd = req.getRequestDispatcher("world");
//        rd.forward(req, resp);

        resp.sendRedirect("world?name=" + name + "&age=" + age + "&address=" + address);
    }
}
