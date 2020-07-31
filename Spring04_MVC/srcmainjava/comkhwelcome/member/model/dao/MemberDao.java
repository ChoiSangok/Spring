package com.kh.welcome.member.model.dao;


import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.welcome.member.model.dto.Member;


/**
 * @Repository 어노테이션
 * 해당 클래스의 Dao 역활을 하는 Bean 으로 등록
 * SqlException 을 DataAccessException 으로 전환한다
 */
@Repository
public class MemberDao {
	
	@Autowired
	SqlSessionTemplate session;
	
	/**
	 * select 쿼리	1. 결과가 하나인 경우 
	 * 					selectOne( namespace.태그id, 매핑시킬 객체 )
	 * 				2. 결과가 여러개인 경우
	 * 					selectList( namespace.태그id, 매핑시킬 객체)
	 * 
	 * 
	 * 
	 * insert 쿼리	sqlSessionTemplate.insert( namespace.태그id, 매핑시킬 객체)
	 * update 쿼리	sqlSessionTemplate.update( namespace.태그id, 매핑시킬 객체)
	 * delete 쿼리	sqlSessionTemplate.delete( namespace.태그id, 매핑시킬 객체)
	 * 매핑 시킬 객체가 필요하지 않다면 두 번째 매개변수를 생략
	 * 
	 * 
	 */
	
	
	
	
	
	public int insertMember(Member member) {
		/**
		 * MEMBER.insertMember : 
		 * Mapper의 Namespace 이름. 태그의 id 속성 값
		 */
		return session.insert("MEMBER.insertMember",member);
	}
	
	public Member selectMember(Map<String,Object> commandMap) {
		return session.selectOne("MEMBER.selectMember",commandMap);
	}
	
	public int updateMember(Member member) {
		return session.update("MEMBER.updateMember", member);
	}
	
	public int deleteMember(Member member) {
		return session.delete("MEMBER.deleteMember",member);
		
	}

	public int selectId(String userId) {
		return session.selectOne("MEMBER.selectId",userId);
		
	}
}
