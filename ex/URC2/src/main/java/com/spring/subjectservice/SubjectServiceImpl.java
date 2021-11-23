package com.spring.subjectservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.subjectdao.SubjectDao;
import com.spring.subjectvo.SubjectVO;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDao subjectDao;
	
	@Override
	public List<SubjectVO> listSubject(SubjectVO param) {
		List<SubjectVO> list = new ArrayList<SubjectVO>();
				
		list = subjectDao.listSubject(param);
		
		return list;
	}

	@Override
	public int insertSubject(SubjectVO param) {
		return subjectDao.insertSubject(param);
	}

	@Override
	public SubjectVO selectSubject(int no) {
		return subjectDao.selectSubject(no);
	}

	@Override
	public int updateSubject(SubjectVO param) {
		return subjectDao.updateSubject(param);
	}

}
