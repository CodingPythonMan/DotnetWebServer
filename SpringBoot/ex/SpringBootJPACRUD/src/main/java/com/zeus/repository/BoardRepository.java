package com.zeus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import com.zeus.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>,
QuerydslPredicateExecutor<Board>{

	public List<Board> listAll();
	
	public List<Board> searchByTitle(String title);
	
	public List<Board> searchByWriter(@Param("writer") String writer);
	
	public List<Board> searchByContent(String content);
	
	public List<Board> searchByTitleOrContent(String title, String content);
	
	public List<Board> searchByContentOrWriter(@Param("content") String content, @Param("writer") String writer);
	
	public List<Board> searchByTitleOrContentOrWriter(String title, String content, String writer);
	
	/*
	// JPA 쿼리 메소드
	public List<Board> findByBoardNoGreaterThanOrderByBoardNoDesc(Long boardNo);
	
	public List<Board> findByTitleContainingOrderByBoardNoDesc(String title);
	
	public List<Board> findByWriterContainingOrderByBoardNoDesc(String writer);
	
	public List<Board> findByContentContainingOrderByBoardNoDesc(String content);
	
	public List<Board> findByTitleContainingOrContentContainingOrderByBoardNoDesc(String title, String content);
	
	public List<Board> findByContentContainingOrWriterContainingOrderByBoardNoDesc(String content, String writer);
	
	public List<Board> findByTitleContainingOrContentContainingOrWriterContainingOrderByBoardNoDesc(String title, String content, String writer);*/
	
	/*
	// JQPL
	@Query("SELECT b FROM Board b WHERE b.boardNo > 0 ORDER BY b.boardNo desc")
	public List<Board> listAll();
	
	@Query("SELECT b FROM Board b WHERE b.title LIKE %?1% AND b.boardNo > 0 ORDER BY b.boardNo desc")
	public List<Board> searchByTitle(String title);
	
	@Query("SELECT b FROM Board b WHERE b.writer LIKE %:writer% AND b.boardNo > 0 ORDER BY b.boardNo desc")
	public List<Board> searchByWriter(@Param("writer") String writer);
	
	@Query("SELECT b FROM Board b WHERE b.content LIKE %?1% AND b.boardNo > 0 ORDER BY b.boardNo desc")
	public List<Board> searchByContent(String content);
	
	@Query("SELECT b FROM Board b WHERE b.title LIKE %?1% OR b.content LIKE %?2% ORDER BY b.boardNo desc")
	public List<Board> searchByTitleOrContent(String title, String content);
	
	@Query("SELECT b FROM Board b WHERE b.content LIKE %:content% OR b.writer LIKE %:writer% ORDER BY b.boardNo desc")
	public List<Board> searchByContentOrWriter(@Param("content") String content, @Param("writer") String writer);
	
	@Query("SELECT b FROM Board b WHERE b.title LIKE %?1% OR b.content LIKE %?2% OR b.writer LIKE %?3% ORDER BY b.boardNo desc")
	public List<Board> searchByTitleOrContentOrWriter(String title, String content, String writer);*/
}
