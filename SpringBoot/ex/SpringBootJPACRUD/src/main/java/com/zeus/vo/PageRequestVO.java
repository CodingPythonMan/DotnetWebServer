package com.zeus.vo;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageRequestVO {
	private int page;
	private int sizePerPage; // 페이지당 크기
	
	public PageRequestVO() {
		this.page = 1;
		this.sizePerPage = 10;
	}
	
	public void setPage(int page) {
		if(page <= 0) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public void setSizePerPage(int size) {
		if(size <= 0 || size > 100) {
			this.sizePerPage = 10;
			return;
		}
		
		this.sizePerPage = size;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getSizePerPage() {
		return this.sizePerPage;
	}
	
	public String toUriString() {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.queryParam("page", this.page)
				.queryParam("size", this.sizePerPage)
				.build();

		return uriComponents.toUriString();
	}
}
