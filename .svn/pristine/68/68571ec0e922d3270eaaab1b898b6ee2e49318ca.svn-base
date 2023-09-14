package kr.or.ddit.thesis.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import lombok.Data;

/**
 * @author PC-22 논문 VO입니다.
 */
@Data
public class ThesisVO {

	private long rnum;
	@NotBlank
	private String thesSn; // 논문순번
	@NotBlank
	private String acBuCd; // 학술사업코드
	private String thesClNm; // 논문분류명
	private String thesNm; // 논문명
	private String thesAutNm1; // 논문1저자명
	private String thesAutNm2; // 논문2저자명
	private String thesShortCont; // 논문요약
	private String thesCont; // 논문내용
	private LocalDate thesPostDate; // 논문게시일자
	private LocalDate thesModDate; // 논문수정일자
	private String thesFic; // 논문사진
	
	// --- 파일 업로드 부분 ---
	
		private Integer atchFileId; //첨부파일코드
		
		private MultipartFile[] thesFiles; //acBuDoc첨부파일
		
		private AtchFileVO fileGroup; //AtchFileVO를 가진 fileGroup
		
		private List<MultipartFile> ThesUploadFiles; //첨부파일 리스트를 가진 acBuDocFiles
}
