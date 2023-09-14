package kr.or.ddit.club.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.club.service.ClubService;
import kr.or.ddit.club.vo.ClubVO;
import lombok.extern.slf4j.Slf4j;
//교수가 받은 동아리신청서 목록과 세부사항
@Controller
@Slf4j
public class ProfeClubInsertRequestRetrieve {
	@Inject
	private ClubService service;
	
	/**
	 * 교수가 받은 동아리 신청서 목록
	 * @param model
	 * @return
	 */
	@RequestMapping("/club/clubPRequestListView.do")
	public String clubRequestListView(
			Model model
			,Authentication authentication
			,HttpSession session
			) {
		List<ClubVO> InsertRequest = service.insertPListClub(Integer.parseInt(authentication.getName()));//인증 아이디 가져옴
		model.addAttribute("club",InsertRequest);
		String message1 = (String) session.getAttribute("message");
		log.info("세션확인"+session.getAttribute("message"));
		model.addAttribute("message",message1);
		session.removeAttribute("message");
		return "club/clubInsertRequestListView";
	}
	
}
