package kr.or.ddit.professor.service;

import java.util.List;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.professor.vo.ProfessorVO;
import kr.or.ddit.serviceresult.ServiceResult;

public interface ProfessorService {
	
	/**
	 *  교수등록
	 */
	public ServiceResult createProfessor(ProfessorVO professor);
	
	/**
	 *  교수상세조회
	 */
	public ProfessorVO retrieveProfessor(String prCd);
	/**
	 *  교수리스트조회
	 */
	public List<ProfessorVO> retrieveProfessorList(PaginationInfo<ProfessorVO> paging);
	/**
	 *  교수정보수정
	 */
	public ServiceResult modifyProfessor(ProfessorVO professor);
	
	/**
	 *  교수 탈퇴상태로 변경
	 */
	public ServiceResult removeProfessor(String prCd);

}
