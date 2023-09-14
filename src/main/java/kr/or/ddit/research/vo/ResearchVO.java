package kr.or.ddit.research.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import lombok.Data;

/**
 * 연구 & 연구일지 VO 클래스
 */
@Data
public class ResearchVO {

	private long rnum; // Research DataBase 행 순번
	
	@NotBlank
	private String reseCd;        // 연구 코드 (필수)

	@NotBlank
	private String acBuCd;        // 학술사업코드 (필수)

	private String reseNm;     // 연구 명

	private String reseShortCont; // 연구 요약 설명

	private String reseCont;      // 연구 내용

	private LocalDate reseDate;   // 연구 작성날짜

	private String reseStat;      // 연구 상태

	private String reseAutNm;     // 연구 책임자명

	
	//--- 파일 업로드 부분 ---
	
	private Integer atchFileId;   // 첨부 파일 ID

	private MultipartFile[] reseFiles; // research 첨부파일
	
	private AtchFileVO fileGroup; //AtchFileVO를 가진 fileGroup
	
	private List<MultipartFile> reseUploadFiles; //첨부파일 리스트를 가진 acBuDocFiles
}
