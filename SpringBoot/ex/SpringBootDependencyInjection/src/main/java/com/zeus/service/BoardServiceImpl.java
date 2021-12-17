package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.dao.BoardDAO;
import com.zeus.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO dao;
	
	// 생성자를 사용한 의존성 주입
	@Autowired
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void register(Board board) throws Exception {
		dao.create(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		return dao.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		dao.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		dao.delete(boardNo);
	}

	@Override
	public List<Board> list() throws Exception {
		return dao.list();
	}

}
