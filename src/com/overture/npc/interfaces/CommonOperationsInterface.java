package com.overture.npc.interfaces;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.overture.npc.controller.HomeServlet;

public interface CommonOperationsInterface {
	
	public void click(WebElement element, String message);
	
	public void clear(WebElement element, String message);
	
	public void type(WebElement element,String testData, String message);
	
	public void selectDropDown(WebElement element,String testData, String message);
	
	public String getFirstSelectedDropDown(WebElement element);
	
	public String getText(WebElement element, String message);
	
	public WebDriver browserOpen();

	public void browserClose(WebDriver driver);
	
	public void logHeader(String text);
	
	public void logFooter();
	
	public void controlBackToDriver(WebDriver driver);
	public Alert alertHandler(WebDriver driver);
	
	public String controlOfSubDriver(WebDriver driver);
	
	public String controlOfMainDriver(WebDriver driver);
	
	public void driverSwitch(WebDriver driver, String controller, String msg);
	
	public boolean findCheckboxEnabled(WebDriver driver, List<WebElement> element);
	
	public void login(WebDriver driver, HomeServlet homeServlet);
	
	public void signOut(WebDriver driver);
	
	public String switchingAidYear(WebDriver driver);
	
	public void deletePreviewTestCase(WebDriver driver, WebElement element, boolean flag);
	
	
	}
