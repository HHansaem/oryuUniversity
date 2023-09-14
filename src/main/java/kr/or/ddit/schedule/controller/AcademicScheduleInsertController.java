package kr.or.ddit.schedule.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.schedule.service.AcademicScheduleService;
import kr.or.ddit.schedule.vo.AcademicScheduleVO;

@Controller
@RequestMapping("/schedule/acaScheduleInsert.do")
public class AcademicScheduleInsertController {
	
	@Inject
	private AcademicScheduleService service;
	
	@ModelAttribute("acaSchedule")
	public AcademicScheduleVO acaSchedule() {
		return new AcademicScheduleVO();
	}
	
	@GetMapping
	public String getHandler() {
		return "schedule/acaScheduleForm";
	}
	
	@PostMapping
	public String postHandler(
			Model model
			, @ModelAttribute("acaSchedule") AcademicScheduleVO acaSchedule
			, @RequestParam(value = "asAccePerm", required = false) String[] asAccePerm
			, Errors errors
	) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			
			if(asAccePerm != null && asAccePerm.length > 0) {
				StringBuilder permissionBuilder = new StringBuilder();
				boolean isProfessorSelected = false;
				boolean isStudentSelected = false;
				
				for(String permission : asAccePerm) {
					if("professor".equals(permission)) {
						isProfessorSelected = true;
					} else if("student".equals(permission)) {
						isStudentSelected = true;
					}
				}
				
				if(isProfessorSelected && isStudentSelected) {
					acaSchedule.setAsAccePerm("BOTH");
				} else if(isProfessorSelected) {
					acaSchedule.setAsAccePerm("PROFESSOR");
				} else if(isStudentSelected) {
					acaSchedule.setAsAccePerm("STUDENT");
				} else {
					acaSchedule.setAsAccePerm("NONE");
				}
			} else {
				acaSchedule.setAsAccePerm("NONE");
			}
			
			boolean result = service.createAcademicSchedule(acaSchedule);
			if(result == true) {
				logicalViewName = "redirect:/schedule/acaScheduleList.do";
			}else {
				model.addAttribute("message", "일정 등록 중 문제 발생");
				logicalViewName = "schedule/acaScheduleForm";
			}
		}else {
			logicalViewName = "schedule/acaScheduleForm";
		}
		
		return logicalViewName;
	}
	
}






