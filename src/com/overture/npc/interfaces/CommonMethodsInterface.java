package com.overture.npc.interfaces;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface CommonMethodsInterface {

	public String basepath();

	public String ReporterText(String message);
	
	public String ReporterTextBold(String message);

	public String ReporterLink(String sScreenshotName);

	public WebDriver getDriver(String browser, String path);

	public void datePicker(WebDriver driver, WebElement element, String testData);
	
	public void mouseOver(WebDriver driver, WebElement element, String elementName);
	
	public void moveToElement(WebDriver driver, WebElement element, String elementName);

	public List<String> GetChildElementTextByxpath(WebElement element);

	public void captureElementScreenShot(WebDriver driver, WebElement element,
			String TestCaseName, String basepath);

	public void captureDriverScreenShot(WebDriver driver, String TestCaseName,
			String basepath);

	public boolean waiters(WebElement element);

	public ArrayList<String> getClassName(String PackageName);

	@SuppressWarnings("rawtypes")
	Class[] getClasses(String packageName)

	throws ClassNotFoundException, IOException;

	@SuppressWarnings("rawtypes")
	List<Class> findClasses(File directory, String packageName)
			throws ClassNotFoundException;

	public void copyDirectory(File sourceLocation, File targetLocation)
			throws IOException;

	public void terminateProcess(String bwrName);
	
	public ArrayList<String> linkFinder(WebDriver driver, WebElement table);
	
	public ArrayList<String> linkFinderByClass(WebDriver driver, WebElement table);
	
	public ArrayList<String> paragraphFinder(WebDriver driver, WebElement table);
		
	public ArrayList<String> createArrayList(String text);
	
	public ArrayList<String> dropdownValueFinder(WebDriver driver, WebElement select);

	public ArrayList<String> linkFinderByTableColumn(WebDriver driver, WebElement table);
	 
	public String randomNumberGenerator();
	
	public ArrayList<String> boldTextFinder(WebDriver driver, WebElement table);
}
