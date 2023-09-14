package kr.or.ddit.tuition.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.department.dao.DepartmentDAO;
import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.tuition.service.TuitionService;
import kr.or.ddit.tuition.vo.TuitionVO;

@Controller
public class TutitionRetrieveController {

	@Inject
	private TuitionService service;
	@Inject
	private DepartmentDAO departmentDAO;
	
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList(){
		List<DepartmentVO> dList = departmentDAO.selectDepartmentList();
		return dList;
	}
	
	// 등록금목록 껍데기 페이지 로딩
	@RequestMapping("/tuition/tuitionFrameList.do")
	public String enrollmentList(
		@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
		, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition
		, @RequestParam Map<String,Object> detailCondition
		, Model model
	) {
		return "tuition/tuitionStaffList";
	}
	
	@GetMapping("/tuition/staffTuitionList.do")
	public String getHandler(
		@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
		, @RequestParam Map<String,Object> detailCondition
		, SimpleCondition simpleCondition
		, Model model
	){
		PaginationInfo<TuitionVO> paging = new PaginationInfo<>(9, 5);
		paging.setSimpleCondition(simpleCondition);
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(detailCondition);
		
		List<TuitionVO> tuitionList = service.retrieveStaffTuitionList(paging);
		paging.setDataList(tuitionList);
		
		model.addAttribute("paging", paging);
		
		return "tuition/ajax/tuitionStaffList2";
	}
	
	@PostMapping(value="/tuition/staffTuitionList.do", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> postHandler(
		@RequestBody List<TuitionVO> tuitionList
	){
		Map<String, Object> respMap = new HashMap<>();
		List<TuitionVO> tuitionListToApprove = new ArrayList<>();
		boolean allApproved = true;
		
		for(TuitionVO tuition : tuitionList) {
			TuitionVO tuition2 = service.retrieveTuition(tuition);
			if(!tuition2.getTuWhether().equals("완료")) {
				tuitionListToApprove.add(tuition);
				allApproved = false;
			}else {
				allApproved = true;
				respMap.put("result", "이미완료상태");
				break;
			}
		}
		
		if(!allApproved) {
			respMap.put("result", "성공");
			for (TuitionVO tuition : tuitionListToApprove) {
				service.acceptTuition(tuition);
			}
		}
		return ResponseEntity.ok(respMap);
	}
	
}
