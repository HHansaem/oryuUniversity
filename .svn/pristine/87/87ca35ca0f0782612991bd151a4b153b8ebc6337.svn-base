package kr.or.ddit.researchJournal.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.researchJournal.service.ResearchJournalService;
import kr.or.ddit.researchJournal.vo.ResearchJournalVO;
import kr.or.ddit.serviceresult.ServiceResult;

@Controller
@RequestMapping("/researchJournal/researchJournalInsert.do")
public class ResearchJournalInsertController {

	@Inject
	private ResearchJournalService service;
	
	@ModelAttribute("researchJournal")
	public ResearchJournalVO researchJournal() {
		return new ResearchJournalVO();
	}
	
	@GetMapping
	public String getHandler() {
		return "researchJournal/researchJournalForm";
	}
	
	@PostMapping
	public String postHandler(
		Model model
		, @ModelAttribute("researchJournal") ResearchJournalVO researchJournal
		, Errors errors
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.createResearchJournal(researchJournal);
			if(ServiceResult.OK == result) {
				logicalViewName = "redirect:/researchJournal/researchJournalView.do?who="+researchJournal.getRjSn();
			}else {
				logicalViewName = "researchJournal/researchJournalForm";
			}
		}else {
			logicalViewName = "researchJournal/researchJournalForm";
		}
		return logicalViewName;
	}
	
}
