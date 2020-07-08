package web.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisConnectionFactory;
import web.dao.EmpDao;
import web.dto.Emp;

public class EmpServiceImpl implements EmpService{

	//a마이바티스 연결 객체
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	//Dao 객체
	private EmpDao empDao;
	
	
	@Override
	public List<Emp> getlist() {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		//매퍼를 이용한 dao 연결
		empDao = sqlSession.getMapper(EmpDao.class);
		
		//전체 리스트 조회
		List<Emp> list=empDao.selectAll();
		
//		sqlSession.commit();
//		sqlSession.rollback();
		
		return list;
	}


	@Override
	public Emp detail(int res) {
		SqlSession sqlSession = factory.openSession();
		
		empDao= sqlSession.getMapper(EmpDao.class);
		
		Emp emp = empDao.detail(res);

		return emp;
		
		
	}

}
