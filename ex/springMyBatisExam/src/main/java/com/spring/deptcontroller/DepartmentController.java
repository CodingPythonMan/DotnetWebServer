package com.spring.deptcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.deptservice.DeptService;
import com.spring.deptvo.DeptVO;

/* 컨트롤러 */
@Controller
@RequestMapping(value="/department")
public class DepartmentController {
	private static final String CONTEXT_PATH="dept";
	
	@Autowired
	private DeptService deptService;
	
	/* 전체 조회 */
	@RequestMapping("/listDepartment")
	public ModelAndView listDepartment(@ModelAttribute DeptVO param) {
		List<DeptVO> list = deptService.listDepartment(param);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("departmentList", list);
		mav.setViewName(CONTEXT_PATH + "/department");
		
		return mav;
	}
	
	/* 상세 정보 보기 */
	@RequestMapping("/selectDepartment")
	public ModelAndView selectDepartment(@RequestParam("deptid") String deptid) {
		ModelAndView mav = new ModelAndView();
		
		if(deptid.equals("")) { // [등록] 버튼 클릭시
			mav.addObject("mode", "insert");
		}else {// [수정/삭제] 버튼 클릭시
			mav.addObject("DeptVO", deptService.selectDepartment(deptid));
			mav.addObject("mode", "update");
		}
		mav.setViewName(CONTEXT_PATH + "/department_pop");
	
		return mav;
	}
	
	/* 레코드 추가 */
	@RequestMapping("/insertDepartment")
	public ModelAndView insertDepartment(@ModelAttribute DeptVO param) {
		String resultStr = "";
		int result = deptService.insertDepartment(param);
		
		if(result > 0) {
			resultStr = "등록 완료 되었습니다.";
		}else {
			resultStr = "등록에 문제가 있어 완료하지 못하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("result");
		
		return mav;
	}
	
	/* 레코드 수정 */
	@RequestMapping("/updateDepartment")
	public ModelAndView updateDepartment(@ModelAttribute DeptVO param) {
		String resultStr="";
		int result = deptService.deleteDepartment(param);
		
		if(result > 0) {
			resultStr="삭제 완료되었습니다.";
		}else {
			resultStr="삭제에 문제가 있어 완료하지 못하였습니다.";
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", resultStr);
		mav.setViewName("result");
		
		return mav;
	}
}
