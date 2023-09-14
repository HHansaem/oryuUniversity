package kr.or.ddit.lectureSchedule.vo;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.common.vo.ClassRoomVO;
import kr.or.ddit.common.vo.DaytimeScheduleVO;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 강의스케쥴 vo
 * @author rottw
 *
 */
@Data
@EqualsAndHashCode(of = {"clasCd","scheCd","lecCd"} )
public class LectureScheduleVO {
	@NotBlank
	private String clasCd;
	@NotBlank
	private String scheCd;
	@NotBlank
	private String lecCd;
	
	private String[] combinedValues;
	
	private String scheTime;
	private String lecMon;
	private String lecTue;
	private String lecWed;
	private String lecThu;
	private String lecFri;
	private String clasNm;
	
	private ClassRoomVO classroom;
	
	private DaytimeScheduleVO dayTimeSchedule;
	
	private String scheCds;
	
	
}
