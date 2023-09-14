package kr.or.ddit.lectureContents.examSubmission.controller;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lectureContents.examSubmission.service.ExamSubmitService;
import kr.or.ddit.lectureContents.vo.ExamQuestionVO;
import kr.or.ddit.lectureContents.vo.ExamSubmitVO;

@Controller
@RequestMapping("/lecture/examSubmitView.do")
public class ExamSubmitViewController {
	
	@Inject
	ExamSubmitService service;
	
	@PostMapping
	public String getMyExamSubmit(Model model,String examCd, String stCd) {
		ExamSubmitVO examSubmit = new ExamSubmitVO();
		examSubmit.setExamCd(examCd);
		examSubmit.setStCd(stCd);
		List<ExamQuestionVO> examQueSubmitList  = service.retrieveExamSubmit(examSubmit);
		Collections.sort(examQueSubmitList);
		model.addAttribute("examQueSubmitList", examQueSubmitList);
		return "lecture/exam/ajax/examSubmitVIew";
	}

}
