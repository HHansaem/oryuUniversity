package kr.or.ddit.clubMember.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.club.vo.ClubVO;
import kr.or.ddit.clubMember.vo.ClubMemberVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.student.vo.StudentVO;

@Mapper
public interface ClubMemberDAO {
	
	/**
	 * 동아리에 소속된 부원(교수)
	 * @param clubCd
	 * @return
	 */
	public List<StudentVO> prfClubList(String prCd);
	
	
	/**
	 * 동아리에 소속된 부원(학생)
	 * @param clubCd
	 * @return
	 */
	public List<StudentVO> stuClubList(String clubCd);
	
	/**
	 * 동아리 가입 신청
	 */
	public int clubMemInsert(ClubMemberVO clubMem);
	
	/**
	 * 동아리 가입 신청 세부사항
	 */
	public ClubMemberVO clubMemInsertView(@Param("stCd") String stCd,@Param("clubCd") String clubCd);
	
	/**
	 * (교수) 동아리 신청서 목록
	 */
	public List<ClubMemberVO> clubMemInsertList(@Param("paging")PaginationInfo paging, @Param("clubCd")String clubCd);
	
	
	/**
	 * 동아리 신청서 목록 갯수(교수)
	 */
	public long prfselectTotalRecord(@Param("paging") PaginationInfo paging,@Param("clubCd") String clubCd);
	
	/**
	 * 학생 본인이 신청한 동아리 목록
	 * @param stCd
	 * @return
	 */
	public List<ClubMemberVO> stuReqClubList(@Param("paging") PaginationInfo paging,@Param("stCd") String stCd);
	
	/**
	 * 부장인 학생 확인문
	 */
	public ClubMemberVO stuClassCheck(@Param("stCd") String stCd,@Param("clubCd") String clubCd);
	
	/**
	 * 입부학생 승인
	 */
	public int clubMemberInsertPass(@Param("stCd")String stCd,@Param("clubCd") String ClubCd);
	
	/**
	 * 입부학생 거절
	 */
	public int clubMemberInsertNoPass(@Param("stCd")String stCd,@Param("clubCd") String ClubCd);
	
	/**
	 * 동아리 탈퇴
	 */
	public int clubMemberWthdrClub(@Param("stCd") String stCd,@Param("clubCd") String clubCd);
	
	/**
	 * 부장 탈퇴
	 * @param stCd
	 * @param clubCd
	 * @return
	 */
	public int stuClassWthdrClub(@Param("stCd") String stCd,@Param("clubCd") String clubCd);
	
	/**
	 * 동아리 탈퇴 리스트 확인(교수)
	 */
	public List<ClubMemberVO> clubMemberWthdrClubList(@Param("paging") PaginationInfo paging,@Param("clubCd") String clubCd);
	
	/**
	 * 교수가 동아리 부장 변경 (강등)
	 */
	public int clubHeadDownUpdate(String clubCd);
	
	/**
	 * 교수가 동아리 부장 변경 (승급)
	 */
	public int clubHeadUpUpdate(ClubVO club);
	
	/**
	 * 동아리 탈퇴자 목록 수
	 */
	public long clubMemberWthdrClubCount(String clubCd);
	
	/**
	 * 학생 본인이 신청한 동아리 목록 수
	 * @param stCd
	 * @return
	 */
	public long stuReqClubCount(String stCd);
	
	/**
	 * 동아리 부원 한명
	 * @param clubCd
	 * @return
	 */
	public String clubMember(String clubCd);


}
