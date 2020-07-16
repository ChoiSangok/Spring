package web.service;

import java.util.List;

import web.dto.Dept;

public interface DeptService {

	// 부서 정보 전체 조회
	public List<Dept> getList();

}
