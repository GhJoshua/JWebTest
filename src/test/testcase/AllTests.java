/**
 * @author Jiahui.Wang
 * @version V1.0  2019��7��23������2:26:26
 */
package test.testcase;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(Test_SearchBox.class);
		//$JUnit-END$
		return suite;
	}

}
