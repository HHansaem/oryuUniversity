package kr.or.ddit.lectureContents.examSubmission.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lectureContents.examSubmission.service.ExamSubmitService;


@Controller
@RequestMapping("lecture/examSubmitList.do")
public class ExamSubmitListController {
	
	@Inject
	ExamSubmitService service;
	
	@PostMapping
	public String getExamSubmitList(Model model,String examCd) {
		model.addAttribute("examSubmitList", service.retrieveExamSubmitList(examCd));
		return "lecture/exam/ajax/examSubmitList";
	}
	
}
