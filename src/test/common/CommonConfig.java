/**
 * 
 */
package test.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 */
public class CommonConfig {	  
	
	public static String driverPath() {  
	    return "..\\ExternalLib\\chromedriver.exe" ;
	}
	/**
	 * 
	 * @return
	 */
	public static String baseUrl() {  
	    return "https://www.baidu.com";
	}
	/**
	 * change time to str
	 */ 
	public static String getCurrentTime() {  
	    Date dtNow = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	    return ft.format(dtNow);
	}
	/** 
	 * Get time diff  
	*/
	/*
	 * public String timeDiff(Date starttime, Date endtime) { SimpleDateFormat ft =
	 * new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); return
	 * datetime.strptime(endtime,format) - datetime.strptime(starttime,format); }
	 */
}
