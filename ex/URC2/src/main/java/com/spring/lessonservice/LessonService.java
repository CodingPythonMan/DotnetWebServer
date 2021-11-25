package com.spring.lessonservice;

import java.util.List;

import com.spring.lessonvo.LessonVO;

public interface LessonService {

	List<LessonVO> listLesson(LessonVO param);

	int insertLesson(LessonVO param);

	Object selectLesson(int no);

	int updateLesson(LessonVO param);

	int deleteLesson(int no);

}
