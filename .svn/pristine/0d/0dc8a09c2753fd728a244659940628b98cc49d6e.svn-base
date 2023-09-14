package kr.or.ddit.staff.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.staff.service.StaffService;
import kr.or.ddit.staff.vo.StaffVO;
import kr.or.ddit.student.vo.StudentVO;
import kr.or.ddit.validate.groups.InsertGroup;

@Controller
@RequestMapping("/staff/staffInsert.do")
public class StaffInsertController {

	@Inject
	private StaffService service;
	
	@ModelAttribute("staff")
	public StaffVO staff() {
		return new StaffVO();
	}
	
	@GetMapping
	public String getHandler() {
		return "staff/ajax/staffForm";
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> postHandler(
		@Validated(InsertGroup.class) @ModelAttribute("staff") StaffVO staff
		, Errors errors
		, Model model
	) {
		Map<String, Object> respMap = new HashMap<>();
		if(!errors.hasErrors()) {
			ServiceResult result = service.createStaff(staff);
			switch(result) {
			case PKDUPLICATE:
				respMap.put("result", "중복");
				break;
			case OK:
				respMap.put("result", "성공");
				break;
			default:
				respMap.put("result", "실패");
				break;
			}
		}else {
			respMap.put("result", "실패");
			}
		return ResponseEntity.ok(respMap);
	}
	
}