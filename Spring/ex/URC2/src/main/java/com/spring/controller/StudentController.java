package com.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.studentservice.StudentService;
import com.spring.studentvo.StudentVO;
import com.spring.subjectvo.SubjectVO;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	private static final String CONTEXT_NAME = "student";
	
	/* 전체 학생 출력 */
	@RequestMapping(value="/listStudent")
	public ModelAndView listStudent(@ModelAttribute StudentVO param) {
		List<StudentVO> list = studentService.listStudent(param);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName(CONTEXT_NAME + "/student");
		mav.addObject("studentList", list);
		
		return mav;
	}
	
	/* 동일 학과 학생 일련번호 */
	@ResponseBody
	@RequestMapping(value="/studentNum")
	public String selectStudentNum(@RequestParam("s_num") String s_num) {
		System.out.println(s_num);
		
		String count = studentService.studentCount(s_num);
		String year = "";
		String sd_num = "";
		
		// 학생 번호는 8자리로 생성한다.
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		year = sdf.format(new Date());
		sd_num = year+s_num +count;
		
		return sd_num;
	}
	
	/* 아이디 체크 */
	@ResponseBody
	@RequestMapping(value="/idCheck")
	public String idCheck(@RequestParam("sd_id") String id) {
		String ok = "";
		StudentVO svo = studentService.idCheck(id);
		
		if(svo != null) {
			ok = "ok";
		}
		
		return ok;
	}
	
	/* 학생 정보 수정 및 삭제 비밀번호 체크 */
	@ResponseBody
	@RequestMapping("/pwcheck")
	public String pwCheck(@RequestParam("sd_passwd") String sd_passwd, @RequestParam("no") int no) {
		int ok = 0;
		ok = studentService.pwCheck(sd_passwd, no);
		
		return ok + "";
 	}
	
	/* 학생 정보 등록 수정 POPUP 폼 */
	@RequestMapping("/selectStudent")
	public ModelAndView selectStudent(@ModelAttribute SubjectVO param, @RequestParam("no") int no) {
		/* 학과 번호 조회 */
		List<SubjectVO> numList = studentService.selectSubjectNum(param);
		
		ModelAndView mav = new ModelAndView();
		
		if(no == 0) {
			mav.addObject("mode", "insert");
			mav.addObject("subjectNum", numList); // 학과번호
		}else {
			mav.addObject("StudentVO", studentService.selectStudent(no));
			mav.addObject("mode", "update");
		}
		mav.setViewName(CONTEXT_NAME + "/student_pop");
		
		return mav;
	}
	
	/* 학생 등록 */
	@RequestMapping("/insertStudent")
	public ModelAndView insertStudent(@ModelAttribute StudentVO param) {
		String resultStr = "";
		
		int result = studentService.insertStudent(param);
		
		if(result > 0) {
			resultStr = "학생 등록이 완료되었습니다.";
		}else {
			resultStr = "학생 등록에 문제가 있어 완료하지 못하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
	
	/* 학생 수정 */
	@RequestMapping("/updateStudent")
	public ModelAndView updateStudent(@ModelAttribute StudentVO param) {
		String resultStr = "";
		
		int result = studentService.updateStudent(param);
		
		if(result > 0) {
			resultStr = "학생 정보 수정이 완료되었습니다.";
		}else {
			resultStr = "학생 정보 수정에 문제가 있어 완료하지 못하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		
		mav.setViewName("/result");
		return mav;
	}
	
	/* 학생 삭제 */
	@RequestMapping("/deleteStudent")
	public ModelAndView deleteStudent(@ModelAttribute StudentVO param) {
		String resultStr="";
		int result=studentService.deleteStudent(param);
		
		if(result > 0) {
			resultStr = "학생 정보 삭제가 완료되었습니다.";
		}else {
			resultStr = "학생 정보 삭제에 문제가 있어 완료하지 못하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("/result");
		
		return mav;
	}
}
