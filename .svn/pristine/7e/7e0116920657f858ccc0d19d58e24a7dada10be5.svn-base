package kr.or.ddit.email.dao;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.email.vo.MailUserVO;

@Mapper
public interface MailUserDAO {

/**
 * 메일 자동 로그인
 */
public MailUserVO mailAutoLogin(String id);

/**
 * 메일 아이디 등록
 */
public int mailIDInsert(MailUserVO mail);
	
/**
 * 아이디 체크
 */
public int mailCheck(String id);




}
