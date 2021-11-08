package com.study.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.exam.vo.UserVO;

@Controller
@RequestMapping(value = "login")
public class LoginController {
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("userVO", new UserVO());
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("userVO") UserVO userVO) {
		System.out.println("onSubmit 구현 메소드 입니다.");
		return "loginData";
	}
}
