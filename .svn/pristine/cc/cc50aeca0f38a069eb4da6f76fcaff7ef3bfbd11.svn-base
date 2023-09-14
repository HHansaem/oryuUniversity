package kr.or.ddit.professor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.professor.vo.ProfessorVO;

@Mapper
public interface ProfessorDAO {
	public int insertProfessor(ProfessorVO professor);
	public ProfessorVO selectProfessor(String prCd);
	public long selectTotalRecord(PaginationInfo<ProfessorVO> paging);
	public List<ProfessorVO> selectProfessorList(PaginationInfo<ProfessorVO> paging);
	public int updateProfessor(ProfessorVO professor);
	public int deleteProfessor(String prCd);
}
