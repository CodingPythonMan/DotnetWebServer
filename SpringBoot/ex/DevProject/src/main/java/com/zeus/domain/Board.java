package com.zeus.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Board {
	private Integer boardNo;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
}
