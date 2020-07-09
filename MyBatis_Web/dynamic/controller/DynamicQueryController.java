package dynamic.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dynamic.dao.DynamicQueryDao;
import mybatis.MyBatisConnectionFactory;
import web.dto.Emp;

/**
 * Servlet implementation class DynamicQueryController
 */
@WebServlet("/dynamic/query")
public class DynamicQueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	//마이바티스 수행 객체
	private SqlSession sqlSession;
	
	//Dao 객체
	private DynamicQueryDao dynamicQueryDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sqlSession = factory.openSession(true);
		
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);
		
		//-----------------------------------------------------------------
		
		List<HashMap<String,Object>> list= dynamicQueryDao.select();
		
//		for (Object object : list) {
//			System.out.println(object);
//		}
		
//		req.setAttribute("list", list);
//		
//		req.getRequestDispatcher("/WEB-INF/views/dynamic/query.jsp")
//			.forward(req, resp);
		
		
		//-----------------------------------------------------------------
		
		List res2 = dynamicQueryDao.select2("S");
		
		System.out.println(res2);
		
		//-----------------------------------------------------------------
		
		Emp emp= new Emp();
		
		emp.setEmpno(7369);
		emp.setEname("KING");
		
		List res3 = dynamicQueryDao.select3(emp);
		System.out.println(res3);
		
		
	}

}















