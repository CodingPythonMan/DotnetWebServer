package com.spring.deptservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.deptdao.DeptMapper;
import com.spring.deptvo.DeptVO;

@Service
@Transactional
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<DeptVO> listDepartment(DeptVO param) {
		List<DeptVO> list = new ArrayList<DeptVO>();
		list = deptMapper.listDepartment(param);
		return list;
	}

	@Override
	public DeptVO selectDepartment(String deptid) {
		return deptMapper.selectDepartment(deptid);
	}

	@Override
	public int insertDepartment(DeptVO param) {
		return deptMapper.insertDepartment(param);
	}

	@Override
	public int updateDepartment(DeptVO param) {
		return deptMapper.updateDepartment(param);
	}

	@Override
	public int deleteDepartment(DeptVO param) {
		return deptMapper.deleteDepartment(param);
	}

}
