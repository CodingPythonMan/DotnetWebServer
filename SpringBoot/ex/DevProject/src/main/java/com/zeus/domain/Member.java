package com.zeus.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 롬복 에너테이션
@Getter
@Setter
@ToString
public class Member {
	@NotBlank
	private String userId;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Size(max = 3)
	private String userName;
	
	@Email
	private String email;
	
	@Valid
	private Address address;
	
	@Valid
	private List<Card> cardList;
	
	//Date 타입 필드 변환 처리
	@Past
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
		
	/*
	private String gender;
	private String hobby;
	private String[] hobbyArray;
	private List<String> hobbyList;
	private boolean foreigner;
	private String developer;
	private String nationality;
	
	private Address address;
	private List<Card> cardList;
	
	private String cars;
	private String[] carArray;
	private List<String> carList;
	
	private String introduction;
	
	//Date 타입 필드 변환 처리
	@DateTimeFormat(pattern="yyyyMMdd")
	private Date dateOfBirth;*/
}
