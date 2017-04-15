package com.overture.npc.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.overture.npc.elementlocators.Add_N_Edit_TestCasePage;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.elementlocators.SchoolPreviewPage;
import com.overture.npc.elementlocators.TestCaseDetailsPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_69_Verify_DetailsPage_In_TestCasePage{
	
	String className = this.getClass().getName().substring(27);
	WebDriver driver = null;
	WebElement element=null;
	String originalDriver =null, subDriver=null, testData=null;
	boolean flag=false, actual=false,expected=true;
	
	LoginPage loginPage = null;
	HomePage homePage = null;
	SchoolPreviewPage schoolPreviewPage=null;
	Add_N_Edit_TestCasePage add_N_Edit_testCasePage=null;
	TestCaseDetailsPage tcDetailsPage=null;
	
	
	CommonMethods cm = new CommonMethods();
	CommonOperations co = new CommonOperations();

	@Test(priority = 1)
	public void TC_01_Validate_TestResultsTab_DetailsPage() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(ScreenshotName);
		co.click(tcDetailsPage.testResultsLink, "Clicking On Test Results Tab.");
		actual=tcDetailsPage.testResultsLink.isEnabled();
		cm.captureElementScreenShot(driver, tcDetailsPage.testResultsLink, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		Assert.assertEquals(actual, expected,"The Tab is Not Enabled.");
	}

	// ==================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_INASOutputTab_DetailsPage() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(ScreenshotName);
		co.click(tcDetailsPage.inasOutputLink, "Clicking On INAS Output Tab.");
		actual=tcDetailsPage.inasOutputLink.isEnabled();
		cm.captureElementScreenShot(driver, tcDetailsPage.inasOutputLink, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		Assert.assertEquals(actual, expected,"The Tab is Not Enabled.");
	}

	// ==================================================================================
	

	
	@Test(priority = 3)
	public void TC_03_Validate_PackagingBreakdownTab_DetailsPage() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(ScreenshotName);
		co.click(tcDetailsPage.packagingBreakdownLink, "Clicking On Packaging Breakdown Tab.");
		actual=tcDetailsPage.packagingBreakdownLink.isEnabled();
		cm.captureElementScreenShot(driver, tcDetailsPage.packagingBreakdownLink, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		Assert.assertEquals(actual, expected,"The Tab is Not Enabled.");
	}

	// ==================================================================================
	
	@Test(priority = 4)
	public void TC_04_Validate_TestLogTab_DetailsPage() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(ScreenshotName);
		co.click(tcDetailsPage.testLogsLink, "Clicking On TEST LOGS Tab.");
		actual=tcDetailsPage.testLogsLink.isEnabled();
		cm.captureElementScreenShot(driver, tcDetailsPage.testLogsLink, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		Assert.assertEquals(actual, expected,"The Tab is Not Enabled.");
	}

	// ==================================================================================
	
	@Test(priority = 5)
	public void TC_05_Validate_INASRequestTab_DetailsPage() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(ScreenshotName);
		co.click(tcDetailsPage.inasRequestLink, "Clicking On INAS Request Tab.");
		actual=tcDetailsPage.inasRequestLink.isEnabled();
		cm.captureElementScreenShot(driver, tcDetailsPage.inasRequestLink, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		Assert.assertEquals(actual, expected,"The Tab is Not Enabled.");
	}

	// ==================================================================================

	@Test(priority = 6)
	public void TC_06_Validate_INASResponseTab_DetailsPage() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(ScreenshotName);
		co.click(tcDetailsPage.inasResponseLink, "Clicking On INAS Response Tab.");
		actual=tcDetailsPage.inasResponseLink.isEnabled();
		cm.captureElementScreenShot(driver, tcDetailsPage.inasResponseLink, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		Assert.assertEquals(actual, expected,"The Tab is Not Enabled.");
	}

	// ==================================================================================

	
	@BeforeMethod
	public void BeforeMethod() {
	homePage = new HomePage().homePageInit(driver);
	schoolPreviewPage=new SchoolPreviewPage().schoolPreviewPageElementsInit(driver);
	tcDetailsPage=new TestCaseDetailsPage().testCaseDetailsPageInit(driver);
		
	cm.mouseOver(driver, homePage.accountTab, "AccountTab");
	co.click(homePage.previewLink, "Clicking on the Preview link.");
	element=driver.findElement(By.xpath("//table[@id='preview-list']//tr[contains(.,'"+testData+"')]//a[contains(.,'Details')]"));
	co.click(element, "Clicking Details Link for Test Case : "+testData);
	}

	@AfterMethod
	public void AfterMethod() {
		
	}

	@BeforeClass
	public void LogingIn() {
		co.login(driver);
		originalDriver = co.controlOfMainDriver(driver);
		testData="TestName"+cm.randomNumberGenerator();
		flag=co.addTestCase(driver, testData);
		element=driver.findElement(By.xpath("//table[@id='preview-list']//tr[contains(.,'"+testData+"')]//a[contains(.,'GO')]"));
		co.click(element, "Clicking GO Link for Test Case : "+testData);
		co.fillingStudentInformationPage(driver);
		co.driverSwitch(driver, originalDriver, "Switching the driver back to main Control.");
	}

	@AfterClass
	public void AfterClass() {
	if(flag){
		flag=co.deleteTestCase(driver, testData);
		}
	co.signOut(driver);
	}

	@BeforeTest
	public void Browser_Opening() {
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
