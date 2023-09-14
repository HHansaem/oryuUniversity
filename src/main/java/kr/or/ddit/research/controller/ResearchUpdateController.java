package kr.or.ddit.research.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.research.service.ResearchService;
import kr.or.ddit.research.vo.ResearchVO;

@Controller
@RequestMapping("/research/researchUpdate.do")
public class ResearchUpdateController {
	
	@Inject
	private ResearchService researchService;

	@GetMapping
	public String getHandler(
			Model model
			, @RequestParam(name = "what") String reseCd
	) {
		ResearchVO researchVO = researchService.retrieveResearch(reseCd);
		if(researchVO == null) {
			researchVO = new ResearchVO();
		}
		model.addAttribute("researchVO", researchVO);
		
		return "research/researchEdit";
	}
	
	@PostMapping
	public String postHandler(
			Model model
			, @ModelAttribute("researchVO") ResearchVO researchVO
			, BindingResult errors
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = researchService.modifyResearch(researchVO);
			if(result == true) {
				logicalViewName = "redirect:/research/researchView.do?what=" + researchVO.getReseCd();
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요");
				logicalViewName = "research/researchEdit";
			}
		}else {
			logicalViewName = "research/researchEdit";
		}
		return logicalViewName;
	}
}
