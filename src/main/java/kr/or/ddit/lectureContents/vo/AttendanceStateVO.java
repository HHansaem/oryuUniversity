package kr.or.ddit.lectureContents.vo;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.common.validate.InsertGroup;
import kr.or.ddit.common.validate.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "attsCd")
public class AttendanceStateVO implements Comparable<AttendanceStateVO>{
	@NotBlank(groups=UpdateGroup.class)
	private String attsCd;
	@NotBlank
	private String attsSche;
	@NotBlank
	private String attsState;
	@NotBlank
	private String attsWeek;
	@NotBlank(groups=InsertGroup.class)
	private String attCd;
	
	private String prevAttsState;

	@Override
	public int compareTo(AttendanceStateVO other) {
		return Integer.compare(Integer.parseInt(this.attsWeek), Integer.parseInt(other.attsWeek));
	}
}
