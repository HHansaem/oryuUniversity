package kr.or.ddit.lectureContents.vo;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.common.validate.DeleteGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = "vlsCd")
public class VideoLectureVO {

	@NotBlank(groups = {UpdateGroup.class, DeleteGroup.class})
	private String vlsCd;
	@NotBlank
	@NonNull
	private String lecCd;
	private Integer atchFileId;
	@NotBlank
	private String vlTitle;
	@NotBlank
	private String vlCont;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime vlStaTime;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime vlEndTime;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime vlVtTime;
	private String vlAttendCheck;
	
	private MultipartFile vlFile;
	
	private AtchFileVO fileGroup;
	
	public boolean getVideoAvailable() {
		LocalDateTime now = LocalDateTime.now();
		if(vlEndTime == null) {
			return false;
		}
		return now.isBefore(this.vlEndTime); 
	}
	
	public String getEndTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시 mm분", Locale.KOREA);
		if(vlEndTime == null) {
			return "";
		}
		return vlEndTime.format(formatter);
	}
}
