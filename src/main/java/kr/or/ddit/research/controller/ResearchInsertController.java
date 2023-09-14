package kr.or.ddit.research.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.research.service.ResearchService;
import kr.or.ddit.research.vo.ResearchVO;
import kr.or.ddit.serviceresult.ServiceResult;

@Controller
@RequestMapping("research/researchInsert.do")
public class ResearchInsertController {
	
	@Inject
	private ResearchService researchService;
	
	@ModelAttribute("researchVO")
	public ResearchVO researchVO() {
		return new ResearchVO();
	}
	
	@GetMapping
	public String getHandler() {
		return "research/researchForm";
	}
	
	@PostMapping
	public String postHandler(
			Model model
			, @ModelAttribute("researchService") ResearchVO researchVO
			, Errors errors
			){
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = researchService.createResearch(researchVO);
			if(result == true) {
				logicalViewName = "redirect:/research/researchList.do";
			}else {
				model.addAttribute("message", "등록 중 문제 발생");
				logicalViewName = "research/researchForm";
			}
		}else {
			logicalViewName = "research/researchForm";
		}
		
		return logicalViewName;
	}
	
}
	

