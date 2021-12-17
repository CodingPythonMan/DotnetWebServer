package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeus.dao.BoardMapper;
import com.zeus.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardDao;
	
	@Override
	public void register(Board board) throws Exception {
		boardDao.create(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		return boardDao.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		boardDao.update(board);
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		boardDao.delete(boardNo);
	}

	@Override
	public List<Board> list() throws Exception {
		return boardDao.list();
	}

}
