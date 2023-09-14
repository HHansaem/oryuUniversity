package kr.or.ddit.login.vo;

import java.io.Serializable;

import lombok.Data;

import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "userId")
public class AuthInfo implements Serializable {
	private String userId;
	private String userPass;
	private String userRole;
	private String userStatus;
	private String userName;
	private String userImage;
}
