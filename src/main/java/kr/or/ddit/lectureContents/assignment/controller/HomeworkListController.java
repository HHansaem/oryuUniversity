package kr.or.ddit.lectureContents.assignment.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

import kr.or.ddit.lectureContents.assignment.service.AssignmentService;
import kr.or.ddit.lectureContents.vo.AssignmentVO;

@Controller
@RequestMapping("/lecture/homeworkList.do")
public class HomeworkListController {
	
	@Inject
	AssignmentService service;
	
	@GetMapping
	public String homeworkList(Authentication authentication, String lecCd, Model model) {
		String role = "";
		if(authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
			for (GrantedAuthority authority : authorities) {
				 role = authority.getAuthority();
			}
		}
		
		List<AssignmentVO> assignmentList =service.retrieveAssignmentList(lecCd);
		List<AssignmentVO> closedAssign = new ArrayList<>();
		List<AssignmentVO> openAssign = new ArrayList<>();
		for(AssignmentVO assign : assignmentList) {
			if(LocalDateTime.now().isAfter(assign.getAssiPeriod())) {
				closedAssign.add(assign);
			}else if(LocalDateTime.now().isBefore(assign.getAssiPeriod())) {
				openAssign.add(assign);
			}
		}
		model.addAttribute("openAssign",openAssign);
		model.addAttribute("closedAssign",closedAssign);
		
		if(role.equals("ROLE_ST")) {
			return "lecture/homework/homeworkList";
		}
		
		return "lecture/homework/prfHomeworkList";
	}
	
}
