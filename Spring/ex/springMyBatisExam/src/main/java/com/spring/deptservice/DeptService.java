package com.spring.deptservice;

import java.util.List;

import com.spring.deptvo.DeptVO;

public interface DeptService {
	public List<DeptVO> listDepartment(DeptVO param);
	public DeptVO selectDepartment(String deptid);
	public int insertDepartment(DeptVO param);
	public int updateDepartment(DeptVO param);
	public int deleteDepartment(DeptVO param);
}
