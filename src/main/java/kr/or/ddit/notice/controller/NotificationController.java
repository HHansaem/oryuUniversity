package kr.or.ddit.notice.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.dao.CommonDAO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.notice.service.NotificationService;
import kr.or.ddit.notice.vo.NotificationVO;
import kr.or.ddit.professor.vo.ProfessorVO;
import kr.or.ddit.staff.service.StaffService;
import kr.or.ddit.staff.vo.StaffVO;
import kr.or.ddit.student.vo.StudentVO;
import kr.or.ddit.teachingStaff.vo.TeachingStaffVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice")
public class NotificationController {

	@Inject
	private NotificationService service;

	@Inject
	private StaffService sService;

	@ModelAttribute("notification")
	public NotificationVO notification() {
		return new NotificationVO();
	}

	// 알림목록(교직원)
	@RequestMapping("mngNoticeList.do")
	public void mngNoticeList(@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage,
			@ModelAttribute("simpleCondition") SimpleCondition simpleCondition,
			@RequestParam Map<String, Object> detailCondition, Model model) {
		PaginationInfo<NotificationVO> paging = new PaginationInfo<>();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		log.info("simple!!!!!!!!!!!!!!!!!!!!!!!!!", simpleCondition);

		List<NotificationVO> noticeList = service.retrieveNotificationList(paging);
		paging.setDataList(noticeList);

		model.addAttribute("paging", paging);
	}
	//

	// 알림목록(학생)
	@RequestMapping("stuNoticeList.do")
	public void stuNoticeList(@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage,
			@ModelAttribute("simpleCondition") SimpleCondition simpleCondition,
			@RequestParam Map<String, Object> detailCondition, Model model,
			Authentication authentication
	) {
		PaginationInfo<NotificationVO> paging = new PaginationInfo<>();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		UserDetails userDetail = (UserDetails)authentication.getPrincipal();
		String who = userDetail.getUsername();
		detailCondition.put("who", who);
		paging.setDetailCondition(detailCondition);

		List<NotificationVO> noticeList = service.retrieveMyNoticeList(paging);
		paging.setDataList(noticeList);

		model.addAttribute("paging", paging);
	}
	
	// 알림목록(교수)
	@RequestMapping("prfNoticeList.do")
	public void prfNoticeList(@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage,
			@ModelAttribute("simpleCondition") SimpleCondition simpleCondition,
			@RequestParam Map<String, Object> detailCondition, Model model,
			Authentication authentication
	) {
		PaginationInfo<NotificationVO> paging = new PaginationInfo<>();
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		
		UserDetails userDetail = (UserDetails)authentication.getPrincipal();
		String who = userDetail.getUsername();
		detailCondition.put("who", who);
		paging.setDetailCondition(detailCondition);

		List<NotificationVO> noticeList = service.retrieveMyNoticeList(paging);
		paging.setDataList(noticeList);

		model.addAttribute("paging", paging);
	}

	// 알림 등록
	@GetMapping("noticeInsert.do")
	public String noticeForm(Authentication authentication, Model model) {
		UserDetails userdetail = (UserDetails) authentication.getPrincipal();
		String sender = userdetail.getUsername();
		StaffVO staff = sService.retrieveStaff(sender);
		String staffCd = staff.getTsCd();
		String staffNm = staff.getTsNm();
		NotificationVO notification = new NotificationVO();
		notification.setNotiSender(staffCd);
		notification.setTsNm(staffNm);
		model.addAttribute("notification", notification);
		return "notice/ajax/noticeForm";
	}

	// 알림 등록
	@PostMapping(value = "noticeInsert.do", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String noticeInsert(@RequestBody NotificationVO notification, Errors errors, Model model,
			Authentication authentication) {
		String response = null;
		int result = service.createNotification(notification);
		if (result > 0) {
			response = "알림 전송 완료";
		} else {
			response = "알림 전송 실패, 다시 진행해주세요.";
		}
		return response;
	}
}
