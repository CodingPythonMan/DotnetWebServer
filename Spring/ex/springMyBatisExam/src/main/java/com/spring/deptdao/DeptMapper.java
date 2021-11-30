package com.spring.deptdao;

import java.util.List;

import com.spring.deptvo.DeptVO;

public interface DeptMapper {
	public List<DeptVO> listDepartment(DeptVO param);
	public DeptVO selectDepartment(String deptid);
	public int insertDepartment(DeptVO param);
	public int updateDepartment(DeptVO param);
	public int deleteDepartment(DeptVO param);
}
