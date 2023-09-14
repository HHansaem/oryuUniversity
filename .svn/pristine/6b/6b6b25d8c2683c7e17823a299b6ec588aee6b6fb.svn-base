package kr.or.ddit.professor.controller;

import java.util.List;

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

import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.professor.service.ProfessorService;
import kr.or.ddit.professor.vo.ProfessorVO;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.student.dao.OthersDAO;

@Controller
@RequestMapping("/professor/professorUpdate.do")
public class ProfessorUpdateController {

	@Inject
	private ProfessorService service;
	@Inject
	private OthersDAO othersDAO;
	
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList() {
		return othersDAO.selectDepartmentList();
	}

	@GetMapping
	public String updateForm(
		Model model
		, @RequestParam("who") String prCd
	) {
		ProfessorVO professor = service.retrieveProfessor(prCd);
		model.addAttribute("professor", professor);
		
		return "professor/professorEdit";
	}
	
	@PostMapping
	public ResponseEntity<String> updateProcess(
		@ModelAttribute("professor") ProfessorVO professor
		, BindingResult errors
	) {
		String responseMessage;
		
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyProfessor(professor);
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
