package com.board.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@SequenceGenerator(
		name="JPABOARD_SEQ_GEN",
		sequenceName = "JPABOARD_SEQ",
		initialValue=1,
		allocationSize=1
		)
@Table(name="jpaboard")
public class Board {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="JPABOARD_SEQ-GEN"
	)
	@Column(name="board_no")
	private Long boardNo;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@Column(name="writer")
	private String writer;
	
	@CreationTimestamp
	@Column(name="reg_date")
	private LocalDateTime regDate;
}