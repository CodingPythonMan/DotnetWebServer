package com.zeus.domain;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.ToString;
import lombok.Setter;

@Getter
@Setter
@ToString
public class Address {
	@NotBlank
	private String postCode;
	
	@NotBlank
	private String location;
}
