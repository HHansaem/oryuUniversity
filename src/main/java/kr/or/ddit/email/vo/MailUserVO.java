package kr.or.ddit.email.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="id")
public class MailUserVO {
	 private String mailId;
	 private String mailPw;
	@NotBlank private String userId;
	 private String mailUrl;
	 private String mailPort;
	 
}
