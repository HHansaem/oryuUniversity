package kr.or.ddit.academicChange.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.academicChange.vo.AcademicChangeVO;
import kr.or.ddit.common.vo.PaginationInfo;


public interface AcademicChangeService {
	/**
	 * 페이징처리
	 * @param paging
	 * @return
	 */
	public List<AcademicChangeVO> acaChangeListView(PaginationInfo paging);
	
	/**
	 * 승인 거절 처리
	 */
	public boolean updateAcademicChange(String acChCd,String acChSta); 
	
	/**
	 * 승인시 student Update
	 * @param acChCd
	 * @param acChSta
	 * @return
	 */
	public boolean updateStudentStatus(String stCd, String acChDiv);
	
	/**
	 * 변경요청
	 * @param club
	 * @return
	 */
	public boolean insertAcaChange(AcademicChangeVO acaChange);
	
	/**
	 * 변경 요청 리스트 검색
	 * @param acChSta
	 * @param stCd
	 * @return
	 */
	public List<AcademicChangeVO> acaChangeRequestListSearch(String acChSta,String stCd);
	
	/**
	 * 변경요청 리스트
	 * @param acaChange
	 * @return
	 */
	public List<AcademicChangeVO> acaChangeRequestList(String stCd);
	
	/**
	 * 변경내용 상세 보기
	 * @param acChCd
	 * @return
	 */
	public AcademicChangeVO acaChangeView(String acChCd);
	
	
	/**
	 * 교직원이 보는 리스트창
	 * @param acaChange
	 * @return
	 */
	public List<AcademicChangeVO> stffacaChangeRequestList(PaginationInfo paging);
	
	/**
	 * 총 레코드 수 조회
	 * @param paging
	 * @return
	 */
	public long getTotalRecordCount(PaginationInfo paging);
	
}
