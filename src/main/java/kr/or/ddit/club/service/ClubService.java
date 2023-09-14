package kr.or.ddit.club.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.club.vo.ClubVO;
import kr.or.ddit.clubMember.vo.ClubMemberVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.professor.vo.ProfessorVO;

public interface ClubService {
	/**
	 * 동아리 개설 신청
	 * @param Club 개설 요청
	 * @return 1
	 */
	public boolean createInsertRequest(ClubVO club);
	
	/**
	 * 동아리 목록 보기
	 * @param club
	 * @return
	 */
	public ClubVO InsertViewClub(String clubCd);
	
	public List<ClubVO> insertSListClub(int Cd);
	
	public List<ClubVO> insertPListClub(int Cd);
	
	public int insertApproval(String clubCd,String clubStatus);
	
	public int insertRefuse(ClubVO club);
	
	public List<ClubVO> RequestListClub();
	
	public ClubVO checkClub(int Cd);
	
	public ClubVO myClub(int Cd,String clubCd);
	
	public List<ClubVO> ClubListView(PaginationInfo paging, String ClubCd);
	
	public ClubVO clubDetail(String clubCd);
	
	public int clubUpdate(ClubVO club);
	
	public List<ProfessorVO> proChoice(PaginationInfo paging);
	
	/**
	 * 폐부된 동아리 목록
	 * @param paging
	 * @return
	 */
	public List<ClubVO> clubClosedList(PaginationInfo paging);
	
	/**
	 * 총 동아리 수 조회
	 * @param paging
	 * @return
	 */
	public long clubTotalRecord(PaginationInfo paging);
	
	/**
	 * 총 교수 수 조회
	 * @param paging
	 * @return
	 */
	public long profTotalRecord(PaginationInfo paging);
	
	/**
	 * 동아리 수정 거절 (교직원)
	 * @param club
	 * @return
	 */
	public int clubNoUpdate(ClubVO club);
	
	/**
	 * 동아리 수정 요청(학생, 교수)
	 * @param clubCd
	 * @return
	 */
	public int clubUpdateRequest(ClubVO clubCd);
	
	
	/**
	 * 학생이 속한 동아리 목록
	 * @param paging
	 * @param clubCd
	 * @return
	 */
	public List<ClubVO> myClubList(PaginationInfo paging,String stCd);
	
	/**
	 * 학생이 속한 동아리 수
	 */
	public long myClubListTotalRecord(String stCd);
	
	/**
	 * 부장 아닌 부원 찾기
	 */
	public List<ClubMemberVO> stuChoice(@Param("paging") PaginationInfo paging,@Param("clubCd") String clubCd);
	
	/**
	 * 부장 아닌 부원 몇명인지 확인
	 */
	public long stuClubMemberTotalRecord(@Param("paging") PaginationInfo paging,@Param("clubCd") String clubCd);

	/**
	 * 폐부 처리
	 */
	public int clubClosed(String clubCd);
}
