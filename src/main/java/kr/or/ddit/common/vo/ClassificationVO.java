package kr.or.ddit.common.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 이수구분VO
 * @author rottw
 *
 */
@Data
@EqualsAndHashCode(of = "cfCode")
public class ClassificationVO {

	@NotBlank
	private String cfCode;
	@NotBlank
	private String cfName;

}
