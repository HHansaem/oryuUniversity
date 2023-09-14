package kr.or.ddit.thesis.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.acBuDoc.vo.AcBuDocVO;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.thesis.service.ThesisService;
import kr.or.ddit.thesis.vo.ThesisVO;

@Controller
@RequestMapping("/thesis/thesisUpdate.do")
public class ThesisUpdateController {

	@Inject
	private ThesisService thesisService;

	@ModelAttribute("thesisVO")	
	public ThesisVO thesisVO(String what) {
		ThesisVO thesisVO = thesisService.retrieveThesis(what);
		if(thesisVO == null) {
			thesisVO = new ThesisVO();
		}
		return thesisVO;
		
	}
	
	@GetMapping
	public String getHandler() {
		return "thesis/thesisEdit";
	}
	
	@PostMapping
	public String postHandler(
			Model model
			, @ModelAttribute("thesisVO") ThesisVO thesisVO
			, BindingResult errors
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = thesisService.modifyThesis(thesisVO);
			if(result == true) {
				logicalViewName = "redirect:/thesis/thesisView.do?what=" + thesisVO.getThesSn();
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요");
				logicalViewName = "thesis/thesisEdit";
			}
		}else {
			logicalViewName = "thesis/thesisEdit";
		}
		return logicalViewName;
	}
}
	
	

