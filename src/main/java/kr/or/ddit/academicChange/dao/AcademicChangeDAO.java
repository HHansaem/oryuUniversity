package kr.or.ddit.academicChange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.academicChange.vo.AcademicChangeVO;
import kr.or.ddit.club.vo.ClubVO;
import kr.or.ddit.common.vo.PaginationInfo;

@Mapper
public interface AcademicChangeDAO {

	/**
	 * 페이징처리
	 * @param paging
	 * @return
	 */
	public List<AcademicChangeVO> acaChangeListView(PaginationInfo paging);
	
	
	
	/**
	 * 승인 거절 처리
	 * @param acChCd
	 * @param acChSta
	 * @return
	 */
	public boolean updateAcademicChange(@Param("acChCd") String acChCd, @Param("acChSta")String acChSta);
	
	/**
	 * 승인시 student Update
	 * @param stCd
	 * @param acChSta
	 * @return
	 */
	public boolean updateStudentStatus(@Param("stCd")String stCd, @Param("acChDiv")String acChDiv);
	
	/**
	 * 변경요청
	 * @param club
	 * @return
	 */
	public int insertAcaChange(AcademicChangeVO acaChange);

	/**
	 * 변경 요청 리스트 검색
	 * @param acChSta
	 * @param stCd
	 * @return
	 */
	public List<AcademicChangeVO> acaChangeRequestListSearch(@Param("acChSta") String acChSta,@Param("stCd") String stCd);
	
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
	public long selectTotalRecord(PaginationInfo paging);
	
	
}
