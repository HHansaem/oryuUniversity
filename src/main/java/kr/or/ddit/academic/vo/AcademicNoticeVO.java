package kr.or.ddit.academic.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "anNum")
public class AcademicNoticeVO {
	private long rnum;
	@NotBlank
	private int anNum;
	private String attCd;
	@NotBlank
	private String anTitle;
	private String anWriter;
	private LocalDate anPostDate;
	private String anCont;
	private Integer anViews;
	
	private MultipartFile[] acaNoticeFiles;
	
	private Integer atchFileId;
	
	private AtchFileVO fileGroup;
	
	private List<MultipartFile> acaNoticeUploadFiles; // 업로드된 첨부파일 목록
}
