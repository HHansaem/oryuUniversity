package kr.or.ddit.student.controller;

import java.util.HashMap;
import java.util.List;
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

import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.student.dao.OthersDAO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.vo.StudentVO;
import kr.or.ddit.validate.groups.InsertGroup;

@Controller
@RequestMapping("/student/studentInsert.do")
public class StudentInsertController {

	@Inject
	private StudentService service;
	@Inject
	private OthersDAO othersDAO;
	
	@ModelAttribute("student")
	public StudentVO student() {
		return new StudentVO();
	}
	
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList() {
		return othersDAO.selectDepartmentList();
	}
	
	@GetMapping
	public String getHandler() {
		return "student/ajax/studentForm";
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> postHandler(
		@Validated(InsertGroup.class) @ModelAttribute("student") StudentVO student
		, Errors errors
		, Model model
	) {
		Map<String, Object> respMap = new HashMap<>();
		if(!errors.hasErrors()) {
			ServiceResult result = service.createStudent(student);
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
