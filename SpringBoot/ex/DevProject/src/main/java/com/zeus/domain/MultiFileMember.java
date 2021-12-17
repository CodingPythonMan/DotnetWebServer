package com.zeus.domain;

import lombok.Setter;
import lombok.ToString;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;

@Getter
@Setter
@ToString
public class MultiFileMember {
	private String userId;
	private String password;
	private List<MultipartFile> pictureList;
}
