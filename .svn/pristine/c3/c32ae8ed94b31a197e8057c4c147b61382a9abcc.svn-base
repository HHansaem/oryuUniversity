package kr.or.ddit.internship.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="inteCd")
public class InternshipVO {
	 private String inteIntrd;
	 @NotBlank private String inteCd;
	  private Integer atchFileId;
	  private String inteTitle;
	  private String intePeri;
	  @DateTimeFormat(iso = ISO.DATE)
	  private LocalDate inteStaDate;
	  @DateTimeFormat(iso = ISO.DATE)
	  private LocalDate inteEndDate;
	  private String inteContPerson;
	  private String inteEmail;
	  private String intePh;
	  private String inteCompNm;
	  private String inteCompAddr;
	  private Integer inteViews=0;
	  private String inteRegion;
	  private String inteDelete;
	  private int reqCont;
	  
	 private MultipartFile[] inteFiles;

		private AtchFileVO fileGroup;
		
}
