package com.spring.subjectdao;

import java.util.List;

import com.spring.subjectvo.SubjectVO;

public interface SubjectDao {
	public List<SubjectVO> listSubject(SubjectVO param);

	public int insertSubject(SubjectVO param);

	public SubjectVO selectSubject(int no);

	public int updateSubject(SubjectVO param);
}
