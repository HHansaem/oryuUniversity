package kr.or.ddit.college.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.department.vo.DepartmentVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author PC-22 단대(단과대)의 VO입니다.
 */

@Data
@EqualsAndHashCode(of = "colegeCd")
public class CollegeVO {

	@NotBlank
	private String colgeCd;
	
	private String attCd;
	private String colgeNm;
	private String colgeAddr;
	private String colgePh;
	private LocalDate collegeEstablishment;
	private String colgeStat;
	private String colgeUrl;
	
	private List<DepartmentVO> departmentList;
	

}
