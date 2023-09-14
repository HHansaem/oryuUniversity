package kr.or.ddit.academicBusinessPlan.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.academic.service.AcademicNoticeService;
import kr.or.ddit.academic.vo.AcademicNoticeVO;
import kr.or.ddit.academicBusinessPlan.service.ABPService;
import kr.or.ddit.academicBusinessPlan.vo.ABPVO;

@Controller
@RequestMapping("/academicBusinessPlan/aBPUpdate.do")
public class ABPUpdateController {
	
	@Inject
	private ABPService aBPService;
	
	@GetMapping
	public String getHandler(
			Model model
			, @RequestParam(name = "what") String buPlSn
	) {
		ABPVO aBPVO = aBPService.retrieveABP(buPlSn);
		
		model.addAttribute("aBPVO", aBPVO);
		
		return "academicBusinessPlan/aBPEdit";
	}
	
	@PostMapping
	public String postHandler(
			Model model
			, @ModelAttribute("aBPVO") ABPVO aBPVO
			, BindingResult errors
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = aBPService.modifyABP(aBPVO);
			if(result == true) {
				logicalViewName = "redirect:/academicBusinessPlan/aBPView.do?what=" + aBPVO.getBuPlSn();
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요");
				logicalViewName = "academicBusinessPlan/aBPEdit";
			}
		}else {
			logicalViewName = "academicBusinessPlan/aBPEdit";
		}
		return logicalViewName;
	}
}