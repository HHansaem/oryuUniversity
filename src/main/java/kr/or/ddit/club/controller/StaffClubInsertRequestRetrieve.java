package kr.or.ddit.club.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.club.service.ClubService;
import kr.or.ddit.club.vo.ClubVO;
import kr.or.ddit.clubMember.service.ClubMemberService;
import kr.or.ddit.clubMember.vo.ClubMemberVO;
import kr.or.ddit.student.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;

@Controller
public class StaffClubInsertRequestRetrieve {
	@Inject
	private ClubService service;
	
	
	/**
	 * 교직원이 받은 동아리 목록
	 * @param model
	 * @return
	 */
	@RequestMapping("/club/clubRequestListView.do")
	public String clubRequestListView(
			Model model
			,RedirectAttributes redirectAttributes
			) {
		List<ClubVO> InsertRequest = service.RequestListClub();
		redirectAttributes.getFlashAttributes().get("message");
		model.addAttribute("club",InsertRequest);
		return "club/clubInsertRequestListView";
	}
	
	
	
	/**
	 * 교직원이 받은 동아리신청서 세부사항
	 * @param model
	 * @return
	 */
	@RequestMapping("/club/clubRequestView.do")
	public ModelAndView clubRequestView(
			@RequestParam(name = "who", required = true) String clubCd
)
	{
		ModelAndView mav =new ModelAndView();
		ClubVO InsertRequest = service.InsertViewClub(clubCd);
		mav.addObject("club", InsertRequest);
		mav.setViewName("club/clubInsertView");
		return mav;
	}
}
