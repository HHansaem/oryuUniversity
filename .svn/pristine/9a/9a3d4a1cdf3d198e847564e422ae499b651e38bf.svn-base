package kr.or.ddit.club.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.club.service.ClubService;
import kr.or.ddit.club.vo.ClubVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import kr.or.ddit.department.dao.DepartmentDAO;
import kr.or.ddit.department.vo.DepartmentVO;
import kr.or.ddit.professor.vo.ProfessorVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class profeClubSearch {
	
	@Inject
	private ClubService service;
	
	@Inject 
	private DepartmentDAO departmentDAO;
	
	@ModelAttribute("departmentList")
	public List<DepartmentVO> departmentList(){
		List<DepartmentVO> dList = departmentDAO.selectDepartmentList();
		return dList;
	}
	
	@RequestMapping("/club/profeSearch.do")
	public ModelAndView profSearch(
			 @RequestParam(name = "page", required = false, defaultValue = "1") long currentPage
	        , @RequestParam(name = "searchType", required = false ) String searchType
	        , @RequestParam(name = "searchWord", required = false) String searchWord
	        
			) {
	log.info("searchWord 확인 : {}",searchWord);
	log.info("searchType 확인 : {}",searchType);
	PaginationInfo<ProfessorVO> paging = new PaginationInfo<>();
    SimpleCondition simpleCondition = new SimpleCondition();
    simpleCondition.setSearchType(searchType);
    simpleCondition.setSearchWord(searchWord);
	paging.setCurrentPage(currentPage);
    paging.setSimpleCondition(simpleCondition);
    // 총 레코드 수 조회
    long totalRecord = service.profTotalRecord(paging);
    
    List<ProfessorVO> pro = service.proChoice(paging);
	paging.setDataList(pro);
	
	 ModelAndView mav = new ModelAndView();
	
	 mav.addObject("totalRecord", totalRecord);
	 mav.addObject("paging", paging);
	 mav.setViewName("club/ajax/profeSearch");
	 
	 return mav;
	}
	
	
}