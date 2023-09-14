package kr.or.ddit.club.controller;


import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.club.service.ClubService;
import kr.or.ddit.club.vo.ClubVO;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class ClubRefuseRequest {
@Inject
	private ClubService service;


@ModelAttribute("club")// ("")이름을 지정하고 그 지정된 이름은 jsp에도 있어야 한다
public ClubVO club() {
	
	return new ClubVO();
}
 
/**
 * 개설 승인처리
 * @return
 */
@RequestMapping("/club/clubInsertApproval.do")
public String clubRequestGo(
		 @RequestParam(name = "who", required = true) String clubCd,
	     @RequestParam(name = "what", required = true) String clubStatus,
	        Model model
	        ,Authentication authentication
	        ,RedirectAttributes redirectAttributes
		)
{
	
	int InsertRequest = service.insertApproval(clubCd,clubStatus);
	
		String logicalViewName=null;
	switch (InsertRequest) {
	case 0:
		model.addAttribute("message", "요청처리 실패");
		logicalViewName = "/club/clubPRequestListView.do";
		break;
	case 1:
		if(authentication.getName().length()==7) {//교수
			logicalViewName = "redirect:/club/clubPRequestListView.do";
		}else {//교직원
			logicalViewName = "redirect:/club/clubRequestListView.do";
		}
		break;
}
	return logicalViewName;
}

/**
 * 거절 사유 적는 폼으로 이동
 * @param club
 * @param model
 * @return
 */
@RequestMapping("/club/clubRequestRefuseGo.do")
public String clubRefuseGo(
		@RequestParam(name = "who", required = true) String clubCd,
		@RequestParam(name = "what", required = true) String clubStatus
		,Model model
		)
{
	model.addAttribute("clubCd", clubCd);
	model.addAttribute("clubStatus", clubStatus);
return "club/clubInsertRefuse";
}


/**
 * 개설 거절 처리
 * @param club
 * @param model
 * @return
 */
@RequestMapping("/club/clubRequestRefuse.do")
public String postMapping(
		@ModelAttribute("club") ClubVO club
		,RedirectAttributes redirectAttributes
		,Model model
		,Authentication authentication
		)
{
	
	
	int InsertRequest = service.insertRefuse(club);
	
		String logicalViewName=null;
	switch (InsertRequest) {
	case 0:
		model.addAttribute("message", "요청처리 실패");
		logicalViewName = "club/clubInsertRefuse";
		break;
	case 1:
		String message = "요청처리 성공";
		if(authentication.getName().length()==7) {//교수
			redirectAttributes.addFlashAttribute("message", message);
			logicalViewName = "redirect:/club/clubPRequestListView.do";
		}else {//교직원
			redirectAttributes.addFlashAttribute("message", message);
			logicalViewName = "redirect:/club/clubRequestListView.do";
		}
		break;
}
	return logicalViewName;
}
}
