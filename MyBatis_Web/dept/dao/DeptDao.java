package dept.dao;

import java.util.HashMap;
import java.util.List;

import dept.dto.Dept;

public interface DeptDao {

	//전체조회
	public List<Dept> selectAll();

	//detail
	public Dept deptdetail(int deptno);

	//지정된 부서 정보 조회
	
	public Dept selectInfo(Dept dept);

	public void insert(HashMap<String, Object> map);



}
