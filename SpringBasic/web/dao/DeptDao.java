package web.dao;

import java.util.List;

import web.dto.Dept;

public interface DeptDao {

	//전체조회
	public List<Dept> selectAll();

}
