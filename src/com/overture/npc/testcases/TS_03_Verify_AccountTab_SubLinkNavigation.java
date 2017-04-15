package com.overture.npc.testcases;

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

import com.overture.npc.controller.HomeServlet;
import com.overture.npc.elementlocators.AccountSettingsPage;
import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

@Test(priority=3)
public class TS_03_Verify_AccountTab_SubLinkNavigation {
	
	String className = this.getClass().getName().substring(27);
	String actual, expected;
	WebDriver driver = null;

	LoginPage loginPage = null;
	HomePage homePage = null;
	GlobalElements globalPage = null;
	AccountSettingsPage accountSettingPage=null;

	HomeServlet homeServlet = new HomeServlet();
	CommonMethods cm = new CommonMethods();
	CommonOperations co = new CommonOperations();

	
	@Test(priority = 1)
	public void TC_01_Validate_Account_Settings_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));
		co.click(homePage.accountSettingsLink,"Clicking on Account Setting Link in Account Tab.");
		co.pause(2500);
		actual=co.getText(homePage.pageTitle, "Extracting Page Title");
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName,cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, "Account Settings","The page did not navigate to Account Settings.");
	}

	// ==================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Calculation_Report_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));
		co.click(homePage.calculationReportLink,"Clicking on Calculation Report Link in Account Tab.");
		co.pause(2500);
		actual=co.getText(homePage.pageTitle, "Extracting Page Title");
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName,cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, "School Report","The page did not navigate to School Report Page.");
	}

	// ==================================================================================

	
	@Test(priority = 3)
	public void TC_03_Validate_Traffic_Summary_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));
		co.click(homePage.trafficSummaryLink,"Clicking on Traffic Summary Link in Account Tab.");
		co.pause(2500);
		actual=co.getText(homePage.pageTitle, "Extracting Page Title");
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName,cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, "Traffic Report","The page did not navigate to Traffic Report Page.");
	}

	// ==================================================================================

	
	@Test(priority = 4)
	public void TC_04_Validate_Preview_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));
		co.click(homePage.previewLink,"Clicking on Preview Link in Account Tab.");
		co.pause(2500);
		actual=co.getText(homePage.pageTitle, "Extracting Page Title");
		cm.captureElementScreenShot(driver, homePage.pageTitle, ScreenshotName,cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual, "School Preview","The page did not navigate to School Preview Page.");
	}

	@BeforeMethod
	public void BeforeMethod() {
		homePage = new HomePage().homePageInit(driver);
		globalPage = new GlobalElements().globalElementsInit(driver);
		co.pause(3000);
		cm.mouseOver(driver, homePage.accountTab, "AccountTab");
	}

	@AfterMethod
	public void AfterMethod() {
	}

	@BeforeClass
	public void Initializing_All_Required_Pages_And_Logging_In() {
		co.login(driver, homeServlet);
		
	}

	@AfterClass
	public void AfterClass() {
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
