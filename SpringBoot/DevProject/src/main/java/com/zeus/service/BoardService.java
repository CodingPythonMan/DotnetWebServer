package com.zeus.service;

import java.util.ArrayList;
import java.util.List;

import com.zeus.domain.Board;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardService {
	private List<Board> boardList;
	
	public BoardService() {
		boardList = new ArrayList<>();
	}
	
	public void create(Board board) {
		boardList.add(board);
		log.info("create: {}", board);
	}
	
	public void readByBoardNo(Integer boardNo) {
		Board board = boardList.stream().filter(x -> x.getBoardNo().equals(boardNo)).findFirst().get();
		log.info("readByBoardNo: {}", board);
	}
	
	public void delete(Board board) {
		boardList.remove(board);
		log.info("delete: {}", board);
	}
}
