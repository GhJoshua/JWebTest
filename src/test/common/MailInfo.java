/**
 * @author Joshua
 * @version V1.0
 * @date 2019年7月20日下午5:18:50
 */
package test.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;

/**
 * @author Joshua
 * @date 2019年7月20日下午5:18:50
 */
public class MailInfo {
	// to address
	private List<String> toAddress = null;
	// cc address
	private List<String> ccAddress = null;
	// bcc address
	private List<String> bccAddress =null;
	// attachment
	private List<EmailAttachment> attachments = null;
	// mail's subject
	private String subject;
	// mail's content
	private String content;
	
	public List<String> getToAddress(){
		return toAddress; //this.toAddress
	}
	public void setToAddress(List<String> toAddress) {
		this.toAddress = toAddress;
	}
	public void addToAddress(String toAddress) {
		this.toAddress.add(toAddress);
	}
	public void addToAddress(List<String> toAddress) {
		this.toAddress.addAll(toAddress);
	}
	
	public List<String> getCcAddress() {
		return this.ccAddress;
	}
	public void setCcAddress(List<String> ccAddress) {
		this.ccAddress = ccAddress;
	}
	public void addCcAddress(List<String> ccAddress) {
		if(null != ccAddress && ccAddress.size() >0) {
			this.ccAddress.addAll(ccAddress);
		}
	}
	
	public List<String> getBccAddress(){
		return bccAddress;
	}
	public void setBccAddress(List<String> bccAddress) {
		this.bccAddress = bccAddress;
	}
	
	public List<EmailAttachment> getAttachments() {
		return attachments;
	}
	private void setAttachments(List<EmailAttachment> attachments) {
		this.attachments = attachments;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	// method
	/***
	 * add one attachment to MailInfo instance with full path and attachment's name
	 * @param attachmentPath
	 * @param attachmentName
	 */
	public void addAttachment(String attachmentPath, String attachmentName) {
		EmailAttachment att = new EmailAttachment();
		att.setPath(attachmentPath);
		att.setName(attachmentName);
		if(null == this.attachments) {
			List<EmailAttachment> atts = new ArrayList<EmailAttachment>();
			atts.add(att);
			this.setAttachments(atts);
		} else {
			this.getAttachments().add(att);
		}		
	}
}
