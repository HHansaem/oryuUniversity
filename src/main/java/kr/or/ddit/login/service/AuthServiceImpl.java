package kr.or.ddit.login.service;

import java.text.MessageFormat;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.or.ddit.login.dao.AuthDAO;
import kr.or.ddit.login.vo.AuthInfo;
import kr.or.ddit.login.vo.AuthInfoWrapper;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Inject
	private AuthDAO authDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AuthInfo user = authDAO.selectUserForAuth(username);
		if(user==null) {
			throw new UsernameNotFoundException(MessageFormat.format("{0} 사용자 없음.", username));
		}
		return new AuthInfoWrapper(user);
	}

}
