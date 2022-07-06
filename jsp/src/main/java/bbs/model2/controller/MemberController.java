package bbs.model2.controller;

import bbs.model2.dao.MemberDao;
import bbs.model2.dto.MemberDto;
import org.json.simple.JSONObject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MemberController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	public void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		
		String param = req.getParameter("param");
		
		if(param.equals("login")) {			
			resp.sendRedirect("board/model2/member/login.jsp");
		}
		else if(param.equals("regi")) {
			resp.sendRedirect("board/model2/member/regi.jsp");
		}
		else if(param.equals("idcheck")) {
			String id = req.getParameter("id");
			System.out.println("id:" + id);
			
			MemberDao dao = MemberDao.getInstance();
			boolean b = dao.getId(id);
			
			String str = "NO";
			if(b == false) {
				str = "YES";
			}
						
			JSONObject obj = new JSONObject();
			obj.put("msg", str);  // 짐싸!
			
			resp.setContentType("application/x-json; charset=utf-8");
			resp.getWriter().print(obj);
		}
		else if(param.equals("regiAf")) {
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			
			MemberDao dao = MemberDao.getInstance();
			boolean b = dao.addMember(new MemberDto(id, pwd, name, email, 0));
			
			String msg = "OK";
			if(b == false) {
				msg = "NO";
			}
			
			resp.sendRedirect("board/model2/message.jsp?msg=" + msg);
		}	
		else if(param.equals("loginAf")) {		
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			
			MemberDao dao = MemberDao.getInstance();
			MemberDto dto = dao.login(new MemberDto(id, pwd, null, null, 0));
												
			if(dto != null) {
				req.getSession().setAttribute("login", dto);
				resp.sendRedirect("bbs?param=bbslist");
			}			
		}		
	}		
}






