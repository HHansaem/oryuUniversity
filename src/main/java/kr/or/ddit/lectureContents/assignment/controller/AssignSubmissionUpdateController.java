package kr.or.ddit.lectureContents.assignment.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.validate.InsertGroup;
import kr.or.ddit.lectureContents.assignment.service.AssignmentService;
import kr.or.ddit.lectureContents.assignmentSub.service.AssignmentSubService;
import kr.or.ddit.lectureContents.vo.AssignmentSubVO;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.validate.groups.UpdateGroup;

@Controller
@RequestMapping("/lecture/assignSubmissionUpdate.do")
public class AssignSubmissionUpdateController {
	
	@Inject
	AssignmentSubService service;
	
	@PostMapping(produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String assignSubmissionUpdate(AssignmentSubVO assignSubmission) {
		String message = null;
		ServiceResult result = service.modifyAssignSubmission(assignSubmission);
		switch(result) {
			case OK:
				message = "성공";
				break;
			case FAIL:
				message = "실패";
				break;
			default:
				message = "오류";
				break;
		}

		return message;
		
	}

}
