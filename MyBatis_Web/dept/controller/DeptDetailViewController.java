package dept.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;
import dept.dto.Dept;

@WebServlet("/dept/detail")
public class DeptDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//dept dao 객체
	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		System.out.println("잘되나 확ㄱ인");
		
		//내코딩
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		
		Dept dept = deptDao.deptdetail(deptno);
		
		req.setAttribute("dept", dept);
		req.getRequestDispatcher("/WEB-INF/views/dept/detailview.jsp")
		.forward(req, resp);
		
		
//		String param = req.getParameter("deptno");
//		
//		int deptno=0;
//		
//		if(param != null && !"".equals(param)) {
//			deptno = Integer.parseInt(param);
//		}
//		
//		//dto 전달값 저장
//		Dept dept = new Dept();
//		dept.setDeptno(deptno);
//		
//		//사에 정보 조회 겨로가
//		Dept result = deptDao.selectInfo(dept);
//		
//		req.setAttribute("result", result);
//		
//		req.getRequestDispatcher("/WEB-INF/views/dept/detailview.jsp").forward(req, resp);
	}
	

}





