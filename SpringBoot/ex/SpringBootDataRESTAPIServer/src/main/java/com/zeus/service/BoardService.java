package com.zeus.service;

import java.util.List;

import com.zeus.domain.Board;

public interface BoardService {
	// 등록
	public void register(Board board) throws Exception;

	// 상세 조회
	public Board read(Long boardNo) throws Exception;

	// 목록 조회
	public List<Board> list() throws Exception;

	// 수정
	public void modify(Board board) throws Exception;

	// 삭제
	public void remove(Long boardNo) throws Exception;
}
