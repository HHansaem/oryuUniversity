package kr.or.ddit.enrollment.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.enrollment.vo.EnrollmentVO;
import kr.or.ddit.lecture.vo.LectureVO;

public interface EnrollmentService {
	
	// 수강신청목록 조회(교직원)
	public List<EnrollmentVO> retrieveEnrollmentList(PaginationInfo paging);

	// 수강요청확정 (교직원)
	public int acceptEnrollment(List<EnrollmentVO> reqList);
	
	// 수강요청거절 (교직원)
	public int rejectEnrollment(List<EnrollmentVO> reqList);
	
	// 수강신청목록 조회 (학생)
	public List<EnrollmentVO> retrieveMyEnrollmentList(String stCd);
	
	// 수강 신청
	public int sendEnrollement(EnrollmentVO enrollment);
	
	// 수강신청 취소(학생)
	public int deleteEnrollment(EnrollmentVO enrollment);

	// 학생 현재 학기 수강목록 조회
	public List<EnrollmentVO> retrieveSTEnrollmentList(String stCd);
	
	// 강의별 성적 비율 조회
	public LectureVO retrieveGradeRate(String lecCd);
	
	// 모든 점수 조회(과제, 출석, 시험, 최종)
	public List<EnrollmentVO> selectAllScore(PaginationInfo paging, String lecCd);

	// 등급 업데이트
	public int modifyGrade(String lecCd, String stCd, String graRating, String graStatus);
	
	// 학생 현재 학기 성적 정보 조회
	public List<EnrollmentVO> retrieveGradeInfo(String stCd);

	// 학생 전체 성적 정보 조회
	public List<EnrollmentVO> retrieveAllGradeInfo(EnrollmentVO enrollment);
	
	// 학생 현재학기 수강 학점 조회
	public String retrieveCurrentLecCred(String stCd);

	// 학생 전체 수강 학점 조회
	public String retrieveTotalLecCred(String stCd);
	
	// 학생 전체 전공 수강 학점 조회
	public String retrieveTotalMajorLecCred(String stCd);
	
	// 학생 전체 학점 평균 조회
	public List<EnrollmentVO> retrieveAvgGrade(String stcd);

	// 학생 전공 학점 평균 조회
	public List<EnrollmentVO> retrieveMajorAvgGrade(String stcd);
}

