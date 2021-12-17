package com.zeus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zeus.domain.Member;
import com.zeus.service.MemberService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/user")
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerForm(Member member, Model model) throws Exception{
		log.info("UserRegisterForm");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(Member member, Model model) throws Exception{
		service.register(member);
		
		model.addAttribute("msg", "등록이 완료되었습니다.");
		
		return "user/success";
	}
}
