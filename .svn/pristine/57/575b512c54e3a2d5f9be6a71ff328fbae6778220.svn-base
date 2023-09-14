package kr.or.ddit.lecture.service;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.academic.vo.AcademicNoticeVO;
import kr.or.ddit.atch.service.AtchFileService;
import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.enrollment.dao.EnrollmentDAO;
import kr.or.ddit.enrollment.vo.EnrollmentVO;
import kr.or.ddit.lecture.dao.LectureDAO;
import kr.or.ddit.lecture.vo.LectureVO;
import kr.or.ddit.serviceresult.ServiceResult;
import kr.or.ddit.student.vo.StudentVO;

/**
 * 강의 serviceImpl
 * @author rottw
 *
 */
@Service
public class LectureServiceImpl implements LectureService {
	
	@Inject
	private LectureDAO lectureDAO;
	@Inject
	private EnrollmentDAO enrollDAO;
	
	@Inject
	private AtchFileService atchService;
	@Value("#{appInfo.CommonAtchPath}")
	private Resource atchPath;
	
	private void processAtchFileGroup(LectureVO lecture) {
		MultipartFile[] lectureFiles = lecture.getLectureFiles();
		if(lectureFiles==null) return;
		List<AtchFileDetailVO> detailList = new ArrayList<>();
		for(MultipartFile lectureFile : lectureFiles) {
			if(lectureFile.isEmpty()) continue;
			detailList.add( new AtchFileDetailVO(lectureFile));
		}
		if(detailList.size()>0) {
			AtchFileVO fileGroup = new AtchFileVO();
			fileGroup.setDetailList(detailList);
			try {
				int atchFileId = atchService.createAtchFileGroup(fileGroup, atchPath);
				lecture.setAtchFileId(atchFileId);
			}catch(IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	// 전체 강의 조회
	@Override
	public List<LectureVO> retrieveLectureList(PaginationInfo paging) {
		// 토탈자료 개수
		long totalRecord = lectureDAO.selectTotalRecord(paging);
		// 페이징 객체에 토탈레코드 저장
		paging.setTotalRecord(totalRecord);
		// 페이징 객체를 이용하여 전체 강의 조회 후 리턴
		return lectureDAO.selectLectureList(paging);
	}

	// 강의 등록(교직원)
	@Override
	public ServiceResult createLecture(LectureVO lecture) {
		processAtchFileGroup(lecture);
		return lectureDAO.insertLecture(lecture)> 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
	// 강의 수정(교직원)
	@Override
	public ServiceResult modifyLecture(LectureVO lecture) {
		processAtchFileGroup(lecture);
		return lectureDAO.updateLecture(lecture)> 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
	
	// 강의 요청(교수)
	@Override
	public ServiceResult submitLecture(LectureVO lecture) {
		processAtchFileGroup(lecture);
		return lectureDAO.requestLecture(lecture)> 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}
	// 강의 요청 수락(교직원)
	@Override
	public int allowLecture(LectureVO lecture) {
		return lectureDAO.responseLecture(lecture);
	}
	// 강의 등록 완료(교직원)
	@Override
	public int rejectLecture(LectureVO lecture) {
		return lectureDAO.refuseLecture(lecture);
	}
	// 수강 등록 완료(교직원)
	@Override
	public int commitEnrollment(LectureVO lecture) {
		return lectureDAO.commitEnrollment(lecture);
	}
	// 휴강 등록 완료(교직원)
	@Override
	public int stateEnrollment(LectureVO lecture) {
		return lectureDAO.standEnrollment(lecture);
	}
	// 강의 조회(강의코드) 
	@Override
	public LectureVO retrieveLecture(String lecCd) {
		return lectureDAO.selectLecture(lecCd);
	}
	// 강의 스케쥴조회(강의코드)
	@Override
	public LectureVO retrieveLectureSchedule(String lecCd) {
		return lectureDAO.selectLectureSchedule(lecCd);
	}
	// 교수 현재 학기 본인강의 조회
	@Override
	public List<LectureVO> retrieveCurrentLectureList(String professorId) {
		return lectureDAO.selectCurrentLectureList(professorId); 
	}
	// 교수 현재 학기 본인수업 조회
	@Override
	public List<LectureVO> retrieveCurrentClassList(String studentId) {
		return lectureDAO.selectCurrentClassList(studentId);
	}
	// 강의 상세조회
	@Override
	public LectureVO retrieveLectureDetail(String lecCd) {
		return lectureDAO.selectLectureDetail(lecCd);
	}

	// 학생 현재학기 시간표조회
	@Override
	public List<EnrollmentVO> retrieveTimeTable(String stCd) {

		return lectureDAO.selectTimeTable(stCd);
	}

	@Override
	public List<EnrollmentVO> retrievecurrentLec(String stCd) {
		return lectureDAO.selectCurrentLecList(stCd);
	}

	@Override
	public List<LectureVO> retrievePRTimeTable(String prCd) {
		List<LectureVO> currentLec = lectureDAO.selectPRTimeTable(prCd);
		for(LectureVO lec : currentLec) {
			int count = enrollDAO.countStudent(lec.getLecCd());
			lec.setEnrollmentCount(count);
		}
		return currentLec;
	}


	
	

}
