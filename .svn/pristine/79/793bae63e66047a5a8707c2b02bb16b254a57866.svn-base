package kr.or.ddit.email.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.email.vo.MailUserVO;
import kr.or.ddit.email.vo.ReceiveMailVO;

public interface MailUserService {
	
	/**
	 * 받은메일함
	 * @param id
	 * @return
	 */
	public List<ReceiveMailVO> receiveMailAttachedFile(String id,HttpServletRequest request,String userName, String password, Date startDate, Date endDate);


	public void setSaveDirectory(String dir);
	
	public List<ReceiveMailVO> deleteMail(Integer mailNo, String userName, String password);

}
