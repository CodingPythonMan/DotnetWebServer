package com.zeus.domain;

import lombok.ToString;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
@ToString
public class MemberAuth {
	private int userNo;
	private String auth;
}
