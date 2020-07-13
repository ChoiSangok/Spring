package multiparam.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import multiparam.dao.MultiParamDao;
import mybatis.MyBatisConnectionFactory;
import web.dto.Emp;

/**
 * Servlet implementation class MuliParamController
 */
@WebServlet("/mulit/param")
public class MuliParamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	//마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	//마이바티스 수행 객체
	private SqlSession sqlSession;
	
	private MultiParamDao multiParamDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		sqlSession= factory.openSession(true);
		multiParamDao = sqlSession.getMapper(MultiParamDao.class);
		
		System.out.println("s나오나");
		
		//-------------------------
		
		//DTO 를 이용한 파라미터 전달
		Emp emp= new Emp();
		
		emp.setEmpno(5004);
		emp.setEname("A");
		emp.setJob("AAA");
		
		multiParamDao.insert(emp);
		
		
		
		
	}
	
}
