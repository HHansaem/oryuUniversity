package kr.or.ddit.internship.service;

import java.util.List;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.internship.vo.InternshipVO;

public interface InternshipService {
	/**
	 * 인턴십 insert
	 * @param intern
	 * @return
	 */
	public boolean internshipInsert(InternshipVO intern);
	
	/**
	 * 인턴십 목록
	 * @return
	 */
	public List<InternshipVO> internshipList(PaginationInfo paging);
	
	/**
	 * 인턴십 상세보기
	 * @param inteCd
	 * @return
	 */
	public InternshipVO internshipView(String inteCd);
	
	/**
	 * 인턴십 업데이트
	 * @param inteCd
	 * @return
	 */
	public boolean internshipUpdate(InternshipVO intern);
	
	/**
	 * 인턴십 제거
	 * @param inteCd
	 * @return
	 */
	public boolean internshipDelete(String inteCd);
	
	
	public long getTotalRecordCount(PaginationInfo paging);
	
	
}
