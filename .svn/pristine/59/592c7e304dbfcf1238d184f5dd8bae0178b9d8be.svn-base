package kr.or.ddit.club.controller;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.club.service.ClubService;
import kr.or.ddit.club.vo.ClubVO;

@Controller
public class ClubUpdate {
	
	@Inject
	private ClubService service;
	
	
	@ModelAttribute("club")// ("")이름을 지정하고 그 지정된 이름은 jsp에도 있어야 한다
	public ClubVO club() {
		
		return new ClubVO();
	}
	
	/**
	 * 업데이트 폼으로 이동
	 * @param clubCd
	 * @return
	 */
	@RequestMapping("/club/clubUpdateForm.do")
	public String clubUpdateForm(
			@RequestParam(name="who") String clubCd 
			,Authentication authentication
			, Model model
			)
	{
		
		ClubVO InsertRequest = service.myClub(Integer.parseInt(authentication.getName()),clubCd);
		model.addAttribute("club", InsertRequest);
		return "club/clubUpdateForm";
	}
	
	/**
	 * 동아리 수정
	 * @param model
	 * @param club
	 * @param errors
	 * @return
	 */
	@RequestMapping("/club/clubUpdateRequest.do")
	public String clubUpdate(
			Model model
			, @ModelAttribute("club") ClubVO club
			, Errors errors
			, RedirectAttributes redirectAttributes
			, Authentication authentication
			)
	{
		int UpdateRequest = service.clubUpdateRequest(club);
		
		String logicalViewName=null;
	switch (UpdateRequest) {
	case 0:
		
		ClubVO InsertRequest = service.myClub(Integer.parseInt(authentication.getName()),club.getClubCd());
		model.addAttribute("club", InsertRequest);
		model.addAttribute("message", "요청처리 실패");
		logicalViewName = "club/clubUpdateForm";
		break;
	case 1:
		logicalViewName = "redirect:/club/myClubView.do";
		break;
	}
	return logicalViewName;
		
	}
	/**
	 * 동아리 폐부
	 * @param model
	 * @param club
	 * @param errors
	 * @param redirectAttributes
	 * @param authentication
	 * @return
	 */
	@RequestMapping("/club/clubClosed.do")
	public String clubClosed(
			Model model
			, @RequestParam(name="what") String clubCd
			, RedirectAttributes redirectAttributes
			, Authentication authentication
			) {
		
		
int UpdateRequest = service.clubClosed(clubCd);
		
		String logicalViewName=null;
	switch (UpdateRequest) {
	case 0:
		model.addAttribute("message", "폐부 처리 실패");
		logicalViewName = "club/myClubView";
		break;
	case 1:
		String message = "동아리가 성공적으로 폐부되었습니다.";
		redirectAttributes.addFlashAttribute("message",message );
		logicalViewName = "redirect:/club/clubPRequestListView.do";
		break;
	}
	return logicalViewName;
	}
	
}
