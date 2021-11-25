package com.spring.studentdao;

import java.util.List;

import com.spring.studentvo.StudentVO;

public interface StudentDao {
	List<StudentVO> listStudent(StudentVO param);

	String studentCount(String s_num);

	StudentVO idCheck(String id);
}
