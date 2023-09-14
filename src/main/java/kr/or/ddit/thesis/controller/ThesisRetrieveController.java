package kr.or.ddit.thesis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.acBuDoc.service.AcBuDocService;
import kr.or.ddit.acBuDoc.vo.AcBuDocVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.student.vo.StudentVO;
import kr.or.ddit.thesis.service.ThesisService;
import kr.or.ddit.thesis.vo.ThesisVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor // RequiredArgsConstructor는 생성자 주입
@Controller //컨트롤러 등록
@RequestMapping("/thesis")
public class ThesisRetrieveController {

	private final ThesisService thesisService;

	@RequestMapping("thesisList.do")
	public void thesisList(@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage
			,@ModelAttribute("simpleCondition") SimpleCondition simpleCondition
			, Model model
			) {
		PaginationInfo<ThesisVO> paging = new PaginationInfo<ThesisVO>();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);

		List<ThesisVO> thesisList = thesisService.retrieveThesisList(paging);
		paging.setDataList(thesisList);

		model.addAttribute("paging", paging);

		// 총 레코드 수 조회
		long totalRecord = thesisService.getTotalRecordCount(paging);
		model.addAttribute("totalRecord", totalRecord);
	}
	
	@RequestMapping("thesisView.do")
	public void thesisView(
			@RequestParam("what") String thesSn
			, Model model
	) {
		ThesisVO thesisVO = thesisService.retrieveThesis(thesSn);
		model.addAttribute("thesisVO", thesisVO);
	}
	
}
