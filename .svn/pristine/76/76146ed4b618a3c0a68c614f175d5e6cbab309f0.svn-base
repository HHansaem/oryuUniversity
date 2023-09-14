package kr.or.ddit.tuition.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import lombok.Data;

@Data
public class TuitionVO {

	@NotBlank
	private String semesterCd;
	@NotBlank
	private String stCd;
	@NotBlank
	private String dtCd;
	private String tuAmount;
	private LocalDate tuStart;
	private LocalDate tuEnd;
	private String tuPay;
	private LocalDate tuDate;
	private String tuSchType;
	private String tuSchAmo;
	private String tuSchSta;
	private String tuSchCon;
	private String tuWhether;
	private LocalDate tuSchDate;
	private String tuRea;
	private LocalDate tuAppDate;
	private String tuAccNum;

	private MultipartFile[] tuFiles;
	private AtchFileVO fileGroup;
	private Integer atchFileId;
	
	private String stNm;
	private String dtNm;
	private String stPh;

}
