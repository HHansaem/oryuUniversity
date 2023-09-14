package kr.or.ddit.staff.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.staff.service.StaffService;

@Controller
public class StaffDeleteController {
	@Inject
	private StaffService service;
	
	@PostMapping("/staff/staffDelete.do")
	public String postHandler(
		@RequestParam("who") String tsCd
		, Model model
	){
		ServiceResult result = service.removeStaff(tsCd);
		if(ServiceResult.OK == result) {
			model.addAttribute("result", "삭제완료");
		}else {
			model.addAttribute("result", "오류");
		}
		return "jsonView";
	}
}
