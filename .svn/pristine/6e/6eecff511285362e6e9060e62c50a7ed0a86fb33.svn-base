package kr.or.ddit.internshipAPC.service;

import java.util.List;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.internshipAPC.vo.InternshipAPCVO;

public interface InternshipAPCService {
	/**
	 * 인턴십신청서 작성
	 * @param intern
	 * @return
	 */
	public boolean internshipAPCInsert(InternshipAPCVO internAPC);
	
	/**
	 * 인턴십신청 목록(교직원)
	 * @return
	 */
	public List<InternshipAPCVO> staffInternshipAPCList(PaginationInfo paging);
	
	/**
	 * 인턴십신청 목록(학생)
	 * @return
	 */
	public List<InternshipAPCVO> stuInternshipAPCList(PaginationInfo paging,String stCd);
	
	
	/**
	 * 인턴십신청서 상세보기
	 * @param inteCd
	 * @return
	 */
	public InternshipAPCVO internshipAPCView(String iaCd);
	
	/**
	 * 인턴십신청서 변경
	 * @param inteCd
	 * @return
	 */
	public boolean internshipAPCUpdate(InternshipAPCVO internAPC);
	
	/**
	 * 인턴십신청서 합격여부
	 * @param inteCd
	 * @return
	 */
	public int internshipAPCPass(String iaCd,String pass);
	
	
	/**
	 * 총 레코드 수 조회
	 * @param paging
	 * @return
	 */
	public long selectTotalRecord(PaginationInfo paging);
	
	/**
	 * 학생정보
	 * @param internAPC
	 * @return
	 */
	public InternshipAPCVO stuInfo(String stCd);
}
