package kr.or.ddit.notice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.notice.dao.NotificationDAO;
import kr.or.ddit.notice.service.NotificationService;
import kr.or.ddit.notice.vo.NoticeDetailVO;
import kr.or.ddit.notice.vo.NotificationVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/notice")
public class NoticeDetailController {

	@Inject
	private NotificationService service;
	
	
	@PostMapping("notificationView.do")
	@ResponseBody
	public String noticeDetail(
		@RequestParam String notiCd,
		Authentication authentcation
	) {
		// 읽음 체크하기
		UserDetails userdetail = (UserDetails)authentcation.getPrincipal();
		String reader = userdetail.getUsername();
		
		NoticeDetailVO detail = new NoticeDetailVO();
		
		detail.setNotiCd(notiCd);
		detail.setNotiReceiver(reader);
		
		String result = "success";
		int cnt = service.confirmReader(detail);
		// 수신자 등록이 된경우 읽음 상태 변경
		if(cnt == 1) {
			service.readNotification(detail);
		} else {
			result = "fail";
		}
		return result;
	}
	@GetMapping("count.do")
	@ResponseBody
	public String getMessageCount(
		Authentication authentication
	) {
		UserDetails userdetail = (UserDetails)authentication.getPrincipal();
		String userId = userdetail.getUsername();
		String count = Integer.toString(service.countNotice(userId));
		log.info("신규알림개수"+count);
        return count;
    }
	
	@GetMapping("list.do")
	public String noticeList(
		@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage,
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

		List<NotificationVO> noticeList = new ArrayList<NotificationVO>(); 
		noticeList = service.retrieveMyNoticeList(paging);
		paging.setDataList(noticeList);
		log.info("111111111111111111111111111111"+noticeList);
		model.addAttribute("paging", paging);
		return "notice/ajax/noticeList";
	}
	
}
