package kr.or.ddit.academicBusinessReport.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class ABRVO {

	private long rnum; // 게시글 순번을 위한 long rnum선언
	@NotBlank
	private String buReSn; //사업보고서순번
	@NotBlank
	private String acBuCd; //학술사업코드
	private String buReNm; //보고서이름
	private String buReShortCont; //보고서요약내용
	private String buReCont; //보고서내용
	private String buReAutNm; //보고서 작성자명
	private String buReEvNm; //보고서평가명 -> ex)부적합, 평가, 요청 등등
    private String buReEvCont; //보고서평가내용
    private LocalDate buReDate; //보고서 게시일자
    private String buReEvAutNm; //보고서평가작성자명
	
    private Integer atchFileId; //첨부파일코드
	
    private MultipartFile[] aBRFiles; //보고서 첨부파일들.
	
	private AtchFileVO fileGroup; //첨부파일을 사용하기 위한 fileGroup
	
	private List<MultipartFile> aBRUploadFiles; //aBR 업로드를 위한 리스트
}
