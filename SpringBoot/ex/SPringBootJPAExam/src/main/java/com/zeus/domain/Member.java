package com.zeus.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.zeus.constant.Gender;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(of="userNo")
@ToString
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long userNo;
	
	private String userId;
	private String userPw;
	private String userName;
	
	@CreationTimestamp
	private Date regDate;
	@UpdateTimestamp
	private Date updDate;
}
