package kr.or.ddit.email.vo;

import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kr.or.ddit.common.validate.DeleteGroup;
import kr.or.ddit.common.validate.InsertGroup;
import lombok.Data;

@Data
public class ImportMailVO {
	@NotNull(groups=DeleteGroup.class)
	private Integer maiNo;
	@NotBlank(groups=InsertGroup.class)
	private String maiAddress;
    private String maiTitle;
    private String maiContent;
    private String empId;
    private String maiDate;
    
    private ReceiveMailVO adaptee;
	
    public ImportMailVO() {};
    
	public ImportMailVO(ReceiveMailVO adaptee) {
		super();
		this.adaptee = adaptee;
		this.maiAddress = adaptee.getFrom();
		this.maiTitle =  adaptee.getSubject();
		this.maiContent = adaptee.getMessageContent();
		this.maiDate = adaptee.getSentDate();
	}

}