package kr.or.ddit.club.controller;



import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import kr.or.ddit.club.service.ClubService;
import kr.or.ddit.club.vo.ClubVO;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.vo.StudentVO;
//학생 동아리신청서 작성 컨트롤러
@Controller
@RequestMapping("/club/clubInsertRequest.do")
public class StudenClubInsertRequest {
	
	@Inject
	private ClubService service;
	
	@Inject
	private StudentService stuService;
	
	
	@ModelAttribute("club")// ("")이름을 지정하고 그 지정된 이름은 jsp에도 있어야 한다
	public ClubVO club() {
		
		return new ClubVO();
	}
	
	
	/**
	 * insert폼으로 이동
	 * @return
	 */
	@GetMapping
	public String getMapping(Authentication authentication,
			Model model, 
			RedirectAttributes redirectAttributes) {
	    ClubVO check = service.checkClub(Integer.parseInt(authentication.getName()));
	    if (check == null) {
	        StudentVO info = stuService.retrieveStudent(authentication.getName());
	        model.addAttribute("info", info);
	        return "club/clubInsertRequest";
	    } else if (check.getClubStatus().equals("신청") || check.getClubStatus().equals("확인")) {
	        String message = "개설 요청 처리 중 입니다.";
	        redirectAttributes.addFlashAttribute("message", message);
	        return "redirect:/club/clubInsertRequestListView.do";
	    } else {
	    	StudentVO info = stuService.retrieveStudent(authentication.getName());
	        model.addAttribute("info", info);
	        return "club/clubInsertRequest";
	    }
	}
	
	
	@PostMapping
	/**
	 * insert폼에서 받은 데이터 db에 입력후 이동
	 * @param model
	 * @param club
	 * @param errors
	 * @return
	 */
	public String clubInsertPost(
			Model model
			, @ModelAttribute("club") ClubVO club
			, Errors errors
			) {
		String logicalViewName = null;
		if(!errors.hasErrors()) {
			
			boolean result = service.createInsertRequest(club);//db에 jsp입력 폼에서 가져온 데이터 삽입
			if(true == result) {
				logicalViewName = "redirect:/club/clubInsertRequestListView.do";// 성공시 동아리 개설 신청 목록 보기로 이동
			}else {
				logicalViewName = "club/clubInesertRequest";// 실패시 작성폼으로 이동
			}
		}else {
			logicalViewName = "club/clubInesertRequest";// 실패시 작성폼으로 이동
		}
		return logicalViewName;
	}
	
	
	
}
