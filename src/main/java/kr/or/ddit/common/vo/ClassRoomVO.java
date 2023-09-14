package kr.or.ddit.common.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 강의실 VO
 * @author rottw
 *
 */
@Data
@EqualsAndHashCode(of = "clasCd")
public class ClassRoomVO implements Serializable {
	@NotBlank
	private String clasCd;
	private String clasNm;

}
