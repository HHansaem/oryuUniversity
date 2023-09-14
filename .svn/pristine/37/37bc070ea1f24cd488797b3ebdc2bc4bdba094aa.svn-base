package kr.or.ddit.academic.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.academic.service.AcademicNoticeService;
import kr.or.ddit.academic.vo.AcademicNoticeVO;

@Controller
@RequestMapping("/academic/acaNoticeUpdate.do")
public class AcademicNoticeUpdateController {
	
	@Inject
	private AcademicNoticeService service;
	
	@GetMapping
	public String getHandler(
			Model model
			, @RequestParam(name = "what") int anNum
	) {
		AcademicNoticeVO acaNotice = service.retrieveAcademicNotice(anNum);
		
		model.addAttribute("acaNotice", acaNotice);
		
		return "academic/acaNoticeEdit";
	}
	
	@PostMapping
	public String postHandler(
			Model model
			, @ModelAttribute("acaNotice") AcademicNoticeVO acaNotice
			, BindingResult errors
			, HttpSession session
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			String memName = (String)session.getAttribute("memName");
			acaNotice.setAnWriter(memName);
			
			boolean result = service.modifyAcademicNotice(acaNotice);
			if(result == true) {
				logicalViewName = "redirect:/academic/acaNoticeView.do?what=" + acaNotice.getAnNum();
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요");
				logicalViewName = "academic/acaNoticeEdit";
			}
		}else {
			logicalViewName = "academic/acaNoticeEdit";
		}
		return logicalViewName;
	}
}



