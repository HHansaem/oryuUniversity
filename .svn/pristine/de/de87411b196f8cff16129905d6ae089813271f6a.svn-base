package kr.or.ddit.academic.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.academic.vo.AcademicNoticeVO;
import kr.or.ddit.common.vo.PaginationInfo;

public interface AcademicNoticeService {
	public List<AcademicNoticeVO> retrieveAcademicNoticeList(PaginationInfo paging);
	public AcademicNoticeVO retrieveAcademicNotice(int anNum);
	
	public boolean createAcademicNotice(AcademicNoticeVO acaNotice);
	public boolean modifyAcademicNotice(AcademicNoticeVO acaNotice);
	public boolean removeAcademicNotice(AcademicNoticeVO acaNotice);
	
	public void increaseViews(int anNum);
	public long getTotalRecordCount(PaginationInfo paging);
	
}
