package kr.or.ddit.subject.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.subject.service.SubjectService;
import kr.or.ddit.subject.vo.SubjectVO;

@Controller
public class SubjectDeleteController {
	@Inject
	private SubjectService service;
	
	@PostMapping("/subject/subjectDelete.do")
	@ResponseBody
	public String deleteSubject(
			String[] subjCd
	) {
		int cnt = 0;
		String result = null;
		for(String cd : subjCd) {
			SubjectVO subject = service.retrieveSubject(cd);
			cnt += service.removeSubject(subject);
		}
		if(cnt>0) {
			result="success";
		}else {
			result="fail";
		}
		return result;
	}
}
