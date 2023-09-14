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

import kr.or.ddit.internshipAPC.service.InternshipAPCService;
import kr.or.ddit.internshipAPC.vo.InternshipAPCVO;

@Controller
@RequestMapping("/internshipAPC/internshipAPCInsert.do")
public class InternshipAPCInsertController {

	@Inject
	private InternshipAPCService service;
	
	@ModelAttribute("internAPC")// ("")이름을 지정하고 그 지정된 이름은 jsp에도 있어야 한다
	public InternshipAPCVO internAPC() {

		return new InternshipAPCVO();
	}
	
	@GetMapping
	public String getMapping(
			Authentication authentication
			,@RequestParam(name="what") String inteCd // 인턴십 코드
			,Model model
			)
	{		// 학생인지를 확인
		if (authentication.getAuthorities().stream().anyMatch(auth -> "ROLE_ST".equals(auth.getAuthority()))) {
			InternshipAPCVO info = service.stuInfo(authentication.getName());
			info.setInteCd(inteCd);
			model.addAttribute("internAPC", info);// 학생인 경우에는 신청서 작성 폼으로
			return "internshipAPC/internAPCInsertForm";
		}else {
			// 학생이 아니면 alert 보여준 후 인턴십 목록창으로 이동
			model.addAttribute("message","권한이 없습니다.");
			return "internshipAPC/mnginternAPCList";
		}
	}

	@PostMapping
	public String postMapping(
			@ModelAttribute("internAPC") InternshipAPCVO internAPC
			,Model model
			) {
		String viewName=null;
		boolean success = service.internshipAPCInsert(internAPC);//인턴십 신청서 등록
		if(success) {
			viewName= "redirect:/internshipAPC/InternshipAPCList.do";// 성공시
		}else {
			model.addAttribute("message", "인턴십 신청 에러발생");
			viewName= "internshipAPC/internAPCInsertForm";// 실패시
		}
		return viewName;
	}
	
}
