package ajax;

import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);

        // JSON Object
//         String str = "World";
//
//         JSONObject sObj = new JSONObject();
//         sObj.put("str", str);
//
//         resp.setContentType("application/x-json; charset=utf-8");
//         resp.getWriter().print(sObj);

//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("title", "제목입니다.");
//        map.put("content", "내용입니다.");
//
//        JSONObject mObj = new JSONObject();
//        mObj.put("map", mObj);

        resp.setContentType("application/x-json; charset=utf-8");

        List<MemberDto> list = new ArrayList<>();
        list.add(new MemberDto(1001, "홍길동"));
        list.add(new MemberDto(1002, "성춘향"));

        JSONObject lObj = new JSONObject();
        lObj.put("list", list);

        resp.setContentType("application/x-json; charset=utf-8");
        resp.getWriter().print(list);
    }
}
