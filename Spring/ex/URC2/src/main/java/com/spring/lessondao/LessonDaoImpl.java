package com.spring.lessondao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.lessonvo.LessonVO;

@Repository
public class LessonDaoImpl implements LessonDao {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spring.lessondao.LessonDao";
	
	@Override
	public List<LessonVO> listLesson(LessonVO param) {
		return sqlSession.selectList(namespace + ".listLesson", param);
	}

	@Override
	public int insertLesson(LessonVO param) {
		return sqlSession.insert(namespace + ".insertLesson", param);
	}

	@Override
	public Object selectLesson(int no) {
		return sqlSession.selectOne(namespace + ".selectLesson", no);
	}

	@Override
	public int updateLesson(LessonVO param) {
		return sqlSession.update(namespace + ".updateLesson", param);
	}

	@Override
	public int deleteLesson(int no) {
		return sqlSession.delete(namespace + ".deleteLesson", no);
	}

}
