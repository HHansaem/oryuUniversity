package kr.or.ddit.lectureContents.examSubmission.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.common.validate.InsertGroup;
import kr.or.ddit.lectureContents.examSubmission.service.ExamSubmitService;
import kr.or.ddit.lectureContents.vo.ExamSubmitVO;
import kr.or.ddit.serviceresult.ServiceResult;

@Controller
@RequestMapping("/lecture/examSubmitInsert.do")
public class ExamSubmitInsertController {
	
	@Inject
	ExamSubmitService service;
	
	@PostMapping
	public String examSubmit(@Validated(InsertGroup.class) ExamSubmitVO examSubmit, Errors errors,Model model){
		String logicalViewName = null;
		if (!errors.hasErrors()) {
			ServiceResult result = service.registerExamSubmit(examSubmit);
			switch(result) {
				case OK:
					logicalViewName = "redirect:/lecture/examList.do?lecCd="+examSubmit.getLecCd();
					break;
				case FAIL:
					logicalViewName = "lecture/examList.do?lecCd="+examSubmit.getLecCd();
				default:
					model.addAttribute("message","서버 오류, 잠시 뒤 다시 시도하시오.");
					logicalViewName = "lecture/examList.do?lecCd="+examSubmit.getLecCd();
					break;
			}
		} else {
			logicalViewName = "lecture/examList.do?lecCd="+examSubmit.getLecCd();
		}

		return logicalViewName;
	}

}
