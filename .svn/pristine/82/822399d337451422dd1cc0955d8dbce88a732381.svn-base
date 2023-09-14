package kr.or.ddit.academicBusinessPlan.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.academicBusinessPlan.service.ABPService;
import kr.or.ddit.academicBusinessPlan.vo.ABPVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/academicBusinessPlan")
public class ABPRetrieveContrller {
	
	private final ABPService aBPService;
	
	@RequestMapping("aBPList.do")
	public void aBPList(
			@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage
			, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition
			, Model model
	) {
		PaginationInfo<ABPVO> paging = new PaginationInfo<>();
		
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		List<ABPVO> aBPList = aBPService.retrieveABPList(paging);
		paging.setDataList(aBPList);
		
		model.addAttribute("paging", paging);
		
		// 총 레코드 수 조회
        long totalRecord = aBPService.getTotalRecordCount(paging);
        model.addAttribute("totalRecord", totalRecord);
	}
	
	@RequestMapping("aBPView.do")
	public void aBPView(
			@RequestParam("what") String buPlSn
			, Model model
	) {
		ABPVO aBPVO = aBPService.retrieveABP(buPlSn);
		model.addAttribute("aBPVO", aBPVO);
	}

}
