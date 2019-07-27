/**
 * @author Joshua
 * @version V1.0
 * @date 2019年7月20日下午5:47:19
 */
package test.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * @author Joshua
 * @date 2019年7月20日下午5:47:19
 */
public class MailUtility {
	// mailbox setting
	private static String mailServerHost = "smtp.qq.com";
	private static String mailSenderAddress = "wangjiahui.boss@qq.com";
	private static String mailSenderNick = "JIA";
	private static String mailSenderUserName = "wangjiahui.boss@qq.com";
	private static String mailSenderPassword = "umjhlxhnolqdcaad"; // Authenticated code when opening POP3/SMTP
	
	//public static void sendEmail(MailInfo mailInfo) throws Throwable {
		try {
			HtmlEmail email = new HtmlEmail();
			// configuration
			email.setHostName(mailServerHost);
			email.setFrom(mailSenderAddress, mailSenderNick);
			email.setAuthentication(mailSenderUserName, mailSenderPassword);
			email.setCharset("UTF-8");
			email.setSubject(mailInfo.getSubject());
			email.setHtmlMsg(mailInfo.getContent());
			
			// set attachments
			List<EmailAttachment> attachments = mailInfo.getAttachments();
			if(null != attachments && attachments.size() >0) {
				for(int i=0; i<attachments.size(); i++) {
					email.attach(attachments.get(i));
				}
			}
			// add toAddress
            List<String> toAddress = mailInfo.getToAddress();
            if (null != toAddress && toAddress.size() > 0) {
                for (int i = 0; i < toAddress.size(); i++) {
                        email.addTo(toAddress.get(i));
                }
            }
            // add ccAddress
            List<String> ccAddress = mailInfo.getCcAddress();
            if (null != ccAddress && ccAddress.size() > 0) {
                for (int i = 0; i < ccAddress.size(); i++) {
                        email.addCc(ccAddress.get(i));
                }
            }
            // add bccAddress
            List<String> bccAddress = mailInfo.getBccAddress();
            if (null != bccAddress && bccAddress.size() > 0) {
                for (int i = 0; i < bccAddress.size(); i++) {
                    email.addBcc(ccAddress.get(i));
                }
            }			
            // send email
            email.send();            
		}catch(EmailException e) {
			throw new Exception(e);
			//e.printStackTrace();
		}
	}
	
	/***
	 * Testing purpose only
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MailInfo mailInfo = new MailInfo();
			
			List<String> toList = new ArrayList<String>();
			toList.add("wangjiahui.boss@qq.com");
			List<String> ccList = new ArrayList<String>();
			ccList.add("wjh0034@hotmail.com");
			List<String> bccList = new ArrayList<String>();
			bccList.add("18710996825.139.com");
			
			// Add attachments
			/*EmailAttachment att = new EmailAttachment();
			att.setPath("C:\\Users\\Joshua\\eclipse-workspace\\JWebAuto\\JWebAuto.log");
			att.setName("JWebAuto.log");
			att.setDescription("It's the log file of JWebAuto project.");
			List<EmailAttachment> atts = new ArrayList<EmailAttachment>();
			atts.add(att);
			mailInfo.setAttachments(atts);*/
			// calling method to add attachment is a much more simple way
			mailInfo.addAttachment("C:\\Users\\Joshua\\eclipse-workspace\\JWebAuto\\JWebAuto.log", "JWebAuto.log");
			mailInfo.addAttachment("C:\\Users\\Joshua\\eclipse-workspace\\JWebAuto\\JWebAuto - 副本.log", "JWebAuto - 副本.log");
			
			mailInfo.setToAddress(toList);
			mailInfo.setCcAddress(ccList);
			mailInfo.setBccAddress(bccList);
			
			mailInfo.setSubject("Testing sending email feature with common-mail");
			mailInfo.setContent("Content: <h1> test, test, test <h1>");
			
			MailUtility.sendEmail(mailInfo);		
			System.out.println("Already sent email successfully!");
		} catch (Exception e) {
			System.out.println(e.toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
