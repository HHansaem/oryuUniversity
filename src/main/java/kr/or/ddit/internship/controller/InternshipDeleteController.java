package kr.or.ddit.internship.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.internship.service.InternshipService;

@Controller
public class InternshipDeleteController {
	
	@Inject
	private InternshipService service;
	
	
	@RequestMapping("/internship/internshipDelete.do")
	public String internshipDelete(
		@RequestParam(name="what", required = true )String inteCd // 선택된 인턴십 게시물 코드
		, Model model
			){
		
		String viewName=null;
		boolean success = service.internshipDelete(inteCd);// 인턴십 게시물 상태값 삭제로 바꿈
		if(success) {// 성공시
			viewName= "redirect:/internship/internshipList.do";
		}else {// 실패 시
			model.addAttribute("message", "인턴십 삭제 중 에러발생");
			viewName= "redirect:/internship/internInsertView.do?inteCd=\" + what?"+inteCd;
		}
		return viewName;
	}
	
	
}
