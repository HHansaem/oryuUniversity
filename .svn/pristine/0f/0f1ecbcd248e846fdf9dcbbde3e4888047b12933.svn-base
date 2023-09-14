package kr.or.ddit.researchJournal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.researchJournal.service.ResearchJournalService;
import kr.or.ddit.researchJournal.vo.ResearchJournalVO;
import kr.or.ddit.serviceresult.ServiceResult;

@Controller
@RequestMapping("/researchJournal/researchJournalUpdate.do")
public class ResearchJournalUpdateController {

	private ResearchJournalService service;
	
	public String updateForm(
			Model model
			, @RequestParam("who") int rjSn
		) {
			ResearchJournalVO researchJournal = service.retrieveResearchJournal(rjSn);
			model.addAttribute("researchJournal", researchJournal);
			
			return "researchJournal/researchJournalEdit";
		}
	
	@PostMapping
	public String updateProcess(
		Model model
		, @ModelAttribute("researchJournal") ResearchJournalVO researchJournal
		, Errors errors
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyResearchJournal(researchJournal);
			if(ServiceResult.OK == result) {
				logicalViewName = "redirect:/researchJournal/researchJournalView.do?who="+researchJournal.getRjSn();
			}else {
				logicalViewName = "researchJournal/researchJournalEdit";
			}
		}else {
			logicalViewName = "researchJournal/researchJournalEdit";
		}
		return logicalViewName;
	}
}
