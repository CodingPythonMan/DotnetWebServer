package com.spring.studentdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.studentvo.StudentVO;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.spring.studentdao.StudentDao";
	
	@Override
	public List<StudentVO> listStudent(StudentVO param) {
		return sqlSession.selectList(namespace+".listStudent", param);
	}

	@Override
	public String studentCount(String s_num) {
		return sqlSession.selectOne(namespace+ ".studentCount", s_num);
	}

	@Override
	public StudentVO idCheck(String id) {
		return sqlSession.selectOne(namespace+".idCheck", id);
	}



}
