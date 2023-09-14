package kr.or.ddit.lectureContents.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(of = "esCd")
@NoArgsConstructor
public class ExamSubmitVO {

	public ExamSubmitVO(String examCd, String lecCd, String stCd) {
		this.examCd = examCd;
		this.lecCd = lecCd;
		this.stCd = stCd;
	}

	@NotBlank(groups=UpdateGroup.class)
	private String esCd;
	@NotBlank
	private String examCd;
	@NotBlank
	private String lecCd;
	@NotBlank
	private String stCd;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime esDate;
	private Integer esScore;
	
	private String stNm;
	private String dtNm;
	private Integer examScore;
	private String examType;
	
	private List<ExamQuestSubmitVO> examQueSubmitList;
	
	public String getSubmitTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시 mm분", Locale.KOREA);
		if(esDate == null) {
			return "";
		}
		return esDate.format(formatter);
	}
	
	
}
