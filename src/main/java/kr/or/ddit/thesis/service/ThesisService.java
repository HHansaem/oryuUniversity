package kr.or.ddit.thesis.service;

import java.util.List;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.thesis.vo.ThesisVO;

public interface ThesisService {

//--- retrieve ---	
	
	/**
	 * 논문 상세 조회
	 * @param thesCd
	 * @return 해당 거래처가 없는 경우 PKNotFoundException해당 논문이 없는경우
	 */
	public ThesisVO retrieveThesis(String thesSn);
	
	/**
	 * 논문 목록 조회
	 * @return
	 */
	public List<ThesisVO> retrieveThesisList(PaginationInfo<ThesisVO> paging);

//--- create ---	
	
	/**
	 * 논문 등록
	 * @param thesis
	 * @return ok, fail
	 */
	public boolean createThesis(ThesisVO thesisVO);
	
//--- modify ---
	
	/**
	 * 논문 수정
	 * @param thesis
	 * @return ok, fail
	 */
	public boolean modifyThesis(ThesisVO thesisVO);
	
//--- remove ---	
	
	/**
	 * 논문 삭제
	 * @param thesCd
	 * @return
	 */
	public boolean removeThesis(ThesisVO thesisVO);

//--- totalRecordCount ---
	public long getTotalRecordCount(PaginationInfo<ThesisVO> paging);
	
}
