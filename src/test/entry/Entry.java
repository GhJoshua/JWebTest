/**
 * @author Jiahui.Wang
 */
package test.entry;

import test.common.*;
import test.webpages.*;

/** 
 * This class is the Entry for testing
 */
public class Entry {
	/**
	 * @param args
	 */
	public static void main(String[] args)  {
		try {
		GoogleMainPage google = new GoogleMainPage();
		LogUtility.log("open Chrome");
		google.open("https://www.baidu.com");
		LogUtility.log("open baidu");
		google.quit();
		LogUtility.log("quit the browser");
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		System.out.println("Succeed! No Error!");
	}
}
