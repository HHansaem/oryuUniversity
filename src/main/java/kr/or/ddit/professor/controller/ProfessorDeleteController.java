package kr.or.ddit.professor.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.professor.service.ProfessorService;
import kr.or.ddit.serviceresult.ServiceResult;

@Controller
public class ProfessorDeleteController {
	@Inject
	private ProfessorService service;
	
	@PostMapping("/professor/professorDelete.do")
	public String postHandler(
			@RequestParam("who") String prCd
			, Model model
		){
			ServiceResult result = service.removeProfessor(prCd);
			if(ServiceResult.OK == result) {
				model.addAttribute("result", "삭제완료");
			}else {
				model.addAttribute("result", "오류");
			}
			return "jsonView";
		}
	}
