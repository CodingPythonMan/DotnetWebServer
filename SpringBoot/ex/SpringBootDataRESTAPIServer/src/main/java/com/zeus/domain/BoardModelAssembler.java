package com.zeus.domain;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import com.zeus.controller.BoardController;

public class BoardModelAssembler extends RepresentationModelAssemblerSupport<Board, BoardModel>{

	public BoardModelAssembler() {
		super(BoardController.class, BoardModel.class);
	}

	@Override
	public BoardModel toModel(Board board) {
		BoardModel resource = new BoardModel(board);
		return resource;
	}
}
