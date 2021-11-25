package com.spring.lessonservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.lessondao.LessonDao;
import com.spring.lessonvo.LessonVO;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {

	@Autowired
	private LessonDao lessonDao;
	
	@Override
	public List<LessonVO> listLesson(LessonVO param) {
		List<LessonVO> list = new ArrayList<LessonVO>();
		list = lessonDao.listLesson(param);
		return list;
	}

	@Override
	public int insertLesson(LessonVO param) {
		return lessonDao.insertLesson(param);
	}

	@Override
	public Object selectLesson(int no) {
		return lessonDao.selectLesson(no);
	}

	@Override
	public int updateLesson(LessonVO param) {
		return lessonDao.updateLesson(param);
	}

	@Override
	public int deleteLesson(int no) {
		return lessonDao.deleteLesson(no);
	}

}
