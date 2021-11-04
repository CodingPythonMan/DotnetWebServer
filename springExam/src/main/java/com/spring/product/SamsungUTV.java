package com.spring.product;

public class SamsungUTV implements TV {
	public SamsungUTV() {
		System.out.println("SamsungUTV 객체 생성");
	}
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리.");
	}
	public void destroyMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("SamsungUTV---전원을 켠다.");
	}
	
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("SamsungUTV---전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("SamsungUTV---소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("SamsungUTV---소리를 내린다.");
	}
}
