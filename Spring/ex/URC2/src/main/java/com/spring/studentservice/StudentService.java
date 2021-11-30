package com.spring.studentservice;

import java.util.List;

import com.spring.studentvo.StudentVO;
import com.spring.subjectvo.SubjectVO;

public interface StudentService {

	List<StudentVO> listStudent(StudentVO param);

	String studentCount(String s_num);

	StudentVO idCheck(String id);

	int pwCheck(String sd_passwd, int no);

	List<SubjectVO> selectSubjectNum(SubjectVO param);

	int insertStudent(StudentVO param);

	Object selectStudent(int no);

	int updateStudent(StudentVO param);

	int deleteStudent(StudentVO param);
	
	
}
