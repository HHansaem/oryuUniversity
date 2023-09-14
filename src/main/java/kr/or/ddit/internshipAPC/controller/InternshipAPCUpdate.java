package kr.or.ddit.internshipAPC.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.internship.vo.InternshipVO;
import kr.or.ddit.internshipAPC.service.InternshipAPCService;
import kr.or.ddit.internshipAPC.vo.InternshipAPCVO;

@Controller
@RequestMapping("/internshipAPC/internshipAPCUpdate.do")
public class InternshipAPCUpdate {

	@Inject
	private InternshipAPCService service;
	
	
	@ModelAttribute("internAPC")// ("")이름을 지정하고 그 지정된 이름은 jsp에도 있어야 한다
	public InternshipAPCVO internAPC() {

		return new InternshipAPCVO();
	}
	
	@GetMapping
	public String InternAPCUpdate(
			Authentication authentication
			,Model model
			,@RequestParam(name="what") String iaCd
			)
	{
		if (authentication.getAuthorities().stream().anyMatch(auth -> "ROLE_ST".equals(auth.getAuthority()))) {
			InternshipAPCVO view = service.internshipAPCView(iaCd);
			model.addAttribute("internAPC", view);
			return "internshipAPC/internAPCInsertForm";
		}else {
			model.addAttribute("message","권한이 없습니다.");
			return "internship/internList";
		}
		
	}
	
	@PostMapping
	public String internshipUpdate(
			@ModelAttribute("internAPC") InternshipAPCVO internAPC
			,Model model
			) {
		String viewName=null;
		boolean success = service.internshipAPCUpdate(internAPC);
		if(success) {
			viewName= "redirect:/internshipAPC/InternshipAPCList.do";
		}else {
			model.addAttribute("message", "인턴십 등록 에러발생");
			viewName= "internship/internInsertForm";
		}
		return viewName;
		
	}
	
}
