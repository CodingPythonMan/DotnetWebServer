package com.zeus.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zeus.domain.Board;
import com.zeus.vo.PageRequestVO;
import com.zeus.vo.SearchVO;

public interface BoardService {

	// 등록 서비스
	public void register(Board board) throws Exception;

	// 페이징 목록 서비스
	public Page<Board> list(PageRequestVO pageRequestVO) throws Exception;

	// 페이징 상세 내용 서비스, 페이징 수정 화면 서비스
	public Board read(Long boardNo) throws Exception;

	// 페이징 수정 처리 서비스
	public void modify(Board board) throws Exception;

	// 페이징 삭제 처리 서비스
	public void remove(Long boardNo) throws Exception;

	// 검색 서비스
	public List<Board> search(SearchVO searchVO) throws Exception;

}
