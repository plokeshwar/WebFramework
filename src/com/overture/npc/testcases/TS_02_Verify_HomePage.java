package com.overture.npc.testcases;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.overture.npc.controller.HomeServlet;
import com.overture.npc.elementlocators.ChangePasswordPage;
import com.overture.npc.elementlocators.GlobalElements;
import com.overture.npc.elementlocators.HomePage;
import com.overture.npc.elementlocators.LoginPage;
import com.overture.npc.methods.CommonMethods;
import com.overture.npc.methods.CommonOperations;

public class TS_02_Verify_HomePage {

	String actual, expected, msg;
	String className=this.getClass().getName().substring(27);
	WebDriver driver = null;
	
	String browserName=null;

	LoginPage loginPage = null;
	GlobalElements globalPage = null;
	HomePage homePage = null;
	ChangePasswordPage passwordPage=null;
	
	HomeServlet homeServlet = new HomeServlet();
	CommonMethods cm = new CommonMethods();
	CommonOperations co=new CommonOperations();
	
	
	@Test(priority=1)
	public void TC_01_Validate_Change_Password_Link(){
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		Reporter.log(cm.ReporterText("TestCase : "+ScreenshotName));
		
		co.click(homePage.ChangePasswordLink, "Clicking on Change password Link");
		co.pause(2500);
		passwordPage=new ChangePasswordPage().passwordPageInit(driver);
		actual=co.getText(passwordPage.pageTitle,"Extracting text from page title.");
		expected="Change Password";
		msg="Change Password Page Not Loaded";
		
		cm.captureElementScreenShot(driver,passwordPage.pageTitle, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		
		Assert.assertEquals(actual,expected, msg);
		
	}
	
	//=============================================================================================================
	
	@Test(priority = 2)
	public void TC_02_Validate_Account_Tab() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		String expectedList = "Account Settings, Calculation Report, Traffic Summary, Preview";

		cm.mouseOver(driver, homePage.accountTab, "AccountTab");

		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.linkFinder(driver, homePage.accountTable);
		cm.captureElementScreenShot(driver, homePage.accountTab, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	
	//=============================================================================================================
	
	@Test(priority = 3)
	public void TC_03_Validate_NetPrice_Tab() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		cm.ReporterText("TestCase : " + ScreenshotName);

		String expectedList = "Questions, Populations, Tables, COA, Packaging, School Computed Values";

		cm.mouseOver(driver, homePage.netPriceTab, "NetPriceTab");

		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.linkFinder(driver, homePage.netPriceTable);

		cm.captureElementScreenShot(driver, homePage.netPriceTab, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}
	
	//=============================================================================================================

	@Test(priority = 4)
	public void TC_04_Validate_Content_Manangement_Tab() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();

		Reporter.log(cm.ReporterText("TestCase : " + ScreenshotName));

		String expectedList = "Page Configurations, Content Editor, Next Steps";

		cm.mouseOver(driver, homePage.contentManagmentTab,"ContentManagementTab");

		ArrayList<String> expect = cm.createArrayList(expectedList);
		ArrayList<String> actual = cm.linkFinder(driver,homePage.contentManagmentTabTable);

		cm.captureElementScreenShot(driver, homePage.contentManagmentTab, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");

		Assert.assertEquals(expect, actual);
	}

	//=============================================================================================================
	
	@Test(priority=5)
	public void TC_05_Validate_SignOut_Link() {
		String ScreenshotName = new Object(){}.getClass().getEnclosingMethod().getName();
		Reporter.log(cm.ReporterText("TestCase : "+ScreenshotName));
		
		co.click(homePage.SignOutLink, "Clicking on the SignOut Link");
		co.pause(2500);
		globalPage= new GlobalElements().globalElementsInit(driver);
		
		actual=globalPage.LogoutMessage.getText();
		expected="You have successfully been logged out. Please go here to log back in.";
		msg="User Not Logout Succefully";
		
		cm.captureElementScreenShot(driver, globalPage.LogoutMessage, ScreenshotName, cm.basepath());
		Reporter.log(cm.ReporterLink(ScreenshotName));
		System.out.println("Asserting the test case");
		Assert.assertEquals(actual,expected , msg);
		}
	//=============================================================================================================

	@BeforeMethod
	public void BeforeMethod() {
		homePage= new HomePage().homePageInit(driver);
		globalPage= new GlobalElements().globalElementsInit(driver);
		passwordPage=new ChangePasswordPage().passwordPageInit(driver);
	}

	@AfterMethod
	public void AfterMethod() {
	}



	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {
	browserName =  browser;
	System.out.println(className+" Before Class");

	driver = cm.getBrowser(browser);
	
	driver.get(homeServlet.environmentUrl());
	driver.manage().window().maximize();
	co.login(driver, homeServlet);
	}

	@AfterClass
	public void afterClass() {
	System.out.println(className+" After Class");
	co.browserClose(driver);
	}

	
}
