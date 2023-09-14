package kr.or.ddit.academicChange.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.ddit.academicChange.service.AcademicChangeService;
import kr.or.ddit.academicChange.vo.AcademicChangeVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.common.vo.SimpleCondition;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AcademicChangeRetrieve {

	@Inject
	private AcademicChangeService service;
	
	
	@RequestMapping("/academicChange/acaChangeList.do")
	public String acaChangeReqList(
			 @RequestParam(name = "who") String stCd
			, @RequestParam(name = "acChSta", required = false) String acChSta // 요청/승인/거절을 검색 조건으로 사용하여 검색
			, Model model
			,RedirectAttributes redirectAttributes
			) {
			String message = (String) redirectAttributes.getFlashAttributes().get("message");
	        
	        if (acChSta != null && !acChSta.isEmpty()) {// 검색 조건인 acChSta가 null이거나 비어있지 않다면 acChSta넣어서 검색
	        	// 요청/승인/거절의 검색 조건인 acChSta와 해당 학생의 학번인 stCd를 받아 검색하여 목록 출력
	        	List<AcademicChangeVO> acaChangeReqList = service.acaChangeRequestListSearch(acChSta, stCd);
	        	model.addAttribute("acaChange", acaChangeReqList);
	        }else {
	        	// acChSta가 검색 조건으로 사용 되지 않았다면 학생 학번으로만 검색
	        List<AcademicChangeVO> acaChangeReqList = service.acaChangeRequestList(stCd);
	        model.addAttribute("acaChange", acaChangeReqList);
	        }
	        model.addAttribute("message", message);//model에 담아서 jsp로 이동
			
	        
	        return "academicChange/acaChangeReqList";
	}	
	
	
	@RequestMapping("/academicChange/acaChangeStaffList.do")
	public String acaChageStaffReqList(
			@RequestParam(name = "page", required = false, defaultValue = "1") long currentPage// 페이징 쪽수를 받는 변수
			, @ModelAttribute("simpleCondition") SimpleCondition simpleCondition // 페이징 검색 조건 받는 변수
			, @RequestParam Map<String,Object> detailCondition // 페이징 검색 조건을 여러개 받을수 있게 해주는 Map
			, Model model
			,RedirectAttributes redirectAttributes
			){
		PaginationInfo<AcademicChangeVO> paging = new PaginationInfo<>(); // 페이징 객체 생성
		// 페이징 사용시 필요한 데이터를 삽입한다
		paging.setCurrentPage(currentPage);
		paging.setSimpleCondition(simpleCondition);
		paging.setDetailCondition(detailCondition);
		redirectAttributes.getFlashAttributes().get("message");
		log.info("dsadsa"+detailCondition);
		
		// 페이지 객체에 있는 데이터를 통해 학생들이 보낸 모든 학적변동 신청서를 가져온다.
		List<AcademicChangeVO> acaChangeList = service.stffacaChangeRequestList(paging);
		paging.setDataList(acaChangeList);
		
		// 가져온 데이터를 model에 담아 jsp로 보내준다.
		model.addAttribute("paging", paging);
		model.addAttribute("detail", detailCondition);
		// 총 레코드 수 조회
        long totalRecord = service.getTotalRecordCount(paging);
        model.addAttribute("totalRecord", totalRecord);
		
		return "academicChange/StaffacaChangeList";
	}
	
	
	
	
	
	@RequestMapping("/academicChange/acaChangeView.do")
	public String acaNoticeView(
			@RequestParam("what") String acChCd // 학번을 통해 보고 싶은 학적 변동 내용을 볼 수 있다.
			, Model model
	) {
		AcademicChangeVO acaChange = service.acaChangeView(acChCd);//학번을 통해 db에서 해당 데이터 조회
		model.addAttribute("acaChange", acaChange);// 해당 데이터를 jsp에 보낸다.
		return "academicChange/acaChangeView";
	}
}







