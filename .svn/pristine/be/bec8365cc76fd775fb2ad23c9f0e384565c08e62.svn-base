package kr.or.ddit.internship.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.internship.service.InternshipService;
import kr.or.ddit.internship.vo.InternshipVO;

@Controller
@RequestMapping("/internship/internshipUpdate.do")
public class InternshipUpdateController {
	
	@Inject
	private InternshipService service;
	
	@ModelAttribute("intern")// ("")이름을 지정하고 그 지정된 이름은 jsp에도 있어야 한다
	public InternshipVO intern() {

		return new InternshipVO();
	}
	@GetMapping
	public String getMapping(
			Authentication authentication
			,Model model
			,@RequestParam(name="what") String inteCd
			)
	{
		if (authentication.getAuthorities().stream().anyMatch(auth -> "ROLE_TS".equals(auth.getAuthority()))) {
			InternshipVO view = service.internshipView(inteCd);// 인턴십 목록 조회
			model.addAttribute("intern", view);// 조회 된 목록을 jsp에 보냄
			return "internship/internEdit";
		}else {
			model.addAttribute("message","권한이 없습니다.");
			return "internship/internList";
		}
	}
	
	
	
	@PostMapping
	public String internshipUpdate(
			@ModelAttribute("intern") InternshipVO intern// 수정된 데이터를 받음
			,Model model
			) {
		
		String viewName=null;
		boolean success = service.internshipUpdate(intern);// db에 수정된 데이터 삽입
		if(success) {
			viewName= "redirect:/internship/internshipList.do";// 성공
		}else {
			model.addAttribute("message", "인턴십 등록 에러발생");// 실패
			viewName= "internship/internEdit";
		}
		return viewName;
		
	}
	
	
}



