package kr.or.ddit.schedule.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.schedule.vo.AcademicScheduleVO;

@Mapper
public interface AcademicScheduleDAO {
	
	public long selectTotalRecord(PaginationInfo paging);
	
	public List<AcademicScheduleVO> selectAcademicScheduleLsit(PaginationInfo paging);
	public AcademicScheduleVO selectAcademicSchedule(String asCd);
	
	public int insertAcademicSchedule(AcademicScheduleVO acaSchedule);
	public int updateAcademicSchedule(AcademicScheduleVO acaSchedule);
	public int deleteAcademicSchedule(AcademicScheduleVO acaSchedule);
	
	public List<AcademicScheduleVO> getCalendar(String asCd);

}
