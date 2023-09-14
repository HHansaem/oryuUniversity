package kr.or.ddit.lectureContents.exam.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lectureContents.exam.service.ExamService;
import kr.or.ddit.lectureContents.vo.ExamQuestionVO;
import kr.or.ddit.lectureContents.vo.ExamSubmitVO;
import kr.or.ddit.lectureContents.vo.ExamVO;

@Controller
@RequestMapping("/lecture/examQueView.do")
public class ExamQueDetailController {
	
	@Inject
	ExamService service;
	
	@GetMapping
	public String examQueView(Model model,String examCd,String lecCd,Authentication authentication) {
		if(authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			ExamVO exam = service.retrieveTakeExam(examCd);
			List<ExamQuestionVO> examQueList = exam.getExamQueList();
			ExamSubmitVO examSubmit = new ExamSubmitVO(examCd, lecCd, userDetails.getUsername());
			model.addAttribute("exam", exam);
			model.addAttribute("examSubmit",examSubmit);
			model.addAttribute("examQueList", examQueList);
			Collections.sort(examQueList);
		}
		return "lecture/exam/examQueView";
	}
}
