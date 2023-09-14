package kr.or.ddit.staff.controller;

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
import kr.or.ddit.staff.service.StaffService;
import kr.or.ddit.staff.vo.StaffVO;
import kr.or.ddit.student.vo.StudentVO;

@Controller
public class StaffRetrieveController {

	@Inject
	private StaffService service;
	
	// 교직원목록 껍데기 페이지를 로딩
	@RequestMapping("/staff/staffFrameList.do")
	public String enrollmentList(
		@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
		, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition
		, @RequestParam Map<String,Object> detailCondition
		, Model model
	) {
		return "staff/staffList";
	}
	
	@RequestMapping("/staff/staffList.do")
	public String stafflist(
			@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
			, SimpleCondition simpleCondition
			, @RequestParam Map<String,Object> detailCondition
			, Model model
		){
			PaginationInfo<StaffVO> paging = new PaginationInfo<>(10, 5);
			paging.setSimpleCondition(simpleCondition);
			paging.setCurrentPage(currentPage);
			paging.setDetailCondition(detailCondition);
			
			List<StaffVO> staffList = service.retrieveStaffList(paging);
			paging.setDataList(staffList);
			
			model.addAttribute("paging", paging);
			
			return "staff/ajax/staffList2";
			
		}
	
	@RequestMapping("/staff/staffView.do")
	public String staffView(
		@RequestParam(name="who") String tsCd
		, Model model
	){
		StaffVO staff = service.retrieveStaff(tsCd);
		model.addAttribute("staff", staff);
		
		return "staff/staffView";
	}
	
}
