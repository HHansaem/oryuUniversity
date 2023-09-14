package kr.or.ddit.academicBusinessReport.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.academicBusinessReport.service.ABRService;
import kr.or.ddit.academicBusinessReport.vo.ABRVO;

@Controller
@RequestMapping("/academicBusinessReport/aBRUpdate.do")
public class ABRUpdateController {
	
	@Inject
	private ABRService aBRService;
	
	@GetMapping
	public String getHandler(
			Model model
			, @RequestParam(name = "what") String buReSn
			) {
		ABRVO aBRVO = aBRService.retrieveABR(buReSn);
		model.addAttribute("aBRVO", aBRVO);
		
		return "academicBusinessReport/aBREdit";
	}

	@PostMapping
	public String postHandler(
			Model model
			, @ModelAttribute("aBRVO") ABRVO aBRVO
			, BindingResult errors
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = aBRService.modifyABR(aBRVO);
			if(result == true) {
				logicalViewName = "redirect:/academicBusinessReport/aBRView.do?what=" + aBRVO.getBuReSn();
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요");
				logicalViewName = "academicBusinessReport/aBREdit";
			}
		}else {
			logicalViewName = "academicBusinessReport/aBREdit";
		}
		return logicalViewName;
	}
}
