package kr.or.ddit.schedule.vo.adapter;

import java.time.LocalDate;
import java.time.LocalDateTime;

import kr.or.ddit.schedule.vo.AcademicScheduleVO;

public class AcaSchedultWrapper extends FullCalendarEvent<AcademicScheduleVO>{

	public AcaSchedultWrapper(AcademicScheduleVO adaptee) {
		super(adaptee);
	}

	@Override
	public String getId() {
		return getData().getAsCd();
	}

	@Override
	public String getTitle() {
		return getData().getAsNm();
	}

	@Override
	public LocalDateTime getStart() {
		return getData().getAsStart().atStartOfDay();
	}

	@Override
	public LocalDateTime getEnd() {
	    // 종료일시에 하루를 더하고, 그 날의 시작 순간으로 설정
	    LocalDate endDate = getData().getAsEnd().plusDays(1);
	    return endDate.atStartOfDay();
	}
	
	public String getAsDistinction() {
	    return getData().getAsDistinction();
	  }

}
