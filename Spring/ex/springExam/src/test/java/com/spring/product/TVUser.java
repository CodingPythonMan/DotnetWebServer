package com.spring.product;

import java.util.Scanner;

import org.junit.Test;

public class TVUser {
	
	@Test
	public void TvTest() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("제조사명 : samsung, lg");
		System.out.print("TV 제조사명을 입력하세요 : ");
		String comName = scan.nextLine();
		
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(comName);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
