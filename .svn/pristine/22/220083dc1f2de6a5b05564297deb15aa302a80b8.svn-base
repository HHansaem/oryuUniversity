package kr.or.ddit.enrollment.controller;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.enrollment.service.EnrollmentService;
import kr.or.ddit.enrollment.vo.EnrollmentVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/enrollment")
public class StudentGradeController {

	@Inject
	private EnrollmentService service;

	// 현재 학기 성적
	@RequestMapping("currentGradeList.do")
	public String currentGradeList(
			Authentication authentication
			, Model model
		) throws JsonProcessingException {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String stCd = userDetails.getUsername();
		
		String currentLectCred = service.retrieveCurrentLecCred(stCd);
		
		List<EnrollmentVO> stdGradeList = service.retrieveGradeInfo(stCd);
		for(int i=0; i<stdGradeList.size(); i++) {
			stdGradeList.get(i).setCurrentLectCred(currentLectCred);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String stdGradeListJson = objectMapper.writeValueAsString(stdGradeList);
		
		model.addAttribute("stdGradeList", stdGradeList);
		model.addAttribute("stdGradeListJson", stdGradeListJson);
		
		return "grade/stdCurrentGrade";
	}
	
	// 전체 학기 성적(학점 평균)
	@RequestMapping("totalGradeList.do")
	public String totaltGradeList(
			Authentication authentication
			, Model model
			, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition
			) throws JsonProcessingException {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String stCd = userDetails.getUsername();
		
		String totalLectCred = service.retrieveTotalLecCred(stCd);
		
		List<EnrollmentVO> stdGradeList = service.retrieveGradeInfo(stCd);
		for(int i=0; i<stdGradeList.size(); i++) {
			stdGradeList.get(i).setTotalLectCred(totalLectCred);
		}
		
		ObjectMapper objectMapper = new ObjectMapper();
		String stdGradeListJson = objectMapper.writeValueAsString(stdGradeList);
		
		EnrollmentVO enrollment = new EnrollmentVO();
		enrollment.setStCd(stCd);
		enrollment.setSimpleCondition(simpleCondition);
		List<EnrollmentVO> stdAllGradeList = service.retrieveAllGradeInfo(enrollment);
		
		ObjectMapper objectMap = new ObjectMapper();
		String stdAllGradeListJson = objectMap.writeValueAsString(stdAllGradeList);
		
		// 전체 성적 평균
		List<EnrollmentVO> avgGradeList = service.retrieveAvgGrade(stCd);
		
		ObjectMapper objectMapper2 = new ObjectMapper();
		String avgGradeListJson = objectMapper2.writeValueAsString(avgGradeList);
		
		// 전공 성적 평균
		List<EnrollmentVO> majoravgGradeList = service.retrieveMajorAvgGrade(stCd);
		
		ObjectMapper objectMapper3 = new ObjectMapper();
		String MajorAvgGradeListJson = objectMapper3.writeValueAsString(majoravgGradeList);
		
		
		model.addAttribute("stdGradeList", stdGradeList);
		model.addAttribute("stdGradeListJson", stdGradeListJson);
		model.addAttribute("stdAllGradeList", stdAllGradeList);
		model.addAttribute("stdAllGradeListJson", stdAllGradeListJson);
		model.addAttribute("avgGradeList", avgGradeList);
		model.addAttribute("avgGradeListJson", avgGradeListJson);
		model.addAttribute("majoravgGradeList", majoravgGradeList);
		model.addAttribute("MajorAvgGradeListJson", MajorAvgGradeListJson);
		
		return "grade/stdTotalGrade";
	}
}
