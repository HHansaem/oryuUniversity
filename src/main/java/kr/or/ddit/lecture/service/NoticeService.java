package kr.or.ddit.lecture.service;

import java.util.List;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.lecture.vo.LectureVO;
import kr.or.ddit.lecture.vo.NoticeVO;
import kr.or.ddit.professor.vo.ProfessorVO;

public interface NoticeService {
	
	public List<NoticeVO> retrieveNoticeList(PaginationInfo paging);
	public NoticeVO retrieveNotice(String lnNum);
	
	public boolean createNotice(NoticeVO lecNotice);
	public boolean modifyNotice(NoticeVO lecNotice);
	public boolean removeNotice(NoticeVO lecNotice);
	
	public String retrieveLecName(String lecCd);
	public NoticeVO retrieveProfessorInfo(String lecCd);
	
}
