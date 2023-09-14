package kr.or.ddit.researchJournal.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.researchJournal.service.ResearchJournalService;
import kr.or.ddit.researchJournal.vo.ResearchJournalVO;

@Controller
public class ResearchJournalRetrieveController {
	
	@Inject
	private ResearchJournalService service;
	
	@RequestMapping("/researchJournal/researchJournalList.do")
	public String list(
		@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
		, SimpleCondition simpleCondition
		, Model model
	){
		PaginationInfo<ResearchJournalVO> paging = new PaginationInfo<>(5, 3);
		paging.setSimpleCondition(simpleCondition);
		paging.setCurrentPage(currentPage);
		
		List<ResearchJournalVO> researchJournalList = service.retrieveResearchJournalList(paging);
		paging.setDataList(researchJournalList);
		
		model.addAttribute("paging", paging);
		
		return "researchJournal/researchJournalList";
		
	}
	
	@RequestMapping("/researchJournal/researchJournalView.do")
	public ModelAndView view(
			@RequestParam(name="who") int rjSn
	) {
		
		ResearchJournalVO researchJournal = service.retrieveResearchJournal(rjSn);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("researchJournal", researchJournal);
			mav.setViewName("researchJournal/researchJournalView");
			return mav;
	}

}
