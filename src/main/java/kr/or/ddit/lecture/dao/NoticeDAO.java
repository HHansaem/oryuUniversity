package kr.or.ddit.lecture.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.lecture.vo.LectureVO;
import kr.or.ddit.lecture.vo.NoticeVO;
import kr.or.ddit.professor.vo.ProfessorVO;

@Mapper
public interface NoticeDAO {
	
	public long selectTotalRecord(PaginationInfo paging);
	
	public List<NoticeVO> selectNoticeList(PaginationInfo paging);
	public NoticeVO selectNotice(String lnNum);
	
	public int insertNotice(NoticeVO lecNotice);
	public int updateNotice(NoticeVO lecNotice);
	public int deleteNotice(NoticeVO lecNotice);
	
	public String selectLecName(@Param("lecCd")String lecCd);
	
	public NoticeVO selectProfessorInfo(@Param("lecCd")String lecCd);
}
