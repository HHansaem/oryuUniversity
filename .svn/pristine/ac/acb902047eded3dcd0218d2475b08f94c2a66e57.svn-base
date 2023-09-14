package kr.or.ddit.research.service;

import java.util.List;


import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.research.vo.ResearchVO;
import kr.or.ddit.serviceresult.ServiceResult;

public interface ResearchService {


	
	/**
	 * 연구 단일 조회
	 * @param reseCd
	 * @return
	 */
	public ResearchVO retrieveResearch(String reseCd);
	
	/**
	 * 연구 목록 조회
	 * @return
	 */
	public List<ResearchVO> retrieveResearchList(PaginationInfo<ResearchVO> paging);
	
	/**
	 * 연구 신규등록
	 * @param researchVO
	 * @return
	 */
	public boolean createResearch(ResearchVO researchVO);
	
	/**
	 * 연구 내용 수정
	 * @param research
	 * @return
	 */
	public boolean modifyResearch(ResearchVO researchVO);
	
	/**
	 * 연구 삭제
	 * @param research
	 * @return
	 */
	public boolean removeResearch(ResearchVO researchVO);
	
	public long getTotalRecordCount(PaginationInfo<ResearchVO> paging);

	
}
