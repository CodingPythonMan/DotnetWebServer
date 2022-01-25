package com.zeus.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.zeus.domain.Board;
import com.zeus.domain.QBoard;
import com.zeus.repository.BoardRepository;
import com.zeus.vo.PageRequestVO;
import com.zeus.vo.SearchVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
	private final BoardRepository repository;

	// 등록 처리 서비스 구현
	@Override
	public void register(Board board) throws Exception {
		repository.save(board);
	}

	// 페이징 목록 서비스 구현
	@Override
	@Transactional(readOnly = true)
	public Page<Board> list(PageRequestVO pageRequestVO) throws Exception {
		int pageNumber = pageRequestVO.getPage() - 1;
		int sizePerPage = pageRequestVO.getSizePerPage();
		
		Pageable pageRequest = PageRequest.of(pageNumber, sizePerPage, Sort.Direction.DESC, "boardNo");
		
		Page<Board> page = repository.findAll(pageRequest);
		
		return page;
	}

	// 페이징 상세 내용 서비스 구현, 페이징 수정 화면 서비스 구현
	@Override
	@Transactional(readOnly=true)
	public Board read(Long boardNo) throws Exception {
		return repository.getOne(boardNo);
	}
	
	// 페이징 수정 처리 서비스 구현
	@Override
	@Transactional
	public void modify(Board board) throws Exception {
		Board boardEntity = repository.getOne(board.getBoardNo());
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
	}

	// 페이징 삭제 처리 서비스 구현
	@Override
	@Transactional
	public void remove(Long boardNo) throws Exception {
		repository.deleteById(boardNo);
	}
	/*
	// 검색 서비스 구현(JPA 쿼드 메소드)
	@Override
	@Transactional(readOnly = true)
	public List<Board> search(SearchVO searchVO) throws Exception {
		String searchType = searchVO.getSearchType();
		String keyword = searchVO.getKeyword();
		
		List<Board> search = null;
		if(searchType != null && searchType.length() > 0) {
			if(searchType.equals("t")) {
				search = repository.findByTitleContainingOrderByBoardNoDesc(keyword);
			}else if(searchType.equals("w")) {
				search = repository.findByWriterContainingOrderByBoardNoDesc(keyword);
			}else if(searchType.equals("c")) {
				search = repository.findByContentContainingOrderByBoardNoDesc(keyword);
			}else if(searchType.equals("tc")) {
				search = repository.findByTitleContainingOrContentContainingOrderByBoardNoDesc(keyword, keyword);
			}else if(searchType.equals("cw")) {
				search = repository.findByContentContainingOrWriterContainingOrderByBoardNoDesc(keyword, keyword);
			}else if(searchType.equals("tcw")) {
				search = repository.findByTitleContainingOrContentContainingOrWriterContainingOrderByBoardNoDesc(keyword, keyword, keyword);
			}else {
				search = repository.findByBoardNoGreaterThanOrderByBoardNoDesc(0L);
			}
		}else {
			search = repository.findByBoardNoGreaterThanOrderByBoardNoDesc(0L);
		}
		
		return search;
	}*/
	
	/*
	// 검색 서비스 구현(JQPL)
	@Override
	@Transactional(readOnly = true)
	public List<Board> search(SearchVO searchVO) throws Exception{
		String searchType = searchVO.getSearchType();
		String keyword = searchVO.getKeyword();
	
		List<Board> list = null;
		if(searchType != null && searchType.length() > 0) {
			if(searchType.equals("t")) {
				list = repository.searchByTitle(keyword);
			}
			else if(searchType.equals("w")) {
				list = repository.searchByWriter(keyword);
			}else if(searchType.equals("c")) {
				list = repository.searchByContent(keyword);
			}else if(searchType.equals("tc")) {
				list = repository.searchByTitleOrContent(keyword, keyword);
			}else if(searchType.equals("cw")) {
				list = repository.searchByContentOrWriter(keyword, keyword);
			}else if(searchType.equals("tcw")) {
				list = repository.searchByTitleOrContentOrWriter(keyword, keyword, keyword);
			}else {
				list = repository.listAll();
			}
		}else{
			list = repository.listAll();
		}
		return list;
	}*/
	
	/*
	// 검색 서비스 구현(Querydsl)
	@Override
	@Transactional(readOnly = true)
	public List<Board> search(SearchVO searchVO) throws Exception{
		String searchType = searchVO.getSearchType();
		String keyword = searchVO.getKeyword();
		
		List<Board> list = null;
		if(searchType != null && searchType.length() > 0) {
			if(searchType.equals("t")) {
				list = searchByTitle(keyword);
			}else if(searchType.equals("w")) {
				list = searchByWriter(keyword);
			}else if(searchType.equals("c")) {
				list = searchByContent(keyword);
			}else if(searchType.equals("tc")) {
				list = searchByTitleOrContent(keyword, keyword);
			}else if(searchType.equals("cw")) {
				list = searchByContentOrWriter(keyword, keyword);
			}else if(searchType.equals("tcw")) {
				list = searchByTitleOrContentOrWriter(keyword, keyword, keyword);
			}else {
				list = listAll();
			}
		}else {
			list = listAll();
		}
		return list;
	}

	private List<Board> listAll() {
		QBoard board = QBoard.board;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(board.boardNo.gt(0));
		
		List<Board> list = new ArrayList<Board>();
		
		repository.findAll(builder).forEach(b -> list.add(b));
		return list;
	}
	
	private List<Board> searchByTitle(String title){
		QBoard board = QBoard.board;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(board.title.like("%" + title + "%"));
		
		List<Board> list = new ArrayList<Board>();
		
		repository.findAll(builder).forEach(b -> list.add(b));
		
		return list;
	}
	
	private List<Board> searchByWriter(String writer){
		QBoard board = QBoard.board;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(board.writer.like("%" + writer + "%"));
		
		List<Board> list = new ArrayList<Board>();
		
		repository.findAll(builder).forEach(b -> list.add(b));
		
		return list;
	}
	
	private List<Board> searchByContent(String content){
		QBoard board = QBoard.board;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(board.content.like("%" + content + "%"));
		
		List<Board> list = new ArrayList<Board>();
		
		repository.findAll(builder).forEach(b -> list.add(b));
		
		return list;
	}
	
	private List<Board> searchByTitleOrContent(String title, String content){
		QBoard board = QBoard.board;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(board.title.like("%" + title+ "%"))
		.or(board.content.like("%" + content+ "%"));
		
		List<Board> list = new ArrayList<Board>();
		
		repository.findAll(builder).forEach(b -> list.add(b));
		
		return list;
	}
	
	private List<Board> searchByContentOrWriter(String content, String writer){
		QBoard board = QBoard.board;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(board.content.like("%" + content + "%"))
		.or(board.writer.like("%" + writer + "%"));
		
		List<Board> list = new ArrayList<Board>();
		
		repository.findAll(builder).forEach(b -> list.add(b));
		
		return list;
	}
	
	private List<Board> searchByTitleOrContentOrWriter(String title, String content, String writer){
		QBoard board = QBoard.board;
		
		BooleanBuilder builder = new BooleanBuilder();
		builder.and(board.title.like("%" + title + "%"))
		.or(board.content.like("%" + content + "%"))
		.or(board.writer.like("%" + writer + "%"));
		
		List<Board> list = new ArrayList<Board>();
		
		repository.findAll(builder).forEach(b -> list.add(b));
		
		return list;
	}*/
	
	// 검색 서비스 구현(사용자 정의 인터페이스)
	@Override
	@Transactional(readOnly=true)
	public List<Board> search(SearchVO searchVO) throws Exception{
		String searchType = searchVO.getSearchType();
		String keyword = searchVO.getKeyword();
	
		List<Board> list = null;
		if(searchType != null && searchType.length() > 0) {
			if(searchType.equals("t")) {
				list = repository.searchByTitle(keyword);
			}
			else if(searchType.equals("w")) {
				list = repository.searchByWriter(keyword);
			}else if(searchType.equals("c")) {
				list = repository.searchByContent(keyword);
			}else if(searchType.equals("tc")) {
				list = repository.searchByTitleOrContent(keyword, keyword);
			}else if(searchType.equals("cw")) {
				list = repository.searchByContentOrWriter(keyword, keyword);
			}else if(searchType.equals("tcw")) {
				list = repository.searchByTitleOrContentOrWriter(keyword, keyword, keyword);
			}else {
				list = repository.listAll();
			}
		}else{
			list = repository.listAll();
		}
		return list;
	}
}