package kr.or.ddit.schedule.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.schedule.dao.AcademicScheduleDAO;
import kr.or.ddit.schedule.vo.AcademicScheduleVO;

@Service
public class AcademicScheduleServiceImpl implements AcademicScheduleService {

	@Inject
	private AcademicScheduleDAO acaScheduleDAO;
	
	@Override
	public List<AcademicScheduleVO> retrieveAcademicScheduleList(PaginationInfo paging) {
		long totalRecord = acaScheduleDAO.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return acaScheduleDAO.selectAcademicScheduleLsit(paging);
	}

	@Override
	public AcademicScheduleVO retrieveAcademicSchedule(String asCd) {
		return acaScheduleDAO.selectAcademicSchedule(asCd);
	}

	@Override
	public boolean createAcademicSchedule(AcademicScheduleVO acaSchedule) {
		boolean result;
		int cnt = acaScheduleDAO.insertAcademicSchedule(acaSchedule);
		if(cnt > 0) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean modifyAcademicSchedule(AcademicScheduleVO acaSchedule) {
		boolean result;
		int cnt = acaScheduleDAO.updateAcademicSchedule(acaSchedule);
		if(cnt > 0) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean removeAcademicSchedule(AcademicScheduleVO acaSchedule) {
		boolean result;
		int cnt = acaScheduleDAO.deleteAcademicSchedule(acaSchedule);
		if(cnt > 0) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}

	@Override
	public long getTotalRecordCount(PaginationInfo paging) {
		return acaScheduleDAO.selectTotalRecord(paging);
	}

	@Override
	public List<AcademicScheduleVO> getCalendar(String asCd) {
		return acaScheduleDAO.getCalendar(asCd);
	}

}
