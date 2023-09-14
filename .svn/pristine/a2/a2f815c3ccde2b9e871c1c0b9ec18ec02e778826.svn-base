package kr.or.ddit.club.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.professor.vo.ProfessorVO;
import kr.or.ddit.student.vo.StudentVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="clubCd")
public class ClubVO{
	@NotBlank private String clubCd;
     private Integer prCd;
	 private String stCd;
	 private String clubStat;
	 private String clubColsApplForm;
	 private String clubDetail;
	 private String clubFicFile;
	 private String clubNm;
	 private String clubPlan;
	 @DateTimeFormat(iso = ISO.DATE)
	 private LocalDate clubAppDate;
	 private String clubStatus;
	 private String clubRefuse;
	 private String clubOrigiCd;
	 
	 
	 private MultipartFile[] acaChFiles;

		private Integer atchFileId;

		private AtchFileVO fileGroup;
	 
	 private ProfessorVO professorVO;
	 private StudentVO studentVO;
}
