package com.spring.subjectdao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.subjectvo.SubjectVO;

@Repository
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	private SqlSession sqlSession;
	
	public static final String namespace = "com.spring.subjectdao.SubjectDao";
	
	@Override
	public List<SubjectVO> listSubject(SubjectVO param) {
		return sqlSession.selectList(namespace+".listSubject", param);
	}

	@Override
	public int insertSubject(SubjectVO param) {
		return sqlSession.insert(namespace+".insertSubject", param);
	}

	@Override
	public SubjectVO selectSubject(int no) {
		return sqlSession.selectOne(namespace+".selectSubject", no);
	}

	@Override
	public int updateSubject(SubjectVO param) {
		return sqlSession.update(namespace+".updateSubject", param);
	}

}
