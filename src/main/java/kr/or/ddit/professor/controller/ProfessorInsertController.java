package kr.or.ddit.professor.controller;

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
import kr.or.ddit.professor.service.ProfessorService;
import kr.or.ddit.professor.vo.ProfessorVO;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.student.dao.OthersDAO;
import kr.or.ddit.validate.groups.InsertGroup;

@Controller
@RequestMapping("/professor/professorInsert.do")
public class ProfessorInsertController {

	@Inject
	private ProfessorService service;
	@Inject
	private OthersDAO othersDAO;
	
	@ModelAttribute("professor")
	public ProfessorVO professor() {
		return new ProfessorVO();
	}
	
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList() {
		return othersDAO.selectDepartmentList();
	}
	
	@GetMapping
	public String getHandler() {
		return "professor/ajax/professorForm";
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> postHandler(
		@Validated(InsertGroup.class) @ModelAttribute("professor") ProfessorVO professor
		, Errors errors
		, Model model
	) {
		Map<String, Object> respMap = new HashMap<>();
		if(!errors.hasErrors()) {
			ServiceResult result = service.createProfessor(professor);
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
