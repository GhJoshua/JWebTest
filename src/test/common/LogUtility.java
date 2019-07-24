/**
 * @author Jiahui.Wang
 * @version V1.0 2019��7��19������3:48:49
 */
package test.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 */
public class LogUtility {
	
	public static Log logger = LogFactory.getLog(LogUtility.class);	
	
	/***
	 * TODO: Not implemented yet
	 * @param filename
	 */
	public void createLogFile(String filename) {
		/** TODO
		try {
	        fulllogname = ResultFolder.GetRunDirectory()+"\\"+filename+".log"
	        fh = logging.FileHandler(fulllogname)
	        fh.setLevel(logging.DEBUG)
	        formatter = logging.Formatter('%(asctime)s [line:%(lineno)d] %(message)s')
	        fh.setFormatter(formatter)
	        logger.addHandler(fh)
		} catch (Exception e) {
			throw ("Error when creating log file, error message: {}".format(str(err)))
		}
		**/
	}
	
	/***
	 * To log a message, didn't set location TODO: set log's location
	 * @param message, string to be logged message
	 */
	public static void log(String message) {
		logger.debug(message);
	}
	
	// Test
	/***
	 * Main method only used for testing purpose to run this class as an application
	 * @param args
	 */	
	  public static void main(String[] args) { 
		  //logger
		  logger.trace("����logger1��trace"); 
		  logger.debug("����logger1��debug");
		  logger.info("����logger1��info"); 
		  logger.warn("����logger1��warn");
		  logger.error("����logger1��error"); 
		  logger.fatal("����logger1��fatal"); 
	  }	
}
