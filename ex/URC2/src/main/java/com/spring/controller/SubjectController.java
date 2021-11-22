package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.subjectservice.SubjectService;
import com.spring.subjectvo.SubjectVO;

@Controller
@RequestMapping(value="/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	private static final String CONTEXT_PATH = "subject";
	
	/* 학과목록 전체 조회 */
	@RequestMapping(value="/listSubject")
	public ModelAndView listSubject(@ModelAttribute SubjectVO param){
		List<SubjectVO> list = subjectService.listSubject(param);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("subjectList", list);
		mav.setViewName(CONTEXT_PATH + "/subject");
		
		return mav;
	}
}
