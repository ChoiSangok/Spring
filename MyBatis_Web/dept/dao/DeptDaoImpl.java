package dept.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class DeptDaoImpl implements DeptDao {

	//마이바티스 객체 생성
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	
	@Override
	public List<Dept> selectAll() {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		//DB 조회 결과
		List<Dept> deptList = sqlSession.selectList("dept.dao.DeptDao.selectAll");
		
//		sqlSession.commit();
//		sqlSession.clearCache();
		sqlSession.close();
		
		return deptList;
	}


	@Override
	public Dept deptdetail(int deptno) {
		
		SqlSession sqlSession = factory.openSession();
		
		Dept dept= sqlSession.selectOne("dept.dao.DeptDao.deptdetail",deptno);
		
		sqlSession.close();
		
		return dept;
		
	}


	//강사님
	@Override
	public Dept selectInfo(Dept dept) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert(HashMap<String, Object> map) {
		
		SqlSession sqlSession = factory.openSession(true);
		
		sqlSession.insert("dept.dao.DeptDao.insert",map);
		
		sqlSession.close();
		
	}

}
