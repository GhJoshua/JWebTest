/**
 * @author Joshua
 * @version V1.0
 * @date 2019年7月18日下午9:13:45
 */
package test.common;

import java.util.Date;

/** This class is the TestCase info
 * 
 */
public class TestCaseInfo {

	public int id;
	public String name;
	public String owner;
	public boolean result;
	public Date startTime;
	public Date endTime;
	public double secondDuration;
	public String errorInfo;
	/**
	 * 
	 */
	public TestCaseInfo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param owner
	 * @param result
	 * @param startTime
	 * @param endTime
	 * @param secondDuration
	 * @param errorInfo
	 */
	public TestCaseInfo(int id, String name, String owner, boolean result, Date startTime, Date endTime, double secondDuration, String errorInfo) {
		this.id = id;
		this.setName(name);
		this.setOwner(owner);
		this.setResult(result);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
		this.setSecondDuration(secondDuration);
		this.setErrorInfo(errorInfo);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the secondDuration
	 */
	public double getSecondDuration() {
		return secondDuration;
	}

	/**
	 * @param secondDuration the secondDuration to set
	 */
	public void setSecondDuration(double secondDuration) {
		this.secondDuration = secondDuration;
	}

	/**
	 * @return the errorInfo
	 */
	public String getErrorInfo() {
		return errorInfo;
	}

	/**
	 * @param errorInfo the errorInfo to set
	 */
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

}
