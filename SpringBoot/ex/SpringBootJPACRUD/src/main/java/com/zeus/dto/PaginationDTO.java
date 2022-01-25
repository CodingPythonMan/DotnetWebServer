package com.zeus.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;

@Getter
public class PaginationDTO<T> {
	private Page<T> page;
	
	private Pageable prevPageable; // 이전 페이지
	private Pageable nextPageable; // 다음 페이지
	
	private int currentPageNumber; // 현재 페이지 번호
	private int totalPageCount; // 전체 페이지수
	
	private Pageable currentPageable; // 현재 페이지
	private List<Pageable> pageableList; // 페이지 리스트

	public PaginationDTO(Page<T> page) {
		this.page = page;
		
		this.currentPageable = page.getPageable();
		
		this.currentPageNumber = this.currentPageable.getPageNumber() + 1;
		
		this.totalPageCount = page.getTotalPages();
		
		this.pageableList = new ArrayList<>();
		
		calcPages();
	}
	
	// 페이지 계산 메소드
	private void calcPages() {
		int endPageNumber; // 끝 페이지 번호
		int startPageNumber; // 시작 페이지 번호
	
		endPageNumber = (int)(Math.ceil(this.currentPageNumber/10.0) * 10);
		
		startPageNumber = endPageNumber - 9;
		
		Pageable startPageable = this.currentPageable;
		
		for(int i=startPageNumber; i < this.currentPageNumber; i++) {
			startPageable = startPageable.previousOrFirst();
		}
		
		this.prevPageable = startPageable.getPageNumber() <= 0 ? null : startPageable.previousOrFirst();
		
		if(this.totalPageCount < endPageNumber) {
			endPageNumber = this.totalPageCount;
			this.nextPageable = null;
		}
		
		for(int i=startPageNumber; i<= endPageNumber; i++) {
			pageableList.add(startPageable);
			startPageable = startPageable.next();
		}
		
		this.nextPageable = startPageable.getPageNumber() + 1 < totalPageCount ? startPageable : null;
	}
	
	public String makeQuery(int page) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.build();
	
		return uriComponents.toUriString();
	}
}
