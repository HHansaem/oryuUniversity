package kr.or.ddit.academicBusinessPlan.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import lombok.Data;

@Data //Data는 get,set을 선언해준다. Outline 창을 확인
public class ABPVO {
	private long rnum;
	@NotBlank
	private String buPlSn; //학술사업계획순번
	@NotBlank
	private String acBuCd; //학술사업코드
	private String buPlNm; //학술사업계획서이름(명)
	private String buPlShortCont; //학술사업계획서요약내용
	private String buPlCont; //학술사업계획서내용
	private String buPlAutNm; //학술사업계획서작성자이름(명)
	private String buPlEvNm; //학술사업계획서평가명(적합/부적합)
	private String buPlEvCont; //학술사업계획서평가내용(이러이러해서 부적합하다.)
	private String buPlEvAutNm; //학술사업계획서평가작성자명
	private LocalDate buPlDate; //학술사업계획서작성일

	private Integer atchFileId; //첨부파일코드
	
	private MultipartFile [] aBPFiles;//첨부파일 aBPFiles라는 파일
	
	private AtchFileVO fileGroup; //AtchFileVO를 가진 fileGroup
	
	private List<MultipartFile> aBPUploadFiles; // 업로드된 첨부파일 목록을 가진 List<>
	
	// when:서버에서 DB의 정보를 CRUD할때 where:VO에서 what:attribute들을 how:mybatisXML의 SQL query문을 가지고 who: DAO,Mybatis가 why: SQL에 데이터를 이용하려고,클라이언트에 데이터를 보여주려고.
}

/*
 *		AtchFileVO 코드
 *	 	@Data
		@EqualsAndHashCode(of="atchFileId")
		public class AtchFileVO {
			@NotBlank
			private int atchFileId;
			private LocalDate creatDt;
			private boolean useAt;
		private List<AtchFileDetailVO> detailList;
}

 * 		AtchFileDetailVO 코드
 * 		@Data
		@NoArgsConstructor
		@EqualsAndHashCode(of = {"atchFileId", "fileSn"})
		public class AtchFileDetailVO {
			private MultipartFile uploadFile;
			public AtchFileDetailVO(MultipartFile uploadFile) {
				super();
				this.uploadFile = uploadFile;
				
				this.orignlFileNm = uploadFile.getOriginalFilename();
				this.fileExtsn = FilenameUtils.getExtension(orignlFileNm);
				this.fileSize = uploadFile.getSize();
				this.fileMime = uploadFile.getContentType();
				
				this.streFileNm = UUID.randomUUID().toString();
			}
			
			@NotBlank
			private int atchFileId;
			@NotBlank
			private int fileSn;
			@NotBlank
			private String fileStreCours;
			@NotBlank
			private String streFileNm;
			private String orignlFileNm;
			@NotBlank
			private String fileExtsn;
			@ToString.Exclude
			private String fileCn;
			private long fileSize;
			private String fileMime;
}
 * 
	 get&set
	getBuPlSn()
	getAcBuCd()
	getBuPlNm()
	getBuPlShortCont()
	getBuPlCont()
	getBuPlAutNm()
	getBuPlEvNm()
	getBuPlEvCont()
	getBuPlEvAutNm()
	getAtchFileId()
	getABPFiles()
	getFileGroup()
	getABPUploadFiles()
	setBuPlSn(String)
	setAcBuCd(String)
	setBuPlNm(String)
	setBuPlShortCont(String)
	setBuPlCont(String)
	setBuPlAutNm(String)
	setBuPlEvNm(String)
	setBuPlEvCont(String)
	setBuPlEvAutNm(String)
	setAtchFileId(Integer)
	setABPFiles(MultipartFile[])
	setFileGroup(AtchFileVO)
	setABPUploadFiles(List<MultipartFile>)
	 
	 선언된 객체 및 타입
	buPlSn : String
	acBuCd : String
	buPlNm : String
	buPlShortCont : String
	buPlCont : String
	buPlAutNm : String
	buPlEvNm : String
	buPlEvCont : String
	buPlEvAutNm : String
	atchFileId : Integer
	aBPFiles : MultipartFile[]
	fileGroup : AtchFileVO
	aBPUploadFiles : List<MultipartFile>
 */
