package selectKey.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import selectKey.dto.TestMember;
import selectKey.service.SelectKeyService;
import selectKey.service.SelectKeyServiceImpl;


@WebServlet("/select/key")
public class SelectKeyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SelectKeyService selectKeyService = new SelectKeyServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/test_member/insert.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid=req.getParameter("userid");
		String userpw= req.getParameter("userpw");

		TestMember testmem = new TestMember();
		
		testmem.setId(userid);
		testmem.setPw(userpw);

		selectKeyService.insert(testmem);
		
		req.setAttribute("testmem", testmem);
		req.getRequestDispatcher("/WEB-INF/views/test_member/success.jsp")
			.forward(req, resp);
		
//		if("tkddhr12345".equals(userid) && "choi6882".equals(userpw)) {
//			System.out.println("성공!");
//		}
	}
}
