package web.service;

import java.util.List;

import web.dto.Emp;

public interface EmpService {

	//전체 조회
	public List<Emp> getlist();

	// 한명만 조회
	public Emp detail(int res);

}
