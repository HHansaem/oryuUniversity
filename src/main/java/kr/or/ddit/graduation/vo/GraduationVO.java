package kr.or.ddit.graduation.vo;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;

@Data
public class GraduationVO {
	@NotBlank(groups = {InsertGroup.class, UpdateGroup.class})
	private String geGradCondType;
	@NotBlank(groups = {InsertGroup.class, UpdateGroup.class})
	private String colgeCd;
	@NotBlank(groups = UpdateGroup.class)
	private String gradCond;
	
	private String dtNm;
	private String colgeNm;
}
