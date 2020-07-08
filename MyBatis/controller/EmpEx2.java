package controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	
	public static void main(String[] args) {
		
		//마이바티스 수행 객체
		SqlSession sqlSession;
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		
//		자동 커밋 auto commit
		sqlSession = factory.openSession(true); 
		
//		dao 매핑
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);
		
		Scanner sc = new Scanner(System.in);
		//--------------------------------------------
		
//		sqlSession.getMapper();
//		sqlSession.selectOne();
//		sqlSession.selectMap();
		
//		sqlSession.insert();
//		sqlSession.update();
//		sqlSession.delete();
		
//		sqlSession.commit();
//		sqlSession.rollback();
//		
//		sqlSession.close();
		

		
		//-------------------------------
//		전체 조회
		List<Emp> list = empDao.selctAll();
		
		for(Emp emp:list) {
			System.out.println(emp);
		}
		
//		empno 로 조회		
		System.out.println("empno로 조회: ");
		int num = sc.nextInt();
		Emp res = empDao.selectByEmpNo(num);
		System.out.println(res);
		
		//insert emp
		
		System.out.println("emp 정보 삽입");
		Emp insertEmp = new Emp();
		
		insertEmp.setEmpno(sc.nextInt());
		sc.nextLine();
		insertEmp.setEname(sc.nextLine());
		insertEmp.setJob(sc.nextLine());
		insertEmp.setMgr(sc.nextInt());
		sc.nextLine();
		
//	----	입사일 강사님	------------------------------
//		String input = sc.nextLine();
//		
//		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
//		Date hiredate=null;
//		try {
//			hiredate = form.parse(input);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		insertEmp.setHiredate(hiredate);

//-----------------------------------	----------------
		
		insertEmp.setHiredate(new Date());
		insertEmp.setSal(sc.nextInt());
		sc.nextLine();
		insertEmp.setComm(sc.nextInt());
		sc.nextLine();
		insertEmp.setDeptno(sc.nextInt());
		sc.nextLine();
		
		empDao.insert(insertEmp);
		
		
		//delete by empno
		
		System.out.println("삭제할 번호를 입력하세요");
		
		int delete = sc.nextInt();
		Emp emp = new Emp();
		
		emp.setEmpno(delete);
		empDao.deleteEmpno(emp);	
	}

}
