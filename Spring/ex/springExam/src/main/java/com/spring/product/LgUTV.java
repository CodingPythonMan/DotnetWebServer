package com.spring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgUTV implements TV{
	@Autowired
	private Speaker speaker;
	
	public LgUTV() {
		System.out.println("LgUTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgUTV---전원 켠다.");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgUTV---전원 끈다.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		//System.out.println("LgUTV---소리를 올린다.");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		//System.out.println("LgUTV---소리를 내린다.");
		speaker.volumeDown();
	}

}
