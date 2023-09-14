package kr.or.ddit.professor.controller;

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
import kr.or.ddit.department.dao.DepartmentDAO;
import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.professor.service.ProfessorService;
import kr.or.ddit.professor.vo.ProfessorVO;

@Controller
public class ProfessorRetrieveController {
	
	@Inject
	private ProfessorService service;
	@Inject
	private DepartmentDAO departmentDAO;
	
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList(){
		List<DepartmentVO> dList = departmentDAO.selectDepartmentList();
		return dList;
	}
	
	// 교직원목록 껍데기 페이지를 로딩
	@RequestMapping("/professor/professorFrameList.do")
	public String enrollmentList(
		@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
		, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition
		, @RequestParam Map<String,Object> detailCondition
		, Model model
	) {
		return "professor/professorList";
	}
	
	@RequestMapping("/professor/professorList.do")
	public String professorlist(
		@RequestParam(name="page", required = false, defaultValue = "1") long currentPage
		, SimpleCondition simpleCondition
		, @RequestParam Map<String,Object> detailCondition
		, Model model
	){
		PaginationInfo<ProfessorVO> paging = new PaginationInfo<>(10, 5);
		paging.setSimpleCondition(simpleCondition);
		paging.setCurrentPage(currentPage);
		paging.setDetailCondition(detailCondition);
		
		List<ProfessorVO> professorList = service.retrieveProfessorList(paging);
		paging.setDataList(professorList);
		
		model.addAttribute("paging", paging);
		
		return "professor/ajax/professorList2";
		
	}
	
	@RequestMapping("/professor/professorView.do")
	public String studentView(
		@RequestParam(name="who") String prCd
		, Model model
	){
		ProfessorVO professor = service.retrieveProfessor(prCd);
		model.addAttribute("professor", professor);
		
		return "professor/professorView";
	}
	
}
















