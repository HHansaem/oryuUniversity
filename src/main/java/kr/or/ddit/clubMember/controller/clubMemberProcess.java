package kr.or.ddit.clubMember.controller;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.clubMember.service.ClubMemberService;
import kr.or.ddit.clubMember.vo.ClubMemberVO;

@Controller
public class clubMemberProcess {
	
	@Inject
	private ClubMemberService service;
	
	/**
	 * 동아리 탈퇴/ 강제 탈퇴
	 */
	@RequestMapping("/clubMember/clubMemberWthdrClub.do")
	public String clubMemberWthdrClub(
			@RequestParam(name="what") String clubCd
			, RedirectAttributes redirectAttributes
			, Model model
			, Authentication authentication
			) {
		String message;
		ClubMemberVO check = service.stuClassCheck(authentication.getName(),clubCd);
		int success = service.clubMemberWthdrClub(authentication.getName(),clubCd);
			
		if(success > 0 && !check.getClubMemClass().equals("부장"))
		{
			message = "탈퇴 처리 성공";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/club/myClubList.do";
		}else if(check.getClubMemClass().equals("부장") && !check.getClubMemClass().isEmpty() ) {
			int success2 =service.stuClassWthdrClub(authentication.getName(), clubCd);
			if(success2>0) {
			message = "탈퇴 처리 성공";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/club/myClubList.do";
			}else {
				message = "탈퇴 처리 실패";
				redirectAttributes.addFlashAttribute("message", message);
				return "redirect:/club/myClubView.do";
			}
		}else {
				message = "탈퇴 처리 실패";
				redirectAttributes.addFlashAttribute("message", message);
				return "redirect:/club/myClubView.do";
		}
	}
	/**
	 * 입부 학생 승인(교수)
	 */
	@RequestMapping("/clubMember/clubMemberInsertPass.do")
	public String insertPass(
			@RequestParam(name="who")String stCd
			,@RequestParam(name="club")String clubCd
			,Model model
			,RedirectAttributes redirectAttributes
			) {
		String message;
		int success = service.clubMemberInsertPass(stCd,clubCd);
		if(success > 0) {
			return "redirect:/club/myClubView.do";
		}else{
			message = "입부승인 처리 중 오류가 발생했습니다.";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/clubMember/prfClubMemberView.do";
		}
	}
	
	/**
	 * 입부 학생 거절(교수)
	 */
	@RequestMapping("/clubMember/clubMemberInsertNoPass.do")
	public String insertNoPass(
			@RequestParam(name="who")String stCd
			,@RequestParam(name="club")String clubCd
			,Model model
			,RedirectAttributes redirectAttributes
			) {
		String message;
		int success = service.clubMemberInsertNoPass(stCd,clubCd);
		if(success > 0) {
			return "redirect:/club/myClubView.do";
		}else{
			message = "입부거절 처리 중 오류가 발생했습니다.";
			redirectAttributes.addFlashAttribute("message", message);
			return "redirect:/club/myClubView.do";
		}
	}
}
