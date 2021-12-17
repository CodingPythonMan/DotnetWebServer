package com.zeus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zeus.domain.Board;

@Repository
public class BoardDAO {
	// 의존성 주입 대상 필드
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void create(Board board) throws Exception{
		String query = "Insert into diboard(board_no, title, content, writer) values(diboard_seq.nextVal, ?,?,?)";
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
	}
	
	public Board read(Integer boardNo) throws Exception{
		List<Board> results = jdbcTemplate.query("select board_no, title, content, writer, reg_date from diboard where board_no=?", new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException{
				Board board = new Board();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				
				Timestamp timestamp = rs.getTimestamp("reg_date");
				board.setRegDate(timestamp.toLocalDateTime());
				
				return board;
			}
		}, boardNo);
		
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void update(Board board) throws Exception{
		String query = "update diboard set title=?, content=? where board_no=?"; 
		jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
	}
	
	public void delete(Integer boardNo) throws Exception{
		String query = "delete from diboard where board_no =?";
		jdbcTemplate.update(query, boardNo);
	}
	
	public List<Board> list() throws Exception{
		List<Board> results = jdbcTemplate.query("select board_no, title, content, writer, reg_date from diboard where board_no > 0 order by board_no desc, reg_date desc", new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException{
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				
				Timestamp timestamp = rs.getTimestamp("reg_date");
				board.setRegDate(timestamp.toLocalDateTime());
				
				return board;
			}
		});
		
		return results;
	}
}
