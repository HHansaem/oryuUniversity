package kr.or.ddit.lectureContents.exam.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lectureContents.exam.service.ExamService;
import kr.or.ddit.lectureContents.examSubmission.service.ExamSubmitService;
import kr.or.ddit.lectureContents.vo.ExamQuestionVO;
import kr.or.ddit.lectureContents.vo.ExamSubmitVO;
import kr.or.ddit.lectureContents.vo.ExamVO;

@Controller
@RequestMapping("/lecture/examList.do")
public class ExamListController {
	
	@Inject
	ExamService service;
	@Inject
	ExamSubmitService submitService;
	
	@GetMapping
	public String examList(Authentication authentication, String lecCd, Model model) {
		String role = "";
		String stCd = "";
		if(authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			stCd = userDetails.getUsername();
			Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
			for (GrantedAuthority authority : authorities) {
				 role = authority.getAuthority();
			}
		}
		List<ExamVO> examList = service.retrieveExamList(lecCd);
		if(examList.size()>0) {
			for(ExamVO exam : examList) {
				if(exam.getExamType().equals("중간고사")) {
					if(role.equals("ROLE_ST")) {
						ExamSubmitVO examSubmitVO = new ExamSubmitVO(exam.getExamCd(), lecCd, stCd);
						List<ExamQuestionVO> examQueList = submitService.retrieveExamSubmit(examSubmitVO);
						if(examQueList.size()>0) {
							model.addAttribute("midScore", examQueList.get(0).getEsScore());
							model.addAttribute("midFlag", true);
						}
					}
					model.addAttribute("midterm", exam);
				}else if(exam.getExamType().equals("기말고사")){
					if(role.equals("ROLE_ST")) {
						ExamSubmitVO examSubmitVO = new ExamSubmitVO(exam.getExamCd(), lecCd, stCd);
						List<ExamQuestionVO> examQueList = submitService.retrieveExamSubmit(examSubmitVO);
						if(examQueList.size()>0) {
							model.addAttribute("finalScore", examQueList.get(0).getEsScore());
							model.addAttribute("finalFlag", true);
						}
					}
					model.addAttribute("finals", exam);
				}
			}
		}
		return "lecture/exam/examList";
	}
}
