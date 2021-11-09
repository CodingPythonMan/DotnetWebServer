package com.springmybatis.board;

import java.util.List;

import org.junit.Test;

import com.springmybatis.board.dao.BoardDAO;
import com.springmybatis.board.vo.BoardVO;

public class BoardServiceClient {
	@Test
	public void boardTest() {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}
