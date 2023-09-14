package kr.or.ddit.research.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.acBuDoc.vo.AcBuDocVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.research.service.ResearchService;
import kr.or.ddit.research.vo.ResearchVO;

@Controller
@RequestMapping("/research")
public class ResearchRetrieveController {

	@Inject
	private ResearchService researchService;
	
	@RequestMapping("researchList.do")
	public void researchList(
			@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage
			,@ModelAttribute("simpleCondition") SimpleCondition simpleCondition
			, Model model
			) {
		PaginationInfo<ResearchVO> paging = new PaginationInfo<ResearchVO>();
		paging.setSimpleCondition(simpleCondition);
		paging.setCurrentPage(currentPage);
		
		List<ResearchVO> researchList = researchService.retrieveResearchList(paging);
		paging.setDataList(researchList);
		
		model.addAttribute("paging", paging);
		
		// 총 레코드 수 조회
		long totalRecord = researchService.getTotalRecordCount(paging);
		model.addAttribute("totalRecord", totalRecord);
		
	}
	@RequestMapping("researchView.do")
	public void researchview(
			@RequestParam("what") String reseCd
			,Model model
	) {
		
		ResearchVO researchVO = researchService.retrieveResearch(reseCd);
		model.addAttribute("researchVO", researchVO);
	}
	
	
	
}
