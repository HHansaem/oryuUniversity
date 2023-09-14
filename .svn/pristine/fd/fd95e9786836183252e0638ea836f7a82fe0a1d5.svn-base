package kr.or.ddit.academicBusinessReport.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.academicBusinessReport.service.ABRService;
import kr.or.ddit.academicBusinessReport.vo.ABRVO;

@Controller
public class ABRDeleteController {

	@Inject
	private ABRService aBRService;
	
	@GetMapping("/academicBusinessReport/aBRDelete.do")
	public String getHandler(
	        Model model
	        , @RequestParam(name = "what") String buReSn
			) {
		ABRVO aBRVO = aBRService.retrieveABR(buReSn);
	    
	    String logicalViewName = null;
	    boolean result = aBRService.removeABR(aBRVO);
	    if (result) {
            logicalViewName = "redirect:/academicBusinessReport/aBRList.do";
        } else {
            model.addAttribute("message", "학술사업보고서 삭제 중 문제 발생");
            logicalViewName = "redirect:/academicBusinessReport/aBRList.do";
        }
	    return logicalViewName;
	}
	
}

