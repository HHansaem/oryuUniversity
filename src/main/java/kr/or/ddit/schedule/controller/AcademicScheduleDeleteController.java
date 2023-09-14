package kr.or.ddit.schedule.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.schedule.service.AcademicScheduleService;
import kr.or.ddit.schedule.vo.AcademicScheduleVO;

@Controller
public class AcademicScheduleDeleteController {
	
	@Inject
	private AcademicScheduleService service;
	
	@GetMapping("/schedule/acaScheduleDelete.do")
	public String getHandler(
			Model model
			, @RequestParam(name = "what") String asCd
	) {
		AcademicScheduleVO acaSchedule = service.retrieveAcademicSchedule(asCd);
		
		 String logicalViewName = null;
		    boolean result = service.removeAcademicSchedule(acaSchedule);
		    if (result) {
	            logicalViewName = "redirect:/schedule/acaScheduleList.do";
	        } else {
	            model.addAttribute("message", "공지사항 삭제 중 문제 발생");
	            logicalViewName = "redirect:/schedule/acaScheduleList.do";
	        }
		    return logicalViewName;
	}
}
