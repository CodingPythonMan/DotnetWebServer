package com.zeus.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Board;
import com.zeus.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	
	private final BoardRepository repository;
	
	// 등록
	@Override
	@Transactional
	public void register(Board board) throws Exception {
		repository.save(board);
	}

	// 상세 조회
	@Override
	@Transactional(readOnly=true)
	public Board read(Long boardNo) throws Exception {
		return repository.getOne(boardNo);
	}

	// 목록 조회
	@Override
	@Transactional(readOnly = true)
	public List<Board> list() throws Exception {
		return repository.findAll(Sort.by(Direction.DESC, "boardNo"));
	}

	// 수정
	@Override
	public void modify(Board board) throws Exception {
		Board boardEntity = repository.getOne(board.getBoardNo());
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		boardEntity.setWriter(board.getWriter());
		boardEntity.setRegDate(board.getRegDate());
		
		repository.save(boardEntity);
	}

	// 삭제
	@Override
	@Transactional
	public void remove(Long boardNo) throws Exception {
		repository.deleteById(boardNo);	
	}

}
