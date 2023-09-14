package kr.or.ddit.academicBusinessReport.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.academicBusinessReport.service.ABRService;
import kr.or.ddit.academicBusinessReport.vo.ABRVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/academicBusinessReport")
public class ABRRetrieveContrller {
	
	private final ABRService aBRService;
	
	@RequestMapping("aBRList.do")
	public void aBRList(
			@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage
			, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition
			, Model model
			) {		
			PaginationInfo<ABRVO> paging = new PaginationInfo<>();
			
			paging.setCurrentPage(currentPage);
			paging.setSimpleCondition(simpleCondition);
			
			List<ABRVO> aBRList = aBRService.retrieveABRList(paging);
			paging.setDataList(aBRList);
			
			model.addAttribute("paging", paging);
			
			// 총 레코드 수 조회
	        long totalRecord = aBRService.getTotalRecordCount(paging);
	        model.addAttribute("totalRecord", totalRecord);
		}
	
	@RequestMapping("aBRView.do")
	public void aBRView(
			@RequestParam("what") String buReSn
			, Model model
	) {
		ABRVO aBRVO = aBRService.retrieveABR(buReSn);
		model.addAttribute("aBRVO", aBRVO);
	}
}


