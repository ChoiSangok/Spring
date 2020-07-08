package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Emp;
import web.service.EmpService;
import web.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpDetailViewController
 */
@WebServlet("/emp/detail")
public class EmpDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService= new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("e되나");
		
		int res = Integer.parseInt(req.getParameter("empno"));
		
		Emp emp = empService.detail(res);
		
		
		req.setAttribute("emp",emp);
		
		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp")
			.forward(req, resp);
		
	}

	
}
