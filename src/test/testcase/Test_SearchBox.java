/**
 * @author Joshua
 * @version V1.0
 * @date 2019年7月22日下午2:58:20
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
		
	protected void setUp() throws Exception {
		//super.setUp();
		testCaseInfo = new TestCaseInfo(1, "testSearch", "Joshua", false,new Date() , new Date(), 0.02, null);
		//LogUtility.createLogFile(""); TODO
		LogUtility.log("test search starts.");
	}
	
	public void testSearch() {
		try {
			testCaseInfo.startTime = new Date();//CommonConfig.getCurrentTime();
			
			// Step1: open base site
			LogUtility.log("Open base site: " + baseUrl);
			googleSearch = new GoogleMainPage();
			
			googleSearch.open(baseUrl);
			
			googleSearch.inputSearchContent("Java");
			Thread.sleep(2000);
			
			assertTrue(googleSearch.getTitle().contains("Java"));
			testCaseInfo.result = true;
			
			LogUtility.log("Open the site successfully.");
		}catch(Exception e) {
			testCaseInfo.result =false;
			LogUtility.log("Failed. Test case error: " + e.toString());
		}
	}
	
	protected void tearDown() throws Exception {
		//super.tearDown();
		googleSearch.quit();
	}
}
