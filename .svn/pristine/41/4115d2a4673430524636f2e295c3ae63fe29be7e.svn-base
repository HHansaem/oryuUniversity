package kr.or.ddit.login.vo;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class AuthInfoWrapper extends User {
	private AuthInfo realUser;
    
	public AuthInfoWrapper(AuthInfo realUser) {
		super(realUser.getUserId(),
			  realUser.getUserPass(),
			  !realUser.getUserStatus().equals("탈퇴"),
			  true,
			  true,
			  true,
			  AuthorityUtils.createAuthorityList(realUser.getUserRole())
		);
		this.realUser = realUser;
	}
	
	public AuthInfo getRealUser() {
		return realUser;
	}
	
}
