package kr.or.ddit.subject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.subject.vo.SubjectVO;

/**
 * 과목 DAO
 * @author rottw
 *
 */
@Mapper
public interface SubjectDAO {
	//페이징처리를 위한 전체 레코드 개수 조회
	public long selectTotalRecord(PaginationInfo paging);
	// 전체 과목 조회 (페이징처리)
	public List<SubjectVO> selectSubjectList(PaginationInfo paging);
	// 과목 등록
	public int insertSubject(SubjectVO subject);
	// 과목코드로 과목 한개 조회
	public SubjectVO selectSubject(String subjCd);
	// 과목 수정
	public int updateSubject(SubjectVO subject);
	// 과목 삭제
	public int deleteSubject(SubjectVO subject);
	// 전체 과목 조회(페이징x)
	public List<SubjectVO> SubjectList();

}
