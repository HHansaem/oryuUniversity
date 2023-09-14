package kr.or.ddit.acBuDoc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.acBuDoc.service.AcBuDocService;
import kr.or.ddit.acBuDoc.vo.AcBuDocVO;

@Controller
@RequestMapping("acBuDoc/acBuDocInsert.do")
public class AcBuDocInsertController {

	@Inject
	private AcBuDocService acBuDocService;
	
	@ModelAttribute("acBuDocVO")
	public AcBuDocVO acBuDocVO() {
		return new AcBuDocVO();
	}

	@GetMapping
	public String gerHandler() {
		return "acBuDoc/acBuDocForm";
	}
	
	@PostMapping
	public String postHandler(
			Model model
			, @ModelAttribute("acBuDocService") AcBuDocVO acBuDocVO
			, Errors errors
	){
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = acBuDocService.createAcBuDoc(acBuDocVO);
			if(result == true) {
				logicalViewName = "redirect:/acBuDoc/acBuDocList.do";
			}else {
				model.addAttribute("message", "등록 중 문제 발생");
				logicalViewName = "acBuDoc/acBuDocForm";
			}
		}else {
			logicalViewName = "acBuDoc/acBuDocForm";
		}
		
		return logicalViewName;
	}
	
}
	

