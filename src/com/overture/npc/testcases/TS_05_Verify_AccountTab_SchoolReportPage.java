package com.overture.npc.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.SchoolReportPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_05_Verify_AccountTab_SchoolReportPage {

	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	
	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	SchoolReportPage schoolReportPage=null;
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority = 1)
	public void TC_01_Validate_FromDate_Field() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String expectedYear=dateFormat.format(date);
		co.pause(2500);
		co.click(schoolReportPage.fromDateField, "Clicking on From field to get the date picker.");
		String actual=schoolReportPage.datePickerYear.getText();
		cm.captureElementScreenShot(driver, schoolReportPage.datePickerYear, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expectedYear, "The datepicker is not displayed or is not correct");
	}
	
	//============================================================================================
	
	
	@Test(priority = 2)
	public void TC_02_Validate_ToDate_Field() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String expectedYear=dateFormat.format(date);
		co.pause(2500);
		co.click(schoolReportPage.toDateField, "Clicking on To field to get the date picker.");
		String actual=schoolReportPage.datePickerYear.getText();
		cm.captureElementScreenShot(driver, schoolReportPage.datePickerYear, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, expectedYear, "The datepicker is not displayed or is not correct");
	}
	
	//============================================================================================
	
	@Test(priority = 3)
	public void TC_03_Run_Report_Button_ValidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		
		co.click(schoolReportPage.fromDateField, "Clicking on From Date field");
		co.click(schoolReportPage.calendarDate2, "Selecting 2 from calendar");
		co.click(schoolReportPage.toDateField, "Clicking on To Date field");
		co.click(schoolReportPage.calendarDate5, "Selecting 5 from calendar");
		
		co.click(schoolReportPage.runReportButton,"Clicking Report Report Button");
		cm.captureElementScreenShot(driver, schoolReportPage.messageArea, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		}
	
	//============================================================================================

	@Test(priority = 4)
	public void TC_04_Run_Report_Button_InvalidData() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		co.click(schoolReportPage.runReportButton, "Clicking on Run Report");
		String expected="Error: Please pick two date values.";
		System.out.println("Asserting the test case");
		cm.captureElementScreenShot(driver, schoolReportPage.messageArea, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		Assert.assertEquals(schoolReportPage.messageArea.getText(), expected, "The error message does not match");
	}
	
	//============================================================================================
	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage=new GlobalElements().globalElementsInit(driver);
		schoolReportPage=new SchoolReportPage().schoolReportPageElementsInit(driver);
		
		cm.mouseOver(driver, homePage.accountTab, "AccountTab");
		co.click(homePage.calculationReportLink, "Clicking on the Calculation Report Page under Accounts Tab.");
	}

	@AfterMethod
	public void AfterMethod() {
	}

	@BeforeClass
	public void BeforeClass() {
		co.login(driver);
	}

	@AfterClass
	public void AfterClass() {
		co.signOut(driver);
	}
	
	@BeforeTest
	public void Browser_Opening(){
		System.out.println("Executing Class : "+className);
		co.logHeader(className);
		driver = co.browserOpen();
	}
	
	@AfterTest
	public void Browser_Closing() {
		co.browserClose(driver);
		co.logFooter();
	}

}
