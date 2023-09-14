package kr.or.ddit.thesis.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.thesis.service.ThesisService;
import kr.or.ddit.thesis.vo.ThesisVO;

@Controller
public class ThesisDeleteController {
	
	@Inject
	private ThesisService thesisService;
	
	@GetMapping("/thesis/thesisDelete.do")
	public String getHandler(
	        Model model
	        , @RequestParam(name = "what") String thesSn
	) {
		ThesisVO thesisVO = thesisService.retrieveThesis(thesSn);
	    
	    String logicalViewName = null;
	    boolean result = thesisService.removeThesis(thesisVO);
	    if (result) {
            logicalViewName = "redirect:/thesis/thesisList.do";
        } else {
            model.addAttribute("message", "삭제 중 문제 발생");
            logicalViewName = "redirect:/thesis/thesisList.do";
        }
	    return logicalViewName;
	}
	
	@PostMapping("/thesis/thesisDelete.do")
	public String postHandler(	        
			Model model
	        , @RequestParam(name = "what") String thesSn
	) {
		ThesisVO thesisVO = thesisService.retrieveThesis(thesSn);
	    
	    String logicalViewName = null;
	    boolean result = thesisService.removeThesis(thesisVO);
	    if (result) {
            logicalViewName = "redirect:/thesis/thesisList.do";
        } else {
            model.addAttribute("message", "삭제 중 문제 발생");
            logicalViewName = "redirect:/thesis/thesisList.do";
        }
	    return logicalViewName;
	}
	
	
	
	
	
	
/* 잠깐만요... 코드 수정즘 할게요.
	@Inject
	private ThesisService service;
	
	@PostMapping("/thesis/thesisDelete.do")
	public String postHandler(
			ThesisVO thesis, RedirectAttributes redirectAttributes) {
		boolean success = service.removeThesis(thesis);
		String viewName = null;
		if(success) {
			viewName = "redirect:/board/boardList.do";
		}else {
			redirectAttributes.addFlashAttribute("message", "논문삭제 실패, 비밀번호를 확인해주세요.");
			viewName = "redirect:/board/boardView.do?what="+thesis.getThesSn();
		}
		return viewName;
	}
	*/
	
}