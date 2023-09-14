package kr.or.ddit.internshipAPC.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.department.dao.DepartmentDAO;
import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.internship.dao.InternshipDAO;
import kr.or.ddit.internship.vo.InternshipVO;
import kr.or.ddit.internshipAPC.service.InternshipAPCService;
import kr.or.ddit.internshipAPC.vo.InternshipAPCVO;
import kr.or.ddit.student.dao.StudentDAO;
import kr.or.ddit.student.vo.StudentVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class InternshipAPCRetrieveController {

	@Inject
	private InternshipAPCService service;
	
	/**
	 * 본인이 신청한 인턴십신청서 목록
	 * @param authentication
	 * @param model
	 * @return
	 */
	@RequestMapping("/internshipAPC/InternshipAPCList.do")
	public String stuInternshipAPCInsertList(
	        @RequestParam(name = "page", required = false, defaultValue = "1") long currentPage,
	        @ModelAttribute("simpleCondition") SimpleCondition simpleCondition,
	        Authentication authentication,
	        Model model
	) {
	    PaginationInfo<InternshipAPCVO> paging = new PaginationInfo<>();
	    paging.setCurrentPage(currentPage);
	    paging.setSimpleCondition(simpleCondition);

	    String stCd = authentication.getName();

	    if (authentication.getAuthorities().stream().anyMatch(auth -> "ROLE_ST".equals(auth.getAuthority()))) {
	        List<InternshipAPCVO> stuList = service.stuInternshipAPCList(paging, stCd);
	        paging.setDataList(stuList);
	        model.addAttribute("paging", paging);
	        return "internshipAPC/stuInternshipAPCList";
	    } else {
	        model.addAttribute("message", "권한이 없습니다.");
	        return "internship/internList";
	    }
	}
	
	/**
	 * 교직원이 볼 수 있는 인턴십 신청서 목록
	 * @param currentPage
	 * @param simpleCondition
	 * @param authentication
	 * @param model
	 * @return
	 */
	@RequestMapping("/internshipAPC/StaffInternshipAPCList.do")
	public String staffInternshipAPCInsertList(
	        @RequestParam(name = "page", required = false, defaultValue = "1") long currentPage,
	        @ModelAttribute("simpleCondition") SimpleCondition simpleCondition,
	        Authentication authentication,
	        Model model
	) {
	    PaginationInfo<InternshipAPCVO> paging = new PaginationInfo<>();
	    paging.setCurrentPage(currentPage);
	    paging.setSimpleCondition(simpleCondition);
	    if (authentication.getAuthorities().stream().anyMatch(auth -> "ROLE_TS".equals(auth.getAuthority()))) {
	        List<InternshipAPCVO> stuList = service.staffInternshipAPCList(paging);
	        paging.setDataList(stuList);
	        model.addAttribute("paging", paging);
	     // 총 레코드 수 조회
	        long totalRecord = service.selectTotalRecord(paging);
	        model.addAttribute("totalRecord", totalRecord);
	        
	        return "internshipAPC/mngInternshipAPCList";
	    } else {
	        model.addAttribute("message", "권한이 없습니다.");
	        return "internship/internList";
	    }
	}
	
	
	
	
	/**
	 * 인턴십 게시물 상세 조회
	 * @param iaCd
	 * @param model
	 * @return
	 */
	@RequestMapping("/internshipAPC/internshipAPCView.do")
	public String internshipView(
			@RequestParam(name="what", required = true)String iaCd
			,Model model
			) {
		InternshipAPCVO result = service.internshipAPCView(iaCd);
		model.addAttribute("internAPC",result);
		
		return "internshipAPC/internAPCView";
	}
	
}
