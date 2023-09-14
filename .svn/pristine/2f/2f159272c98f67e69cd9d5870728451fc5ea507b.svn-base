package kr.or.ddit.academicChange.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.academicChange.service.AcademicChangeService;
import kr.or.ddit.academicChange.vo.AcademicChangeVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/academicChange/ChangeRequest.do")
public class AcademicChangeRequest {
	@Inject
	private AcademicChangeService service;
	
	@Inject
	private StudentService stuService;
	
	@ModelAttribute("change")// ("")이름을 지정하고 그 지정된 이름은 jsp에도 있어야 한다
	public AcademicChangeVO change() {

		return new AcademicChangeVO();
	}
		
	
	
	
	
	@GetMapping
	/**
	 * 학적변경신청 폼으로 이동
	 * @return
	 */
	public String getMapping( 
			Model model
			, Authentication principal
			) {
		
		log.info("확인 : "+principal.getName());
		StudentVO info = new StudentVO(); // 휴학 신청 할 학생의 기본 정보를 담을 vo
		info = stuService.retrieveStudent(principal.getName()); // db에서 학생 정보를 가져와 학생 vo에 담음
		model.addAttribute("info", info);// model에 담아 학적변동 신청서 폼에 전송
		return "academicChange/acaChangeReqForm";
	}
		

	
	@PostMapping
	/**
	 * 학적변경신청 폼에서 받은 데이터 db에 입력후 이동
	 * @param model
	 * @param club
	 * @param errors
	 * @return
	 */
	public String clubInsertPost(
			Model model
			, @ModelAttribute("change") AcademicChangeVO change
			, Authentication principal
			, Errors errors
			, RedirectAttributes redirectAttributes
			) {
		log.info("확인 "+change);
		String viewName= null;
	 boolean success = service.insertAcaChange(change);// jsp에 작성된 데이터를 db에 넣어준다.
	 if(!errors.hasErrors()) {// 학적 변동 신청이 에러가 났는지 확인하는 코드이다.
	 if(success) { //성공 할시 학적변동 신청서 목록 페이지로 이동한다.
			viewName= "redirect:/academicChange/acaChangeList.do?who="+principal.getName();
		}else {// 학적 변동 신청에 오류가 생길시 다시 신청하는 폼으로 이동시킨다.
			model.addAttribute("message", "학적변경 신청 에러발생");
			viewName= "academicChange/acaChangeReqForm";
		}
	
	}else {// 학적 변동 신청에 오류가 생길시 다시 신청하는 폼으로 이동시킨다.
		viewName= "academicChange/acaChangeReqForm";
	}
	return viewName;
	 
}
}