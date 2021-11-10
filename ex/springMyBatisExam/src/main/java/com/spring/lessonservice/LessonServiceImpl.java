package com.spring.lessonservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.lessondao.LessonMapper;
import com.spring.lessonvo.LessonVO;

@Service
@Transactional
public class LessonServiceImpl implements LessonService{

	@Autowired
	private LessonMapper lessonMapper;
	
	@Override
	public List<LessonVO> listLesson(LessonVO param) {
		List<LessonVO> list = new ArrayList<LessonVO>();
		list = lessonMapper.listLesson(param);
		return list;
	}

	@Override
	public LessonVO selectLesson(int no) {
		return lessonMapper.selectLesson(no);
	}

	@Override
	public int insertLesson(LessonVO param) {
		return lessonMapper.insertLesson(param);
	}

	@Override
	public int updateLesson(LessonVO param) {
		return lessonMapper.updateLesson(param);
	}

	@Override
	public int deleteLesson(int no) {
		return lessonMapper.deleteLesson(no);
	}

}
