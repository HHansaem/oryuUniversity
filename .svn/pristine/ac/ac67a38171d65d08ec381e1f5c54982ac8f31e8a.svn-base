package kr.or.ddit.academicBusinessReport.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.academicBusinessReport.service.ABRService;
import kr.or.ddit.academicBusinessReport.vo.ABRVO;

@Controller
@RequestMapping("/academicBusinessReport/aBRInsert.do")
public class ABRInsertController {
	
	@Inject
	private ABRService aBRService;

	@ModelAttribute("aBRVO")
	public ABRVO aBRVO() {
		return new ABRVO();
	}
	
	@GetMapping
	public String getHandler() {
		return "academicBusinessReport/aBRForm";
	}
	
	@PostMapping
	public String postHandler(
			Model model
			, @ModelAttribute("aBRService") ABRVO aBRVO
			, Errors errors
			) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = aBRService.createABR(aBRVO);
			if(result == true) {
				logicalViewName = "redirect:/academicBusinessReport/aBRList.do";
			}else {
				model.addAttribute("message", "학술사업 보고서 등록 중 문제 발생");
				logicalViewName = "academicBusinessReport/aBRForm";
			}
		}else {
			logicalViewName = "academicBusinessReport/aBRForm";
		}
		
		return logicalViewName;
	}
		
	}

