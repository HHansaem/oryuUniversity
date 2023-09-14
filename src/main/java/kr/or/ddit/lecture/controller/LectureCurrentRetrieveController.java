package kr.or.ddit.lecture.controller;


import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.enrollment.service.EnrollmentService;
import kr.or.ddit.enrollment.vo.EnrollmentVO;
import kr.or.ddit.lecture.service.LectureService;
import kr.or.ddit.lecture.vo.LectureVO;
import kr.or.ddit.lectureContents.assignment.service.AssignmentService;

@Controller
public class LectureCurrentRetrieveController {
	
	@Inject
	LectureService lectureService;
	@Inject
	EnrollmentService enrollmentService;
	
	@GetMapping("/lecture/currentLectureView.do")
	public String currentLecture(Authentication authentication, Model model) {
		if(authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
			String role = "";
			for (GrantedAuthority authority : authorities) {
				 role = authority.getAuthority();
			}
			if(role.equals("ROLE_ST")) {
				List<EnrollmentVO> enrollmentList = enrollmentService.retrieveSTEnrollmentList(userDetails.getUsername());
				model.addAttribute("enrollmentList", enrollmentList);
			}else if(role.equals("ROLE_PR")) {
				List<LectureVO> lectureList = lectureService.retrieveCurrentLectureList(userDetails.getUsername());
				model.addAttribute("lectureList", lectureList);
			}
		}
		return "lecture/currentLectureList";
	}
	
	@GetMapping("/lecture/lectureTimeTable.do")
	public String timeTable(Authentication authentication, Model model) {
		if(authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String stCd = userDetails.getUsername();
			List<EnrollmentVO> lectureList = lectureService.retrieveTimeTable(stCd);
			List<EnrollmentVO> currentList = lectureService.retrievecurrentLec(stCd);
			String[] daysOfWeek = {"월", "화", "수", "목", "금"};
			model.addAttribute("week", daysOfWeek);
			model.addAttribute("timeTable", lectureList);
			model.addAttribute("currentLec", currentList);
		}
		return "lecture/lectureTimeTable";
	}
	
	@GetMapping("/lecture/lecturePRTimeTable.do")
	public String prTimeTable(Authentication authentication, Model model) {
		if(authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			String prCd = userDetails.getUsername();
			List<LectureVO> lectureList = lectureService.retrievePRTimeTable(prCd);
			String[] daysOfWeek = {"월", "화", "수", "목", "금"};
			model.addAttribute("week", daysOfWeek);
			model.addAttribute("currentLec", lectureList);
		}
		return "lecture/lecturePRTimeTable";
	}
	
	
}
