package kr.or.ddit.staff.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.staff.service.StaffService;
import kr.or.ddit.staff.vo.StaffVO;

@Controller
public class StaffMypageController {

	@Inject
	private StaffService service;
	
	@RequestMapping("/mypage/staffView.do")
	public String staffView(
		Authentication authentication
		, Model model
	){
		String tsCd = authentication.getName();
		StaffVO staff = service.retrieveStaff(tsCd);
		model.addAttribute("staff", staff);
		
		return "staff/staffMypageView";
	}
	
}
