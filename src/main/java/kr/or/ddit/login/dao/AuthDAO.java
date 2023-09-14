package kr.or.ddit.login.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.login.vo.AuthInfo;

@Mapper
public interface AuthDAO {
	public AuthInfo selectUserForAuth(String userId);

}
