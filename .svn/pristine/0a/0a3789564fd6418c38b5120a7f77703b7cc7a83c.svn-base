package kr.or.ddit.thesis.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.thesis.service.ThesisService;
import kr.or.ddit.thesis.vo.ThesisVO;
import kr.or.ddit.validate.groups.InsertGroup;
import lombok.RequiredArgsConstructor;

@Controller // 해당 클래스가 컨트롤러임을 나타냅니다.
@RequestMapping("/thesis/thesisInsert.do") // "/thesis/thesisInsert.do"로 시작하는 모든 요청을 이 컨트롤러가 처리합니다.
public class ThesisInsertController {

	@Inject // 의존성 주입(Dependency Injection)을 위해 ThesisService 객체를 주입받습니다.
	private ThesisService thesisService;

	// GET 방식으로 요청이 들어왔을 때, 비어있는 ThesisVO 객체를 반환하는 메서드입니다.
	@ModelAttribute("thesisVO")
	public ThesisVO thesisVO() {
		return new ThesisVO();
	}
	
	/**
	 * thesisForm 제공
	 * HTTP GET 방식으로 /thesis/thesisInsert.do에 접근하면 호출되는 메서드입니다.
	 * 뷰 페이지인 "thesis/thesisForm"으로 이동합니다.
	 */
	@GetMapping
	public String getHandler() {
		return "thesis/thesisForm";
	}

	/**
	 * HTTP POST 방식으로 /thesis/thesisInsert.do에 접근하면 호출되는 메서드입니다.
	 * 폼에서 입력한 데이터를 ThesisVO 객체로 바인딩하고, 검증(Validated) 작업을 수행합니다.
	 * 검증 결과에 따라 논문 등록을 수행하고, 결과에 따라 다른 뷰 페이지로 이동합니다.
	 */
	@PostMapping
	public String postHandler(
			@ModelAttribute("thesisService") ThesisVO thesisVO
			, Errors errors
			, Model model
			){
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			boolean result = thesisService.createThesis(thesisVO);
			if(result == true) {
				logicalViewName = "redirect:/thesis/thesisList.do";
			}else {
				model.addAttribute("message", "등록 중 문제 발생");
				logicalViewName = "thesis/thesisForm";
			}
		}else {
			logicalViewName = "thesis/thesisForm";
		}
		
		return logicalViewName;
	}
}
