package kr.or.ddit.staff.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.staff.service.StaffService;
import kr.or.ddit.staff.vo.StaffVO;
import kr.or.ddit.student.vo.StudentVO;
import kr.or.ddit.validate.groups.UpdateGroup;

@Controller
public class StaffMypageUpdateController {

	@Inject
	private StaffService service;
	@Inject
	private PasswordEncoder encoder;
	
	@PostMapping("/mypage/staffUpdateCheck.do")
	public String updateCheck(
		@RequestParam("who") String tsCd
		, @RequestParam("password") String password
		, Model model
	){
		StaffVO staff = service.retrieveStaff(tsCd);
		String originPass = staff.getTsPass();
		
		model.addAttribute("staff", staff);
		
		if(encoder.matches(password, originPass)) {
			model.addAttribute("result", "일치");
		}else {
			model.addAttribute("result", "불일치");
		}
		return "jsonView";
	}
	
	@GetMapping("/mypage/staffMypageEdit.do")
	public String goStaffMypageEdit(
		@RequestParam("who") String tsCd
		, Model model
	){
		StaffVO staff = service.retrieveStaff(tsCd);
		model.addAttribute("staff", staff);
		
		return "staff/staffMypageEdit";
	}
	
	@PostMapping("/mypage/staffUpdate.do")
	public String updateProcess(
		@Validated(UpdateGroup.class) @ModelAttribute("staff") StaffVO staff
		, HttpSession session
		, BindingResult errors
		, Model model
	) {
		String plain = staff.getTsPass();
		String encoded = encoder.encode(plain);
		staff.setTsPass(encoded);
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyStaff(staff);
			if(ServiceResult.OK == result) {
				model.addAttribute("result", "수정완료");
				session.removeAttribute("memImage");
				session.setAttribute("memImage", staff.getTsFic());
			}else {
				model.addAttribute("result", "수정실패");
			}
		}else {
			model.addAttribute("result", "수정실패");
		}
		return "jsonView";
	}
	
}
