package kr.or.ddit.job.service;

import java.util.List;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.job.vo.AdVO;
import kr.or.ddit.job.vo.JobVO;
import kr.or.ddit.student.vo.StudentVO;

public interface JobService {

	// 전체 공고 조회
	public List<JobVO> retriveJobList(PaginationInfo paging);

	// 공고 등록
	public int createJobAd(JobVO job);
	
	// 전체 광고 조회
	public List<AdVO> retrieveAdList(PaginationInfo paging);
	
	// 광고 등록
	public int createAd(AdVO ad);

	// 학생 리스트 불러오기	
	public List<StudentVO> retrieveStudentList(PaginationInfo<StudentVO> paging);
	
	// 취업률 계산
	public StudentVO retrieveEmpInfo(StudentVO studentVO);
	
	// 지역별 취업자
	public List<StudentVO> retrieveEmpLoc(StudentVO studentVO);

}
