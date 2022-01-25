package com.zeus.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zeus.domain.Board;
import com.zeus.dto.PaginationDTO;
import com.zeus.service.BoardService;
import com.zeus.vo.CodeLabelValue;
import com.zeus.vo.PageRequestVO;
import com.zeus.vo.SearchVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
	private final BoardService service;
	
	// 등록 화면
	@GetMapping("/register")
	public void registerForm(Board board, Model model) throws Exception{
		
	}
	
	// 등록 처리
	@PostMapping("/register")
	public String register(Board board, RedirectAttributes rttr) throws Exception{
		service.register(board);
		rttr.addFlashAttribute("msg", "등록이 완료되었습니다.");
		return "redirect:/board/list";
	}
	
	// 페이징 목록 화면
	@GetMapping("/list")
	public void list(@ModelAttribute("pgrq") PageRequestVO pageRequestVO,  Model model) throws Exception{
		Page<Board> page = service.list(pageRequestVO);
		
		model.addAttribute("pgntn", new PaginationDTO<Board>(page));
	}
	
	// 검색 목록 화면
	@GetMapping("/search")
	public void search(@ModelAttribute("pgrq") SearchVO searchVO, Model model) throws Exception {
		model.addAttribute("search", service.search(searchVO));
		
		// 검색 유형과 코드명과 코드값을 정의한다.
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("n", "---"));
		searchTypeCodeValueList.add(new CodeLabelValue("t", "제목"));
		searchTypeCodeValueList.add(new CodeLabelValue("c", "내용"));
		searchTypeCodeValueList.add(new CodeLabelValue("w", "글쓴이"));
		searchTypeCodeValueList.add(new CodeLabelValue("tc", "제목 또는 내용"));
		searchTypeCodeValueList.add(new CodeLabelValue("cw", "내용 또는 글쓴이"));
		searchTypeCodeValueList.add(new CodeLabelValue("tcw", "제목 또는 내용 또는 글쓴이"));
		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
	}
	
	// 페이징 상세 내용 화면
	@GetMapping("/read")
	public void read(Long boardNo, @ModelAttribute("pgrq") PageRequestVO pageRequestVO, Model model) throws Exception{
		model.addAttribute(service.read(boardNo));
	}
	
	// 페이징 수정 화면
	@GetMapping("/modify")
	public void modifyForm(Long boardNo, @ModelAttribute("pgrq") PageRequestVO pageRequestVO, Model model) throws Exception{
		model.addAttribute(service.read(boardNo));
	}
	
	// 페이징 수정 처리
	@PostMapping("/modify")
	public String modify(Board board, PageRequestVO pageRequestVO, RedirectAttributes rttr) throws Exception{
		service.modify(board);
	
		rttr.addAttribute("page", pageRequestVO.getPage());
		rttr.addAttribute("sizePerPage", pageRequestVO.getSizePerPage());
		rttr.addFlashAttribute("msg", "수정이 완료되었습니다.");
		
		return "redirect:/board/list";
	}
	
	// 페이징 삭제 처리
	@PostMapping("/remove")
	public String remove(Long boardNo, PageRequestVO pageRequestVO, RedirectAttributes rttr) throws Exception{
		service.remove(boardNo);
		
		rttr.addAttribute("page", pageRequestVO.getPage());
		rttr.addAttribute("sizePerPage", pageRequestVO.getSizePerPage());
		rttr.addFlashAttribute("msg", "삭제가 완료되었습니다.");
		
		return "redirect:/board/list";
	}
}
