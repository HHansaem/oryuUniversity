package kr.or.ddit.email.service;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;
import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.UIDFolder;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.vo.PaginationInfo;
import kr.or.ddit.email.dao.MailUserDAO;
import kr.or.ddit.email.vo.MailUserVO;
import kr.or.ddit.email.vo.ReceiveMailVO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailUserServiceImpl {

    @Inject
    private MailUserDAO mailDAO;

    private File saveDirectory;
    private Map<String, ReceiveMailVO> mailMap;
    private ServletContext application;

    public void setSaveDirectory(File dir) {
        this.saveDirectory = dir;
    }

    // 메일 수신 (첨부파일 포함)
    public List<ReceiveMailVO> receiveMailAttachedFile(String id, Date startDate, Date endDate)
            throws MessagingException, IOException {
        List<ReceiveMailVO> mailList = new ArrayList<>();

        MailUserVO mailInfo = mailDAO.mailAutoLogin(id);
        String userName = mailInfo.getMailId();
        String password = mailInfo.getMailPw();
        String host = mailInfo.getMailUrl();
        int port = Integer.parseInt(mailInfo.getMailPort());

        Properties props = new Properties();
        props.put("mail.imaps.host", host);
        props.put("mail.imaps.port", port);
        props.put("mail.imaps.starttls.enable", "true");

        Session session = Session.getDefaultInstance(props);

        try {
            Store store = session.getStore("imaps");
            store.connect(host, userName, password);

            Folder inbox = store.getFolder("INBOX");
            UIDFolder uf = (UIDFolder) inbox;

            inbox.open(Folder.READ_ONLY);
            SearchTerm olderThan = new ReceivedDateTerm(ComparisonTerm.LT, startDate);
            SearchTerm newerThan = new ReceivedDateTerm(ComparisonTerm.GT, endDate);
            SearchTerm andTerm = new AndTerm(olderThan, newerThan);

            Message[] arrayMessages = inbox.getMessages();

            for (int i = arrayMessages.length; i > 970; i--) {
                Message msg = arrayMessages[i - 1];
                Address[] fromAddress = msg.getFrom();
                // 메일 내용 변수에 담기

                log.info("message:{}", msg.toString());
                ReceiveMailVO mail = new ReceiveMailVO();

                int index = fromAddress[0].toString().indexOf("<");

                String str = fromAddress[0].toString().substring(index + 1);

                String from = str.substring(0, str.length() - 1);

                int idIndex = from.indexOf("@");
                String sendId = from.substring(0, idIndex);
                String subject = msg.getSubject();
                String sentDate = msg.getSentDate().toString();
                String receivedDate = msg.getReceivedDate().toString();
                String contentType = msg.getContentType();
                String messageContent = msg.getContent().toString();
                String attachFiles = "";

                mail.setMailNo(i);
                mail.setSendId(sendId);
                mail.setFrom(from);
                mail.setSubject(subject);
                mail.setSentDate(sentDate);
                mail.setReceivedDate(receivedDate);
                mail.setContentType(contentType);
                mail.setMessageContent(messageContent);

                // 첨부파일
                if (contentType.contains("multipart")) {
                    Multipart multiPart = (Multipart) msg.getContent();
                    int numberOfParts = multiPart.getCount();
                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                            // 첨부파일 있을 경우 지정 폴더로 저장
                            String fileName = part.getFileName();
                            attachFiles += fileName + ", ";
                            // part.saveFile(saveDirectory + File.separator + fileName);
                        } else {
                            // 메일 내용 저장
                            messageContent = part.getContent().toString();
                            mail.setMessageContent(messageContent);
                        }
                    }
                    if (attachFiles.length() > 1) {
                        attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
                        mail.setAttachFiles(attachFiles);
                    }
                } else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
                    Object content = msg.getContent();
                    if (content != null) {
                        messageContent = content.toString();
                    }
                }

                mailMap.put("mail" + i, mail);

                mailList.add(mail);

                application.setAttribute("mailMap", mailMap);
            }

            // disconnect
            inbox.close(false);
            store.close();

        } catch (MessagingException e) {
            log.error("Error while receiving mail.", e);
            // 예외 처리 로직 추가
        }

        return mailList;
    }



	
	 //페이징용받은메일함
	public List<ReceiveMailVO> receiveMailAttachedFilePaging(String id, HttpServletRequest request,  int page) throws MessagingException, IOException, ParseException {
	    List<ReceiveMailVO> mailList = new ArrayList<>();
	    Map<String, ReceiveMailVO> mailMap = new LinkedHashMap<>();

	    // application 변수를 스프링 환경에서 가져오도록 수정
	    ServletContext application = request.getServletContext();

	    MailUserVO mailInfo = mailDAO.mailAutoLogin(id);
	    String host = mailInfo.getMailUrl();
	    String userName = mailInfo.getMailId();
	    String password = mailInfo.getMailPw();
	    int port = Integer.parseInt(mailInfo.getMailPort());

	    Properties props = new Properties();
	    props.put("mail.imaps.host", host);
	    props.put("mail.imaps.port", port);
	    props.put("mail.imaps.starttls.enable", "true");

	    // Session 객체를 생성
	    Session session = Session.getInstance(props, null);

	    try {
	        Store store = session.getStore("imaps");
	        
	        store.connect(host, userName, password);

 	            
	        // 받은편지함을 INBOX 라고 한다.
	        	Folder inbox = store.getFolder("INBOX");
            	inbox.open(Folder.READ_ONLY);
 	            // 받은 편지함에 있는 메일 모두 읽어오기
 	            Message[] arrayMessages = inbox.getMessages();
 	            // 안읽은 메시지
 	            Message newMessages[] = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
 	            

 	            for (int i = arrayMessages.length; i > 970; i--) {
 	                Message msg = arrayMessages[i-1];
 	                Address[] fromAddress = msg.getFrom();
 	                // 메일 내용 변수에 담기

 	                log.info("message:{}",msg.toString());
 	                ReceiveMailVO mail = new ReceiveMailVO();
 	                
 	                  
 	                 int index = fromAddress[0].toString().indexOf("<");
 	                 
 	                String str = fromAddress[0].toString().substring(index+1);
 	                
 	                String from = str.substring(0, str.length()-1);
 	                
 	                int idIndex = from.indexOf("@");
 	                String sendId = from.substring(0,idIndex);
 	                String subject = msg.getSubject();
 	                String sentDate = msg.getSentDate().toString();
 	                String receivedDate = msg.getReceivedDate().toString();
 	                String contentType = msg.getContentType();
 	                String messageContent = msg.getContent().toString();
 	                String attachFiles = "";
 	                
 	                
 	                mail.setMailNo(i);
 	                mail.setSendId(sendId);
 	                mail.setFrom(from);
 	                mail.setSubject(subject);
 	                mail.setSentDate(sentDate);
 	                mail.setReceivedDate(receivedDate);
 	                mail.setContentType(contentType);
 	                mail.setMessageContent(messageContent);
 	                
 	                
 	                

 					// 첨부파일
 	                if (contentType.contains("multipart")) {
 	                    Multipart multiPart = (Multipart) msg.getContent();
 	                    int numberOfParts = multiPart.getCount();
 	                    for (int partCount = 0; partCount < numberOfParts; partCount++) {
 	                        MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
 	                        if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
 	                            // 첨부파일 있을 경우 지정 폴더로 저장
 	                            String fileName = part.getFileName();
 	                            attachFiles += fileName + ", ";
// 	                            part.saveFile(saveDirectory + File.separator + fileName);
 	                        } else {
 	                            // 메일 내용 저장
 	                            messageContent = part.getContent().toString();
 	                            mail.setMessageContent(messageContent);
 	                        }
 	                    }
 	                    if (attachFiles.length() > 1) {
 	                        attachFiles = attachFiles.substring(0,
 	                        		attachFiles.length() - 2);
 	                        mail.setAttachFiles(attachFiles);
 	                    }
 	                } else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
 	                    Object content = msg.getContent();
 	                    if (content != null) {
 	                        messageContent = content.toString();
 	                    }
 	                }

 	                mailMap.put("mail"+i, mail);
 	                
 	                mailList.add(mail);
 	                
 	                application.setAttribute("mailMap", mailMap);
 	            }
 	            
 	            	
 	            // disconnect
 	            inbox.close(false);
 	            store.close();

 	            
 	            
 	        } catch (MessagingException e) {
 	            e.printStackTrace();
 	            System.exit(2);
 	        }
 	       
 	        return mailList;
 }
	 //메일 하나 삭제로직
    public boolean deleteMail(Integer mailNo, String userName, String password) throws MessagingException, IOException {
    	
    	
    	boolean result = true;
    	Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.naver.com", userName, password);
           
            
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);
            
            
            Message[] oneMessages = inbox.getMessages(mailNo,mailNo);
         
		         
		         oneMessages[0].setFlag(Flags.Flag.DELETED, true);
		       
         
            inbox.close((true));
            store.close();

            
            
        } catch (MessagingException e) {
        	result= false;
            e.printStackTrace();
            System.exit(2);
        }
       
        return result;
    }
    
  //메일 삭제로직
    public boolean deleteCheckMail(Integer [] deleteNos, String userName, String password) throws MessagingException, IOException {
    	
    	Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.naver.com", userName, password);
           
            
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);
           log.info("deleteNos[0] : {}",deleteNos[0]);
           log.info("deleteNos[deleteNos.length-1] : {}",deleteNos[deleteNos.length-1]);
           
           
        	   for (int i =0; i<deleteNos.length; i++) {
        		   if(deleteNos[i] + i > 1000) {
        			   Message[] oneMessages = inbox.getMessages(1000,1000);
        			   oneMessages[0].setFlag(Flags.Flag.DELETED, true);
        			   
        		   }else {
        			   Message[] oneMessages = inbox.getMessages(deleteNos[i]+i,deleteNos[i]+i);
        			   oneMessages[0].setFlag(Flags.Flag.DELETED, true);
        		   }
        		   
        		   
			}
     
            inbox.close((false));
            store.close();

            
            
        } catch (MessagingException e) {
            e.printStackTrace();
            System.exit(2);

        }
       
        return true;
    }

    public int retrieveMailCount(PaginationInfo<ReceiveMailVO> pagingVO, String userName, String password) {
		Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imaps.ssl.enable", "true");
        props.setProperty("mail.imaps.ssl.protocols", "TLSv1.2");
        int totalCount = 0;
        try {

        	Session session = Session.getInstance(props, null);
            Store store = session.getStore("imaps");
            store.connect("imap.naver.com", 993, userName, password);
            
            // 받은편지함을 INBOX 라고 한다.
            Folder inbox = store.getFolder("INBOX");
            UIDFolder uf = (UIDFolder) inbox;
           
            inbox.open(Folder.READ_ONLY);
           
            // 받은 편지함에 있는 메일 모두 읽어오기
            totalCount = inbox.getMessageCount();
            return totalCount;
        
        } catch (MessagingException e) {
            e.printStackTrace();
            System.exit(2);
        }
		return totalCount;
      
       
	}
    
    public MailUserVO mailAutoLogin(String id) {
    	return mailDAO.mailAutoLogin(id);
    }
    
}

