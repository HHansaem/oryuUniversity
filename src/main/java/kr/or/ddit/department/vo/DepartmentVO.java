package kr.or.ddit.department.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.college.vo.CollegeVO;
import kr.or.ddit.subject.vo.SubjectVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "dtCd")
public class DepartmentVO {

	@NotBlank
	private String dtCd;
	@NotBlank
	private String colgeCd;
	
	private String attCd;
	private String dtNm;
	private String dtAddr;
	private String dtPh;
	private LocalDate dtEstablishment;
	private String dtStat;
	private String dtUrl;
	
	private CollegeVO college;
	
	private List<SubjectVO> subjectLt;
	
	private String prCd;
	private String prNm;
	private String colgeNm;
	

}
