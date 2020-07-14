package dept.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;

@WebServlet("/dept/insert")
public class DeptInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//dept dao 객체
	private DeptDao deptDao = new DeptDaoImpl();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/dept/insert.jsp")
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HashMap<String, Object> map = new HashMap<>();
		
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		String dname=req.getParameter("dname");
		String loc=req.getParameter("loc");
		
		map.put("deptno",deptno);
		map.put("dname",dname);
		map.put("loc",loc);
		
		deptDao.insert(map);
		
		resp.sendRedirect("/dept/list");
		
		
	}
	
}
