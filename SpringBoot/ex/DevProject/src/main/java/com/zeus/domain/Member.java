package com.zeus.domain;

import lombok.ToString;

// 롬복 에너테이션
@ToString(exclude = "userName")
public class Member {
	private String userId;
	private String userName;
	private String password;
}
