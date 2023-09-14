package kr.or.ddit.schedule.vo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "asCd")
public class AcademicScheduleVO implements Serializable {
	private long rnum;
	@NotBlank
	private String asCd;
	private String asNm;
	private String asDistinction;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate asStart;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate asEnd;
	private String asCont;
	private String asAccePerm;
	
}
