package kr.or.ddit.security;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import kr.or.ddit.login.vo.AuthInfo;
import kr.or.ddit.login.vo.AuthInfoWrapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		authentication.getAuthorities();
		HttpSession session = request.getSession();
		
		AuthInfoWrapper principal = (AuthInfoWrapper) authentication.getPrincipal();
		AuthInfo realUser = principal.getRealUser();
		session.setAttribute("memName", realUser.getUserName());
		session.setAttribute("memImage", realUser.getUserImage());
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
