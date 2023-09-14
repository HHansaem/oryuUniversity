package kr.or.ddit.lecture.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.lecture.service.NoticeService;
import kr.or.ddit.lecture.vo.NoticeVO;

@Controller
public class NoticeDeleteController {
	
	@Inject
	private NoticeService service;
	
	@GetMapping("/lecture/noticeDelete.do")
	public String getHandler(
			Model model
			, @RequestParam(name = "what") String lnNum
	) {
		NoticeVO notice = service.retrieveNotice(lnNum);
		
		String logicalViewName = null;
		boolean result = service.removeNotice(notice);
		if(result) {
			logicalViewName = "redirect:/lecture/noticeList.do?lecCd=" + notice.getLecCd();
		}else {
			model.addAttribute("message", "강의 공지사항 삭제 중 문제 발생");
            logicalViewName = "redirect:/lecture/noticeList.do";
		}
		return logicalViewName;
	}
	
}
