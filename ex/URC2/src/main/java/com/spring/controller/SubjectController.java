package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	/* 학과 상세 정보창 */
	@RequestMapping(value="/selectSubject")
	public ModelAndView selectSubject(@RequestParam("no") int no){
		ModelAndView mav = new ModelAndView();
		
		if(no == 0) {
			mav.setViewName(CONTEXT_PATH + "/subject_pop");
		}else {
			mav.addObject("svo", subjectService.selectSubject(no));
			mav.setViewName(CONTEXT_PATH + "/subject_pop");
		}
		
		return mav;
	}
	
	
	/* 학과 등록 */
	@RequestMapping(value="/insertSubject")
	public ModelAndView insertSubject(@ModelAttribute SubjectVO param) {
		int result;
		String resultStr;
		
		result = subjectService.insertSubject(param);
		
		if(result == 1) {
			resultStr = "학과 등록 완료";
		}else {
			resultStr = "학과 등록 실패";
		}
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
	
	/* 학과 수정 */
	@RequestMapping(value="/updateSubject")
	public ModelAndView updateSubject(@ModelAttribute SubjectVO param) {
		int result;
		String resultStr;
		
		result = subjectService.updateSubject(param);
		
		if(result == 1) {
			resultStr = "학과 수정 완료";
		}else {
			resultStr = "학과 수정 실패";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
}
