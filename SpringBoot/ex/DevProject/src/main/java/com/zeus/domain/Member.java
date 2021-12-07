package com.zeus.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 롬복 에너테이션
@Getter
@Setter
@ToString
public class Member {
	private String userId;
	private String password;
	private String userName;
	private String email;
	
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
	private Date dateOfBirth;
	
//	private String userId = "hong";
//	private String password = "1234";
//	private Address address;
//	private List<Card> cardList;
	
	//private String userName;
	//private String email;
	
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
