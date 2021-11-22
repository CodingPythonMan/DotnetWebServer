package com.spring.subjectdao;

import java.util.List;

import com.spring.subjectvo.SubjectVO;

public interface subjectDao {
	public List<SubjectVO> listSubject(SubjectVO param);
	
}
