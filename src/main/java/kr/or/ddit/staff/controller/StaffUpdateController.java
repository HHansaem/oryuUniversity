package kr.or.ddit.staff.controller;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.staff.service.StaffService;
import kr.or.ddit.staff.vo.StaffVO;

@Controller
@RequestMapping("/staff/staffUpdate.do")
public class StaffUpdateController {

	@Inject
	private StaffService service;
	
	@GetMapping
	public String updateForm(
		Model model
		, @RequestParam("who") String tsCd
	) {
		StaffVO staff = service.retrieveStaff(tsCd);
		model.addAttribute("staff", staff);
		
		return "staff/staffEdit";
	}
	
	@PostMapping
	public ResponseEntity<String> updateProcess(
		@ModelAttribute("staff") StaffVO staff
		, BindingResult errors
	) {
		String responseMessage;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyStaff(staff);
			if(ServiceResult.OK == result) {
				responseMessage = "ok";
			}else {
				responseMessage = "fail";
			}
		}else {
			responseMessage = "fail";
		}
		return ResponseEntity.ok(responseMessage);
	}
	
}
