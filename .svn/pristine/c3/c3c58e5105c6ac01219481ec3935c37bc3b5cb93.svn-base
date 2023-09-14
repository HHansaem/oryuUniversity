package kr.or.ddit.researchJournal.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "rjSn") // 연구일지 순번!
public class ResearchJournalVO implements Serializable {
	
	private long rnum; //글의 순번을 위한 rnum
	@NotBlank
	private String rjSn; //연구일지의 순번(일련번호라 보면됨.)
	@NotBlank
	private String reseCd; //연결된 연구 번호
	private String rjNm; //연구일지명
	private String rjAutNm; //연구일지저자명
	private String rjContent; //연구일지내용
	private String rjFile; //연구일지첨부파일
	private LocalDate rjDate; //연구일지작성일 게시일.

	private MultipartFile[] rjFiles; //멀티파트파일, 연구일지파일들
	
	private Integer atchFileId; //첨부파일코드
	
	private AtchFileVO fileGroup; //atchFileId; //첨부파일코드
	
}
