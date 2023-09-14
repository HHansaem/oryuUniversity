package kr.or.ddit.lectureContents.assignment.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.validate.InsertGroup;
import kr.or.ddit.lectureContents.assignment.service.AssignmentService;
import kr.or.ddit.lectureContents.vo.AssignmentVO;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.validate.groups.UpdateGroup;

@Controller
@RequestMapping("/lecture/homeworkUpdate.do")
public class HomeworkUpdateController {
	
	@Inject
	AssignmentService service;
	
	@ModelAttribute("homework")
	public AssignmentVO assignment(String assiCd){
		return service.retrieveAssignmentDetail(assiCd);
	}
	
	@GetMapping
	public String homeworkEdit() {
		return "lecture/homework/homeworkEdit";
	}
	
	@PostMapping
	public String homeworkUpdate(@Validated(UpdateGroup.class) @ModelAttribute("homework") AssignmentVO assignment
			, Errors errors, Model model) {
		String logicalViewName = null;
		if (!errors.hasErrors()) {
			ServiceResult result = service.modifyAssignment(assignment);
			switch(result) {
				case OK:
					logicalViewName = "redirect:/lecture/homeworkDetail.do?assiCd="+assignment.getAssiCd();
					break;
				case FAIL:
					logicalViewName = "lecture/homework/homeworkForm";
				default:
					model.addAttribute("message","서버 오류, 잠시 뒤 다시 시도하시오.");
					logicalViewName = "lecture/homework/homeworkForm";
					break;
			}
		} else {
			logicalViewName = "lecture/homework/homeworkForm";
		}

		return logicalViewName;
		
	}
	
	
}
