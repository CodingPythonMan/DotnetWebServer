package com.spring.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.studentdao.StudentDao;
import com.spring.studentvo.StudentVO;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<StudentVO> listStudent(StudentVO param) {
		return studentDao.listStudent(param);
	}

	@Override
	public String studentCount(String s_num) {
		return studentDao.studentCount(s_num);
	}

	@Override
	public StudentVO idCheck(String id) {
		return studentDao.idCheck(id);
	}

}
