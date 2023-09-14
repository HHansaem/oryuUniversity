
package kr.or.ddit.enrollment.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.academic.vo.AcademicNoticeVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.enrollment.service.EnrollmentService;
import kr.or.ddit.enrollment.vo.EnrollmentVO;
import kr.or.ddit.lecture.vo.LectureVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/enrollment")
public class EnrollmentGradeController {
	
	@Inject
	private EnrollmentService service;
	
	@RequestMapping("gradeList.do")
	public String gradeList(
			HttpSession session
			, String lecCd
			, Model model
			, @RequestParam(name = "page", required = false, defaultValue = "1") long currentPage
	) {
		PaginationInfo<EnrollmentVO> paging = new PaginationInfo<>();
		paging.setCurrentPage(currentPage);
		
		session.removeAttribute("lecCd");
		session.setAttribute("lecCd", lecCd);
		LectureVO gradeRate = service.retrieveGradeRate(lecCd);
		log.info("강의비율얍"+gradeRate);
		
		EnrollmentVO enrollment = new EnrollmentVO();
		enrollment.setLecCd(lecCd);
		List<EnrollmentVO> gradeList = service.selectAllScore(paging, lecCd);
		paging.setDataList(gradeList);
		log.info("list잘나오나"+gradeList);
		
		model.addAttribute("gradeRate", gradeRate);
		model.addAttribute("paging", paging);
		
		return "lecture/grade/prfLectureGrade";
	}
	
	@RequestMapping(value = "gradeUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> gradeUpdate(
			@RequestBody Map<String, Object> requestData
	){
		String lecCd = requestData.get("lecCd").toString();
		String stCd = requestData.get("stCd").toString();
		String graRating = requestData.get("graRating").toString();
		String graStatus = requestData.get("graStatus").toString();
		
		Map<String, String> resultMap = new HashMap<>();
		resultMap.put("stCd", stCd);
		resultMap.put("graRating", graRating);
		
		service.modifyGrade(lecCd, stCd, graRating, graStatus);
		
		return resultMap;
	}
}
