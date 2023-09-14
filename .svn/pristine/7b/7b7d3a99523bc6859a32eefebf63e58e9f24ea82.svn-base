package kr.or.ddit.research.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.acBuDoc.vo.AcBuDocVO;
import kr.or.ddit.research.service.ResearchService;
import kr.or.ddit.research.vo.ResearchVO;

@Controller
public class ResearchDeleteController {

	@Inject
	private ResearchService researchService;

	@GetMapping("/research/researchDelete.do")
	public String getHandler(
	        Model model
	        , @RequestParam(name = "what") String reseCd
	) {
		ResearchVO researchVO = researchService.retrieveResearch(reseCd);
	    
	    String logicalViewName = null;
	    boolean result = researchService.removeResearch(researchVO);
	    if (result) {
            logicalViewName = "redirect:/research/researchList.do";
        } else {
            model.addAttribute("message", "삭제 중 문제 발생");
            logicalViewName = "redirect:/research/researchList.do";
        }
	    return logicalViewName;
	}

	@PostMapping("/research/researchDelete.do")
	public String postHandler(
	        Model model
	        , @RequestParam(name = "what") String reseCd
	) {
		ResearchVO researchVO = researchService.retrieveResearch(reseCd);
	    
	    String logicalViewName = null;
	    boolean result = researchService.removeResearch(researchVO);
	    if (result) {
            logicalViewName = "redirect:/research/researchList.do";
        } else {
            model.addAttribute("message", "삭제 중 문제 발생");
            logicalViewName = "redirect:/research/researchList.do";
        }
	    return logicalViewName;
	}






}
