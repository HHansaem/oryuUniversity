package kr.or.ddit.subject.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.subject.dao.SubjectDAO;
import kr.or.ddit.subject.vo.SubjectVO;
/**
 * 과목 serviceImpl
 * @author rottw
 *
 */
@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Inject
	private SubjectDAO subjectDAO;

	// 전체 과목 조회(페이징처리용)
	@Override
	public List<SubjectVO> retrieveSubjectList(PaginationInfo paging) {
		// 토탈자료 개수
		long totalRecord = subjectDAO.selectTotalRecord(paging);
		// 페이징 객체에 토탈레코드 저장
		paging.setTotalRecord(totalRecord);
		// 페이징 객체를 이용하여 전체과목조회 후 리턴
		return subjectDAO.selectSubjectList(paging);
	}

	// 과목 등록
	@Override
	public ServiceResult createSubject(SubjectVO subject) {
	// 과목 인설트
	return subjectDAO.insertSubject(subject)> 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
	// 과목 1개 조회
	@Override
	public SubjectVO retrieveSubject(String subjCd) {
		
		return subjectDAO.selectSubject(subjCd);
	}
	// 과목 수정
	@Override
	public int  modifySubject(SubjectVO subject) {
		int count = 0;
		count += subjectDAO.updateSubject(subject);
		return count;
	}
	// 과목 삭제

	@Override
	public int removeSubject(SubjectVO subject) {
		return subjectDAO.deleteSubject(subject);
	}
	

}
