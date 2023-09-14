package kr.or.ddit.lectureContents.exam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.validate.InsertGroup;
import kr.or.ddit.common.validate.UpdateGroup;
import kr.or.ddit.lectureContents.exam.service.ExamService;
import kr.or.ddit.lectureContents.vo.ExamQuestionVO;
import kr.or.ddit.lectureContents.vo.ExamVO;
import kr.or.ddit.serviceresult.ServiceResult;

@Controller
@RequestMapping("/lecture")
public class ExamUpdateController {
	
	@Inject
	ExamService service;
	
	@PostMapping(value="/examUpdate.do", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> examModify(@Validated(UpdateGroup.class) ExamVO exam, Errors errors) {
		Map<String, Object> respMap = new HashMap<>();
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyExam(exam);
			switch(result) {
			case OK:
				respMap.put("result", "성공");
				respMap.put("examCd", exam.getExamCd());
				break;
			case FAIL:
				respMap.put("result", "실패");
			}
		}else {
			respMap.put("result", "실패");
		}
		
		return ResponseEntity.ok(respMap);
	}
	
	@PostMapping(value="/examStateUpdate.do", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> examStateModify(@Validated(UpdateGroup.class) ExamVO exam, Errors errors) {
		Map<String, Object> respMap = new HashMap<>();
		if(!errors.hasErrors()) {
			ServiceResult result = service.modifyExamState(exam);
			switch(result) {
			case OK:
				respMap.put("result", "성공");
				break;
			case FAIL:
				respMap.put("result", "실패");
			}
		}else {
			respMap.put("result", "실패");
		}
		
		return ResponseEntity.ok(respMap);
	}
}
