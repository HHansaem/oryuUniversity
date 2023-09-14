package kr.or.ddit.lectureContents.assignment.controller;

import java.util.Collection;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.lectureContents.assignment.service.AssignmentService;
import kr.or.ddit.lectureContents.assignmentSub.service.AssignmentSubService;
import kr.or.ddit.lectureContents.vo.AssignmentSubVO;
import kr.or.ddit.lectureContents.vo.AssignmentVO;

@Controller
public class HomeworkDetailController {
	@Inject
	AssignmentService service;
	@Inject
	AssignmentSubService subService;
	
	@GetMapping
	@RequestMapping("/lecture/homeworkDetail.do")
	public String assignment(String assiCd, Model model,HttpServletRequest request,Authentication authentication){
		if(authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
			String role = "";
			for (GrantedAuthority authority : authorities) {
				 role = authority.getAuthority();
			}
			if(role.equals("ROLE_ST")) {
				String lecCd = (String)request.getSession().getAttribute("lecCd");
				AssignmentSubVO assignSubmission = new AssignmentSubVO(lecCd,assiCd,userDetails.getUsername());
				assignSubmission = subService.retrieveAssignSubmissionDetail(assignSubmission);
				if(assignSubmission == null) {
					assignSubmission = new AssignmentSubVO(lecCd,assiCd,userDetails.getUsername());
				}
				AssignmentVO assign = service.retrieveAssignmentDetail(assiCd);
				model.addAttribute("assign",assign);
				model.addAttribute("assignSubmission",assignSubmission);
				return "lecture/homework/homeworkView";
			}
		}
		AssignmentVO assign = service.retrieveAssignmentDetail(assiCd);
		model.addAttribute("assign",assign);
		return "lecture/homework/homeworkView";
	}
	
	@PostMapping
	@RequestMapping("lecture/homeworkStDetail.do")
	public String assignView(String assiCd, Model model,HttpServletRequest request,Authentication authentication) {
		String lecCd = (String)request.getSession().getAttribute("lecCd");
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		AssignmentSubVO assignSubmission = new AssignmentSubVO(lecCd,assiCd,userDetails.getUsername());
		assignSubmission = subService.retrieveAssignSubmissionDetail(assignSubmission);
		if(assignSubmission == null) {
			assignSubmission = new AssignmentSubVO(lecCd,assiCd,userDetails.getUsername());
		}
		AssignmentVO assign = service.retrieveAssignmentDetail(assiCd);
		model.addAttribute("assign",assign);
		model.addAttribute("assignSubmission",assignSubmission);
		return "lecture/homework/ajax/homeworkStView";
	}
	
}
