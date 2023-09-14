package kr.or.ddit.email.controller;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.email.service.MailUserServiceImpl;
import kr.or.ddit.email.vo.MailUserVO;
import kr.or.ddit.email.vo.ReceiveMailVO;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/mail")
public class MailMapController {
	private String userName = "";
	private String password = "";
	
	
	
	@Inject
	private MailUserServiceImpl receiver;
	
	@Value("#{appInfo.CommonAtchPath}")//el코드를 쓸수있는 어노테이션
	private Resource CommonAtchPath;
	private File saveFolder;
	
	@PostConstruct
	public void init(
			
			) throws IOException {
    
    
		saveFolder = CommonAtchPath.getFile();
	
		if(!saveFolder.exists())
			saveFolder.mkdirs();
		
		log.info("로딩된 saveFolder : {}",saveFolder.getCanonicalPath());
	}
	
	
	
	
	//메일 페이징 리스트
		@RequestMapping("/mailList.do")
		@ResponseBody
		public PaginationInfo<ReceiveMailVO> mailPagingList(HttpServletRequest request
				    ,Authentication authentication
					,@RequestParam(name="page", required=false, defaultValue="1") int currentPage) throws ParseException, MessagingException, IOException {
			
	    String saveDirectory = "D:\\saveFiles\\";
	    receiver.setSaveDirectory(saveFolder);
	   
	    MailUserVO mailUserVO = receiver.mailAutoLogin(authentication.getName());
	    userName = mailUserVO.getMailId();
		password = mailUserVO.getMailPw();
		PaginationInfo<ReceiveMailVO> pagingVO = new PaginationInfo<>(10,3);
			if(StringUtils.isBlank(password)) {
				
				return pagingVO;
			}else {
				pagingVO.setCurrentPage(currentPage);
				
				int totalRecord = receiver.retrieveMailCount(pagingVO,userName, password);
				pagingVO.setTotalRecord(totalRecord);
				
				
			    List<ReceiveMailVO> mailList = receiver.receiveMailAttachedFilePaging(authentication.getName(),request, currentPage);
			    pagingVO.setDataList(mailList);
		   
		    	return pagingVO;
			}
		}
	
	//메일 하나삭제
	@PostMapping(value="/mailDelete.do")
	@ResponseBody
	public boolean mailDelete(Integer mailNo
			 ,Authentication authentication
			   				  ,HttpSession session) throws ParseException, MessagingException, IOException {
		MailUserVO mailUserVO = receiver.mailAutoLogin(authentication.getName());;
		userName = mailUserVO.getMailId();
		password = mailUserVO.getMailPw();
	    	boolean result = receiver.deleteMail(mailNo, userName, password);
 
    return result;
	}
	
	//메일 하나삭제
	@PostMapping(value="/mailDetailDelete.do")
	public String mailDetailDelete(Integer mailNo
			 ,Authentication authentication
								  ,HttpSession session) throws ParseException, MessagingException, IOException {
		
		  MailUserVO mailUserVO = receiver.mailAutoLogin(authentication.getName());
		    userName = mailUserVO.getMailId();
			password = mailUserVO.getMailPw();
			boolean result = receiver.deleteMail(mailNo, userName, password);
	    
	   
			String viewName = "redirect:/groupware/mail/mailList.do";
	 
	return viewName;
	}
	
	//메일체크박스삭제
		@PostMapping(value="/mailCheckDelete.do")
		@ResponseBody
		public boolean mailCheckDelete(@RequestParam("deleteNos[]") String [] deleteNos
				 ,Authentication authentication
										,HttpSession session) throws ParseException, MessagingException, IOException {
			
			 Integer[] intDeletetNos = Stream.of(deleteNos).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
			 MailUserVO mailUserVO = (MailUserVO) session.getAttribute("authEmp");
			    userName = mailUserVO.getMailId();
				password = mailUserVO.getMailPw();
			boolean result	 = receiver.deleteCheckMail(intDeletetNos, userName, password);
		
	    return result;
		}
	
}
