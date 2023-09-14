package kr.or.ddit.enrollment.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.college.dao.CollegeDAO;
import kr.or.ddit.college.vo.CollegeVO;
import kr.or.ddit.common.dao.CommonDAO;
import kr.or.ddit.common.vo.ClassRoomVO;
import kr.or.ddit.common.vo.DaytimeScheduleVO;
import kr.or.ddit.department.dao.DepartmentDAO;
import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.enrollment.service.EnrollmentService;
import kr.or.ddit.enrollment.vo.EnrollmentVO;
import kr.or.ddit.subject.dao.SubjectDAO;
import kr.or.ddit.subject.vo.SubjectVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/enrollment/")
public class EnrollmentManagementController {
	@Inject
	private EnrollmentService service;
	
	@ModelAttribute("enrollment")
	public EnrollmentVO enrollment() {
		return new EnrollmentVO();
	}
	
	@Inject 
	private DepartmentDAO departmentDAO;
	@Inject
	private CollegeDAO collegeDAO;
	@Inject
	private SubjectDAO subjectDAO;
	@Inject
	private CommonDAO commonDAO;
	
	@ModelAttribute("classRoomList")
	public List<ClassRoomVO> classRoomList(){
		return commonDAO.selectClassRoomList();
	}
	
	@ModelAttribute("daytimeScheduleList")
	public List<DaytimeScheduleVO> daytimeScheduleList(){
		return commonDAO.selectDaytimeScheduleList();
	}

	@ModelAttribute("subjectList")
	public List<SubjectVO> subjectList(){
		return subjectDAO.SubjectList();
	}
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList(){
		return departmentDAO.selectDepartmentList();
	}
	@ModelAttribute("collegeList")
	public List<CollegeVO> collegeList(){
		return collegeDAO.selectCollegeList();
	}
	// 수강요청 확정(교직원)
	@PostMapping("commitEnrollment.do")
	@ResponseBody
	public String commitEnrollment(
			Authentication authentication
			, @RequestBody List<EnrollmentVO> requestData
	) {
		int count = 0;
		String result = null;
		count = service.acceptEnrollment(requestData);
		if(count>0) {
			result="success";
		}else {
			result="fail";
		}
		return result;
	}
	// 수강요청 취소(교직원)
	@PostMapping("rejectEnrollment.do")
	@ResponseBody
	public String rejectEnrollment(
			Authentication authentication
			, @RequestBody List<EnrollmentVO> requestData
	) {
		int count = 0;
		String result = null;
		count = service.rejectEnrollment(requestData);
		if(count>0) {
			result="success";
		}else {
			result="fail";
		}
		return result;
	}
	
	// 수강 신청(학생)
	@PostMapping(value = "submitEnrollment.do", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String submitEnrollment(
			Authentication authentication
			,String[] lecCds
	) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String stCd = userDetails.getUsername();
		int count = 0;
		String result = null;

		EnrollmentVO enrollment = new EnrollmentVO();
		enrollment.setStCd(stCd);
		enrollment.setLecCds(lecCds);
		try {
			count = service.sendEnrollement(enrollment);
		} catch (Exception e) {
			return e.getMessage();
		}
		
		if(count>0) {
			result="수강신청 완료";
		}else {
			result="수강신청 실패";
		}
		return result;
	}
	// 수강 취소(학생)
	@PostMapping(value = "cancelEnrollment.do", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String cancelEnrollment(
			Authentication authentication
			,String[] lecCds
	) {
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String stCd = userDetails.getUsername();
		int count = 0;
		String result = null;

		EnrollmentVO enrollment = new EnrollmentVO();
		enrollment.setStCd(stCd);
		enrollment.setLecCds(lecCds);
	
		count = service.deleteEnrollment(enrollment);
		
		if(count>0) {
			result="수강취소 완료";
		}else {
			result="수강신청 실패";
		}
		return result;
	}
		

}
