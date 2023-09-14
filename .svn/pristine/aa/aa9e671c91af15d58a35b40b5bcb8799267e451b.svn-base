package kr.or.ddit.acBuDoc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.acBuDoc.service.AcBuDocService;
import kr.or.ddit.acBuDoc.vo.AcBuDocVO;
import kr.or.ddit.acBuDoc.vo.DocumentSummaryVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/acBuDoc")
public class AcBuDocRetrieveContoller {

	private final AcBuDocService acBuDocService;

	@RequestMapping("acBuDocList.do")
	public void acBuDocList(@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage
			,@ModelAttribute("simpleCondition") SimpleCondition simpleCondition
			, Model model
			) {
		PaginationInfo<AcBuDocVO> paging = new PaginationInfo<AcBuDocVO>();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);

		List<AcBuDocVO> acBuDocList = acBuDocService.retrieveAcBuDocList(paging);
		paging.setDataList(acBuDocList);

		model.addAttribute("paging", paging);

		// 총 레코드 수 조회
		long totalRecord = acBuDocService.getTotalRecordCount(paging);
		model.addAttribute("totalRecord", totalRecord);
		
		List<DocumentSummaryVO> documentSummaryList = acBuDocService.getDocumentSummaries();
		model.addAttribute("documentSummaryList" , documentSummaryList);
		
		List<DocumentSummaryVO> rankList = acBuDocService.getRank();
		model.addAttribute("rankList", rankList);
	}
	
	@RequestMapping("acBuDocView.do")
	public void acBuDocView(
			@RequestParam("what") String buDocCd
			, Model model
	) {
		AcBuDocVO acBuDocVO = acBuDocService.retrieveAcBuDoc(buDocCd);
		model.addAttribute("acBuDocVO", acBuDocVO);
	}
	
	@RequestMapping("acBuDocMngList.do")
	public void acBuDocMngList (
		@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage
		,@ModelAttribute("simpleCondition") SimpleCondition simpleCondition
		, Model model
				){
			PaginationInfo<AcBuDocVO> paging = new PaginationInfo<AcBuDocVO>();
			paging.setCurrentPage(currentPage);
			paging.setSimpleCondition(simpleCondition);
					
			List<AcBuDocVO> acBuDocMngList = acBuDocService.retrieveAcBuDocEvNmList(paging);
			paging.setDataList(acBuDocMngList);
			
			model.addAttribute("paging", paging);
			
			long totalRecord = acBuDocService.getTotalRecordCount(paging);
			model.addAttribute("totalRecord", totalRecord);
			
				}
	
}
