package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {

	//전체조회
	public List<Emp> selctAll();

//	empno를 이용해서 조회
	public Emp selectByEmpNo(int num);

	//insert
	public void insert(Emp insertEmp);

	public void deleteEmpno(Emp emp);

}
