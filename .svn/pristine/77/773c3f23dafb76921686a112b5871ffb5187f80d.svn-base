package kr.or.ddit.subject.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.common.validate.InsertGroup;
import kr.or.ddit.common.validate.UpdateGroup;
import kr.or.ddit.common.vo.ClassificationVO;
import kr.or.ddit.department.vo.DepartmentVO;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 과목을 다루기 위한 VO (속성값 과목코드, 학과코드, 과목명, 이수구분)
 * @author rottw
 *
 */
@Data
@EqualsAndHashCode(of = "subjCd")
public class SubjectVO implements Serializable {

	private long rnum;
	private String subjCd;
	@NotBlank(groups = {InsertGroup.class, UpdateGroup.class})
	private String dtCd;
	@NotBlank(groups = {InsertGroup.class, UpdateGroup.class})
	private String subjNm;
	@NotBlank(groups = {InsertGroup.class, UpdateGroup.class})
	private String subjComType;
	private String subjStat;
	
	private DepartmentVO department;
	
	private ClassificationVO Classification;

}
