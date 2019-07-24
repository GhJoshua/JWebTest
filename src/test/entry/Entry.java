/**
 * @author Jiahui.Wang
 */
package test.entry;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;

import test.common.*;
import test.testcase.Test_SearchBox;

/** 
 * This class is the Entry for testing
 */
public class Entry {
	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		try {
			/*
			 * GoogleMainPage google = new GoogleMainPage(); LogUtility.log("open Chrome");
			 * google.open("https://www.baidu.com"); LogUtility.log("open baidu");
			 * google.quit(); LogUtility.log("quit the browser");
			 */
			// Run test cases and get TestCaseInfo instance
			Test_SearchBox tSearchBox= new Test_SearchBox();
			tSearchBox.run();tSearchBox.testSearch(); // TODO: how to run a testcase by code??
			TestCaseInfo testCaseInfo = tSearchBox.getTestCaseInfo();
			
			// Generate a report file by testCaseInfo
			TestReport testReport = new TestReport();
			Document testReportDoc = testReport.writeHtmlFile(testCaseInfo);
			
			// Set email info
			MailInfo mailInfo = new MailInfo();
			
			List<String> toList = new ArrayList<String>();
			toList.add("wangjiahui.boss@qq.com");
			List<String> ccList = new ArrayList<String>();
			ccList.add("wjh0034@hotmail.com");
			List<String> bccList = new ArrayList<String>();
			bccList.add("18710996825.139.com");
			
			mailInfo.setToAddress(toList);
			mailInfo.setCcAddress(ccList);
			mailInfo.setBccAddress(bccList);			
			mailInfo.setSubject("Automation Test Report email");
			
			String contentStr = testReportDoc.asXML();		
			mailInfo.setContent(contentStr);
			//mailInfo.setContent("Content: <h1> test, test, test <h1>");
			
			MailUtility.sendEmail(mailInfo);		
			LogUtility.log("Send mail succeed!");
		} catch (Throwable e)
		{
			LogUtility.log(e.toString());
		}
	}
}
