package selectKey.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisConnectionFactory;
import selectKey.dao.SelectKeyDao;
import selectKey.dto.TestMember;

public class SelectKeyServiceImpl implements SelectKeyService {

	private SqlSessionFactory factory= MyBatisConnectionFactory.getSqlSessionFactory();
	
	private SelectKeyDao selectKeyDao;
	
	@Override
	public void insert(TestMember testmem) {
		// TODO Auto-generated method stub
		
		SqlSession sqlSession = factory.openSession(true);
		
		selectKeyDao = sqlSession.getMapper(SelectKeyDao.class);
		
		selectKeyDao.insert(testmem);
		
	}

}
