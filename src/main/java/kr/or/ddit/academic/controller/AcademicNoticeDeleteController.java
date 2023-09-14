package kr.or.ddit.academic.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.academic.service.AcademicNoticeService;
import kr.or.ddit.academic.vo.AcademicNoticeVO;

@Controller
public class AcademicNoticeDeleteController {

	@Inject
	private AcademicNoticeService service;
	
	@GetMapping("/academic/acaNoticeDelete.do")
	public String getHandler(
	        Model model
	        , @RequestParam(name = "what") int anNum
	) {
	    AcademicNoticeVO acaNotice = service.retrieveAcademicNotice(anNum);
	    
	    String logicalViewName = null;
	    boolean result = service.removeAcademicNotice(acaNotice);
	    if (result) {
            logicalViewName = "redirect:/academic/acaNoticeList.do";
        } else {
            model.addAttribute("message", "공지사항 삭제 중 문제 발생");
            logicalViewName = "redirect:/academic/acaNoticeList.do";
        }
	    return logicalViewName;
	}
	
}
