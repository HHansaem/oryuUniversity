package kr.or.ddit.club.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.club.service.ClubService;
import kr.or.ddit.clubMember.vo.ClubMemberVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class stuClubSearch {
	
	@Inject
	private ClubService service;
	
	
	@RequestMapping("/club/stuSearch.do")
	public ModelAndView profSearch(
			 @RequestParam(name = "page", required = false, defaultValue = "1") long currentPage
	        , @RequestParam(name = "searchType", required = false ) String searchType
	        , @RequestParam(name = "searchWord", required = false) String searchWord
	        , @RequestParam(name ="club")String clubCd
	        
			) {
	log.info("searchWord 확인 : {}",searchWord);
	log.info("searchType 확인 : {}",searchType);
	PaginationInfo<ClubMemberVO> paging = new PaginationInfo<>();
    SimpleCondition simpleCondition = new SimpleCondition();
    simpleCondition.setSearchType(searchType);
    simpleCondition.setSearchWord(searchWord);
	paging.setCurrentPage(currentPage);
    paging.setSimpleCondition(simpleCondition);
    // 총 레코드 수 조회
    long totalRecord = service.stuClubMemberTotalRecord(paging,clubCd);
    
    List<ClubMemberVO> stu = service.stuChoice(paging,clubCd);
	paging.setDataList(stu);
	
	 ModelAndView mav = new ModelAndView();
	
	 mav.addObject("totalRecord", totalRecord);
	 mav.addObject("paging", paging);
	 mav.setViewName("club/ajax/stuSearch");
	 
	 return mav;
	}
	
}