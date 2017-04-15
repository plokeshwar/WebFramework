package com.overture.npc.methods;

import java.util.List;

public class POJO {
	
	
	public String getBasepath() {
		return basepath;
	}
	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}
	public String getBrowserIndicator() {
		return browserIndicator;
	}
	public void setBrowserIndicator(String browserIndicator) {
		this.browserIndicator = browserIndicator;
	}
	public boolean isRunAllCaseIndicator() {
		return runAllCaseIndicator;
	}
	public void setRunAllCaseIndicator(boolean runAllCaseIndicator) {
		this.runAllCaseIndicator = runAllCaseIndicator;
	}
	public boolean isEmailIndicator() {
		return emailIndicator;
	}
	public void setEmailIndicator(boolean emailIndicator) {
		this.emailIndicator = emailIndicator;
	}
	
	String basepath,browserIndicator;
	boolean runAllCaseIndicator,emailIndicator;
	
	List<String> testCaseName;
	public List<String> getTestCaseName() {
		return testCaseName;
	}
	public void setTestCaseName(List<String> testCaseName) {
		this.testCaseName = testCaseName;
	}
	

}
