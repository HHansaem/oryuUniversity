package kr.or.ddit.job.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.job.service.JobService;
import kr.or.ddit.job.vo.AdVO;
import kr.or.ddit.job.vo.JobVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/job")
public class JobAdRetrieveController {
	@Inject
	private JobService service;
	
	// 취업공고 껍데기 페이지를 로딩
	@RequestMapping("jobPostingList.do")
	public void enrollmentList(@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage,
			@ModelAttribute("simpleCondition") SimpleCondition simpleCondition,
			@RequestParam Map<String, Object> detailCondition, Model model) {
	}
	// 광고 출력부분
	@RequestMapping("jobAdList.do")
	public String jobAdList(
		@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
		, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition
		, Model model
	)throws IOException {
		PaginationInfo<AdVO> paging = new PaginationInfo<>();
		paging.setScreenSize(6);
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		List<AdVO> adList = service.retrieveAdList(paging);
		paging.setDataList(adList);
		model.addAttribute("paging", paging);
		
		return "job/ajax/jobAdList";
	}
	// 공고 출력부분
	@RequestMapping("jobAdList2.do")
	public String jobAdList2(
			@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
			, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition
			, @RequestParam Map<String,Object> detailCondition
			, Model model
	) {
		PaginationInfo<JobVO> paging2 = new PaginationInfo<>();
		paging2.setScreenSize(5);
		paging2.setCurrentPage(currentPage);
		paging2.setSimpleCondition(simpleCondition);
		List<JobVO> jobList = service.retriveJobList(paging2);
		paging2.setDataList(jobList);
		model.addAttribute("paging2", paging2);
		
		return "job/ajax/jobAdList2";
		
	}
	
	
}
