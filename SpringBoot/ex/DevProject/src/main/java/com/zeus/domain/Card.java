package com.zeus.domain;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card {
	
	@NotBlank
	private String no;
	
	//@DateTimeFormat(pattern="yyyyMM")
	@Future
	@DateTimeFormat(pattern="yyyyMMdd")
	private Date validMonth;
}
