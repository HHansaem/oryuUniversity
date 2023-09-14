package kr.or.ddit.student.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.student.service.StudentService;

@Controller
public class StudentDeleteController {
	@Inject
	private StudentService service;
	
	@PostMapping("/student/studentDelete.do")
	public String postHandler(
		@RequestParam("who") String stCd
		, Model model
	){
		ServiceResult result = service.removeStudent(stCd);
		if(ServiceResult.OK == result) {
			model.addAttribute("result", "삭제완료");
		}else {
			model.addAttribute("result", "오류");
		}
		return "jsonView";
	}
}
