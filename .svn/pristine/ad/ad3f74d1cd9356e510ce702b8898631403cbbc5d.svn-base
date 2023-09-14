package kr.or.ddit.student.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.vo.StudentVO;

@Controller
public class StudentMypageController {

	@Inject
	private StudentService service;
	
	@RequestMapping("/mypage/studentView.do")
	public String mypageView(
		Authentication authentication
		, Model model
	){
		String stCd = authentication.getName();
		StudentVO student = service.retrieveStudent(stCd);
		model.addAttribute("student", student);
		
		return "student/studentMypageView";
	}
	
}
