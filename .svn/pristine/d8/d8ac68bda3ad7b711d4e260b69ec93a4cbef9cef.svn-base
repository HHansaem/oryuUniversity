package kr.or.ddit.acBuDoc.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.acBuDoc.service.AcBuDocService;
import kr.or.ddit.acBuDoc.vo.AcBuDocVO;


@Controller
@RequestMapping("/acBuDoc")
public class AcBuDocUpdateController {
	
	@Inject
	private AcBuDocService acBuDocService;
	
//	@ModelAttribute("acBuDocVO")
//	public AcBuDocVO  acBuDoc(String what){
//		AcBuDocVO acBuDocVO = new AcBuDocVO();
//		return acBuDocVO;
//	}
	
	@GetMapping("/acBuDocUpdate.do")
	public String getHandler(
			Model model
			, @RequestParam(name = "what") String buDocCd
	) {
		AcBuDocVO acBuDocVO = acBuDocService.retrieveAcBuDoc(buDocCd);
		if(acBuDocVO == null) {
			acBuDocVO = new AcBuDocVO();
		}
		model.addAttribute("acBuDocVO", acBuDocVO);
		
		return "acBuDoc/acBuDocEdit";
	}
	
	@GetMapping("/acBuDocMngEdit.do")
	public String getAjaxHandler(
			Model model
			, String buDocCd
	) {
		AcBuDocVO acBuDocVO = acBuDocService.retrieveAcBuDoc(buDocCd);
		if(acBuDocVO == null) {
			acBuDocVO = new AcBuDocVO();
		}
		model.addAttribute("acBuDocVO", acBuDocVO);
		
		return "acBuDoc/ajax/acBuDocMngEdit";
	}
	
	@PostMapping("/acBuDocUpdate.do")
	public String postHandler(
			Model model
			, @ModelAttribute("acBuDocVO") AcBuDocVO acBuDocVO
			, BindingResult errors
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = acBuDocService.modifyAcBuDoc(acBuDocVO);
			if(result == true) {
				logicalViewName = "redirect:/acBuDoc/acBuDocView.do?what=" + acBuDocVO.getBuDocCd();
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요");
				logicalViewName = "acBuDoc/acBuDocEdit";
			}
		}else {
			logicalViewName = "acBuDoc/acBuDocEdit";
		}
		return logicalViewName;
	}
	
	@PostMapping("/acBuDocMngEdit.do")
	public String postMngHandler(
			Model model
			, AcBuDocVO acBuDocVO
			, BindingResult errors
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = acBuDocService.modifyAcBuDoc(acBuDocVO);
			if(result == true) {
				model.addAttribute("message", "평가가 성공적으로 완료되었습니다.");
				logicalViewName = "redirect:/acBuDoc/acBuDocMngList.do";
			}else {
				model.addAttribute("message", "서버 오류, 잠시 뒤 다시 시도하세요");
				logicalViewName = "redirect:/acBuDoc/acBuDocMngList.do";
			}
		}else {
			logicalViewName = "redirect:/acBuDoc/acBuDocMngList.do";
			model.addAttribute("message", "평가가 실패하였습니다.");
		}
		return logicalViewName;
	}
}


