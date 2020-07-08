package web.dao;

import java.util.List;

import web.dto.Emp;

public interface EmpDao {

	//전체 조회
	public List<Emp> selectAll();

	public Emp detail(int res);
	
}
