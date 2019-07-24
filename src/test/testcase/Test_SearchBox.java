/**
 * @author Jiahui.Wang
 * @version V1.0 2019年7月22日下午2:58:20
 */
package test.testcase;

import test.common.*;
import test.webpages.*;
import junit.framework.TestCase;
import java.util.Date;

/**
 * 
 */
public class Test_SearchBox extends TestCase {
	TestCaseInfo testCaseInfo = null;
	String baseUrl = CommonConfig.baseUrl();
	GoogleMainPage googleSearch = null;	
		
	/**
	 * @return the testCaseInfo
	 */
	public TestCaseInfo getTestCaseInfo() {
		return testCaseInfo;
	}
	
	/**
	 * @param testCaseInfo the testCaseInfo to set
	 */
	public void setTestCaseInfo(TestCaseInfo testCaseInfo) {
		this.testCaseInfo = testCaseInfo;
	}
	
	protected void setUp() throws Exception {
		//super.setUp();
		testCaseInfo = new TestCaseInfo(1, "testSearch", "Joshua", false,new Date() , new Date(), 0.02, null);
		//LogUtility.createLogFile(""); TODO
		LogUtility.log("Testcase named testSearch starts.");
	}
	
	public void testSearch() {
		try {
			testCaseInfo.startTime = new Date();//CommonConfig.getCurrentTime();
			
			// Step1: open base site
			LogUtility.log("testSearch: Open base site: " + baseUrl);
			googleSearch = new GoogleMainPage();
			
			googleSearch.open(baseUrl);
			
			googleSearch.inputSearchContent("Java");
			Thread.sleep(2000);
			
			assertTrue(googleSearch.getTitle().contains("Java"));
			testCaseInfo.result = true;
			
			LogUtility.log("testSearch: Open the site successfully.");
		}catch(Exception e) {
			testCaseInfo.result =false;
			LogUtility.log("testSearch Failed. Test case error: " + e.toString());
		}
	}
	
	protected void tearDown() throws Exception {
		//super.tearDown();
		googleSearch.quit();
	}
}
