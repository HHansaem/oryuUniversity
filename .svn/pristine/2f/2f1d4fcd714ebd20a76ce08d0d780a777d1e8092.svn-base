package kr.or.ddit.job.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.job.vo.AdVO;
import kr.or.ddit.job.vo.JobVO;
import kr.or.ddit.student.vo.StudentVO;

@Mapper
public interface JobDAO {
	// 페이징처리를 위한 전체 레코드 개수 조회
	public long selectTotalRecord(PaginationInfo paging);
	// 전체 공고 조회
	public List<JobVO> selectJobList(PaginationInfo paging);
	// 공고 등록
	public int insertJobAd(JobVO job);
	// 전체 광고 조회
	public List<AdVO> selectAdList(PaginationInfo paging);
	// 광고 등록
	public int insertAd(AdVO ad);
	// 페이징처리를 위한 전체 레코드 개수 조회(for Ad)
	public long selectTotalAd(PaginationInfo paging);
	// 페이징처리를 위한 학생 수 체크
	public long selectTotal(PaginationInfo<StudentVO> paging);
	// 학생 리스트 불러오기
	public List<StudentVO> selectStudent(PaginationInfo<StudentVO> paging);
	// 취업률 계산
	public StudentVO selectEmpInfo(StudentVO studentVO);
	// 지역별 취업자
	public List<StudentVO> selectEmpLoc(StudentVO studentVO);
}
