package kr.or.ddit.acBuDoc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.acBuDoc.service.AcBuDocService;
import kr.or.ddit.acBuDoc.vo.AcBuDocVO;

@Controller
public class AcBuDocDeleteController {
	@Inject
	private AcBuDocService acBuDocService;
	
	@GetMapping("/acBuDoc/acBuDocDelete.do")
	public String getHandler(
	        Model model
	        , @RequestParam(name = "what") String buDocCd
	) {
		AcBuDocVO acBuDocVO = acBuDocService.retrieveAcBuDoc(buDocCd);
	    
	    String logicalViewName = null;
	    boolean result = acBuDocService.removeAcBuDoc(acBuDocVO);
	    if (result) {
            logicalViewName = "redirect:/acBuDoc/acBuDocList.do";
        } else {
            model.addAttribute("message", "삭제 중 문제 발생");
            logicalViewName = "redirect:/acBuDoc/acBuDocList.do";
        }
	    return logicalViewName;
	}
	
	@PostMapping("/acBudoc/acBuDocDelete.do")
	public String postHandler(	        
			Model model
	        , @RequestParam(name = "what") String buDocCd
	) {
		AcBuDocVO acBuDocVO = acBuDocService.retrieveAcBuDoc(buDocCd);
	    
	    String logicalViewName = null;
	    boolean result = acBuDocService.removeAcBuDoc(acBuDocVO);
	    if (result) {
            logicalViewName = "redirect:/acBuDoc/acBuDocList.do";
        } else {
            model.addAttribute("message", "삭제 중 문제 발생");
            logicalViewName = "redirect:/acBuDoc/acBuDocList.do";
        }
	    return logicalViewName;
	}
}
